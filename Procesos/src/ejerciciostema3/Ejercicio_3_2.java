package ejerciciostema3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio_3_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//REVISAR EJERCICIO
		String host="localhost";
		int puerto=6000;
		ServerSocket servidor=new ServerSocket(puerto);
		System.out.println("Escuchando en puerto: "+servidor.getLocalPort());
		
		System.out.println("Cliente 1");
		Socket cliente=new Socket(host,puerto);
		InetAddress i=cliente.getInetAddress();
		System.out.println("Puerto local: "+cliente.getLocalPort());
		System.out.println("Puerto remoto: "+cliente.getPort());
		System.out.println("Nombre Host/IP: "+cliente.getInetAddress());
		System.out.println("Host Remoto: "+i.getHostName().toString());
		System.out.println("IP Host Remoto: "+i.getHostAddress().toString());
		
		cliente.close();
		servidor.close();
	}

}
