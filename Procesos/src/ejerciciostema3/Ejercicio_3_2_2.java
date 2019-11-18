package ejerciciostema3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejercicio_3_2_2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		//CLIENTE
		
		//Ponemos los parametros necesarios para conectarnos al puerto 6000 del localhost
		String host="localhost";
		int puerto=6000;
		System.out.println("Cliente 1");
		//Nos conectamos a ese puerto
		Socket cliente=new Socket(host,puerto);
		InetAddress i=cliente.getInetAddress();
		//Obtenemos sus datos (puerto local, remoto, etc)
		System.out.println("Puerto local: "+cliente.getLocalPort());
		System.out.println("Puerto remoto: "+cliente.getPort());
		System.out.println("Nombre Host/IP: "+cliente.getInetAddress());
		System.out.println("Host Remoto: "+i.getHostName().toString());
		System.out.println("IP Host Remoto: "+i.getHostAddress().toString());
		//Cerramos el socket...
		cliente.close();
		
		//...e iniciamos un segundo cliente
		System.out.println("\nCliente 2");
		Socket cliente2=new Socket(host,puerto);
		InetAddress i2=cliente.getInetAddress();
		System.out.println("Puerto local: "+cliente2.getLocalPort());
		System.out.println("Puerto remoto: "+cliente2.getPort());
		System.out.println("Nombre Host/IP: "+cliente2.getInetAddress());
		System.out.println("Host Remoto: "+i2.getHostName().toString());
		System.out.println("IP Host Remoto: "+i2.getHostAddress().toString());
		cliente2.close();
		
		//Si todo sale bien, y hemos iniciado el servidor antes, nos saldrán todos los datos
		//que hemos pedido
	}

}
