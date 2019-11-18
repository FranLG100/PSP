package ejerciciostema3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Ejercicio_3_6_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//SERVIDOR
		
		//En esta ocasión, trabajaremos recibiendo datagramas
		
		//En el puerto 12345
		DatagramSocket socket=new DatagramSocket(12345);
		
		//El servidor esperará el datagrama
		System.out.println("Servidor esperando datagrama...");
		DatagramPacket recibo;
		String mensaje="";
		do{
			//Nos preparamos para recibirlo
			byte[] bufer=new byte[1024];
			recibo=new DatagramPacket(bufer, bufer.length);
			//Lo recibimos
			socket.receive(recibo);
			
			//Escribimos el mensaje recibido
			mensaje=new String(recibo.getData()).trim();
			System.out.println("Servidor recibe: "+mensaje);
			
			//Cogemos el puerto de quien nos lo ha enviado
			InetAddress IPOrigen=recibo.getAddress();
			int puerto=recibo.getPort();
			
			//Pasamos el texto recibido a mayusculas
			String respuesta=mensaje.toUpperCase();
			byte[] enviados=new byte[1024];
			enviados=respuesta.getBytes();
			
			//Y lo devolvemos de vuelta al cliente
			DatagramPacket envio=new DatagramPacket(enviados, enviados.length,IPOrigen,puerto);
			socket.send(envio);
			
			//Hasta que recibamos un asterisco
		}while(!mensaje.equalsIgnoreCase("*"));
		
		//Tras eso, cerramos conexión
		System.out.println("Cerrando conexion...");
		socket.close();
	}

}
