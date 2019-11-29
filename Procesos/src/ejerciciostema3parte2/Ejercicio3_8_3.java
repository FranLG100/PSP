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

		InetAddress destino=InetAddress.getLocalHost();
		int port=6001;
		
		int numeroPuerto=6000;
		DatagramSocket servidor=new DatagramSocket(numeroPuerto);
		
		System.out.println("Esperando al cliente...");
		int numero=0;	
		byte[] recibidos=new byte[1024];
		
		
		
		
		do{
			System.out.println("Esperando datagrama...");
			DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
			servidor.receive(recibo);

			ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
			ObjectInputStream in=new ObjectInputStream(bais);
			Numeros n=(Numeros) in.readObject();
			System.out.println("RECIBIDO: "+n.getNumero());
			numero=n.getNumero();
			in.close();
			
			n.setCuadrado(numero*numero);
			n.setCubo(numero*numero*numero);

			ByteArrayOutputStream bs=new ByteArrayOutputStream();
			ObjectOutputStream out=new ObjectOutputStream(bs);
			out.writeObject(n);
			out.close();
			
			byte[] mensaje=bs.toByteArray();
			
			
			
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,port);
			servidor.send(envio);
			System.out.println("Envio: "+n.getCuadrado()+"    "+n.getCubo());
			
		}while(numero>0);
		
		servidor.close();
	}

}
