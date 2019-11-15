package ejemplostema3;

import java.io.IOException;
import java.net.*;

public class EjemploSocket2 {

	public static void main(String[] args) throws IOException {
		
		String host="localhost";
		int puerto=6000;
		ServerSocket servidor=new ServerSocket(puerto);
		Socket cliente=new Socket(host,puerto);
		
		InetAddress i=cliente.getInetAddress();
		System.out.println("Puerto local: "+cliente.getLocalPort());
		System.out.println("Puerto remoto: "+cliente.getPort());
		System.out.println("Nombre Host/IP: "+cliente.getInetAddress());
		System.out.println("Host Remoto: "+i.getHostName().toString());
		System.out.println("IP Host Remoto: "+i.getHostAddress().toString());
		
		cliente.close();
	}
}
