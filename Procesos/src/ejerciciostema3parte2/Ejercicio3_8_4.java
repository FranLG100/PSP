package ejerciciostema3parte2;
import java.io.*;
import java.net.*;

public class Ejercicio3_8_4 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		//Este script funcionara como Cliente
		BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
		
		InetAddress destino=InetAddress.getLocalHost();
		//Puerto al que enviaremos
		int puerto=6000;
		int numero=0;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		//Puerto propio (6001)
		DatagramSocket cliente=new DatagramSocket(6001);
	
		
		do {
			//El cliente escribe un numero que enviara al servidor
			System.out.println("Escriba un numero: ");
			numero=Integer.parseInt(entrada.readLine());
			
			//Creamos el objeto
			Numeros dato=new Numeros(numero, 0, 0);
			
			//Lo preparamos para su envio
			ByteArrayOutputStream bs=new ByteArrayOutputStream();
			ObjectOutputStream out=new ObjectOutputStream(bs);
			out.writeObject(dato);
			out.close();
			
			byte[] mensaje=bs.toByteArray();
			
			//Preparamos el datagrama
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,puerto);
			//Lo enviamos
			cliente.send(envio);
			
			byte[] recibidos=new byte[1024];
			
			//Ahora, esperamos la respuesta del servidor
			System.out.println("Esperando datagrama...");
			DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
			//Lo recibimos
			cliente.receive(recibo);

			//Lo convertimos a objeto, y ejecutamos sus metodos
			ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
			ObjectInputStream in=new ObjectInputStream(bais);
			Numeros n=(Numeros) in.readObject();
			System.out.println(n.getCuadrado()+" - - - "+n.getCubo());
			
			in.close();

		}while(numero>0);

		//Cerramos una vez hayamos introducido un numero menor o igual a 0
		cliente.close();
	}

}
