package ejerciciostema3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Ejercicio_3_6_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DatagramSocket socket=new DatagramSocket(12345);
		
		System.out.println("Servidor esperando datagrama...");
		DatagramPacket recibo;
		String mensaje="";
		do{
			byte[] bufer=new byte[1024];
			recibo=new DatagramPacket(bufer, bufer.length);
			socket.receive(recibo);
			
			mensaje=new String(recibo.getData()).trim();
			System.out.println("Servidor recibe: "+mensaje);
			
			InetAddress IPOrigen=recibo.getAddress();
			int puerto=recibo.getPort();
			
			String respuesta=mensaje.toUpperCase();
			byte[] enviados=new byte[1024];
			enviados=respuesta.getBytes();
			
			DatagramPacket envio=new DatagramPacket(enviados, enviados.length,IPOrigen,puerto);
			socket.send(envio);
		}while(!mensaje.equalsIgnoreCase("*"));
		
		System.out.println("Cerrando conexion...");
		socket.close();
	}

}
