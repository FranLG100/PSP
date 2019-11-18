package ejerciciostema3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio_3_2_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//SERVIDOR
		
		//Creamos el servidor
		String host="localhost";
		//Los clientes se conectaran al puerto 6000
		int puerto=6000;
		ServerSocket servidor=new ServerSocket(puerto);
		
		System.out.println("Escuchando en puerto: "+servidor.getLocalPort());
		
		//Esperamos que se conecte un cliente. Hasta que no se conecte, el programa
		//no seguirá avanzando.
		System.out.println("Esperando primer cliente...");
		Socket cliente1=servidor.accept();
		//Cuando se conecte, veremos cual es su puerto.
		System.out.println("Puerto del cliente 1: "+cliente1.getPort());
		
		//Repetimos el proceso para el segundo cliente
		System.out.println("Esperando segundo cliente...");
		Socket cliente2=servidor.accept();
		System.out.println("Puerto del cliente 2: "+cliente2.getPort());
		servidor.close();
	}

}
