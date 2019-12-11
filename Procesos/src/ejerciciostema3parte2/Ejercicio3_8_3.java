package ejerciciostema3parte2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio3_8_3 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		//Este script funcionara como Servidor
		//Es una replica del ejercicio 3_7, pero hecho en UDP
		InetAddress destino=InetAddress.getLocalHost();
		
		//Puerto al que enviamos
		int port=6001;
		//Puerto al que recibimos
		int numeroPuerto=6000;
		DatagramSocket servidor=new DatagramSocket(numeroPuerto);
		
		System.out.println("Esperando al cliente...");
		int numero=0;	
		byte[] recibidos=new byte[1024];
		
		//Repetimos el bucle hasta que el numero sea menor o igual a 0
		do{
			//Esperamos a recibir un ddatagrama
			System.out.println("Esperando datagrama...");
			DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
			//Lo recibimos
			servidor.receive(recibo);

			//Lo convertimos a objeto y lo mostramos
			ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
			ObjectInputStream in=new ObjectInputStream(bais);
			Numeros n=(Numeros) in.readObject();
			System.out.println("RECIBIDO: "+n.getNumero());
			numero=n.getNumero();
			in.close();
			
			//Lo elevamos al cuadrado y al cubo, y sobreescribimos el objeto
			n.setCuadrado(numero*numero);
			n.setCubo(numero*numero*numero);

			//Lo preparamos para enviarlo
			ByteArrayOutputStream bs=new ByteArrayOutputStream();
			ObjectOutputStream out=new ObjectOutputStream(bs);
			out.writeObject(n);
			out.close();
			
			byte[] mensaje=bs.toByteArray();
			
			
			//Preparamos el datagrama
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,port);
			//Lo enviamos
			servidor.send(envio);
			System.out.println("Envio: "+n.getCuadrado()+"    "+n.getCubo());
			
		}while(numero>0);
		
		//Cerramos
		servidor.close();
	}

}
