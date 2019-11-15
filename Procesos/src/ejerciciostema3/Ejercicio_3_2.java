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
		Socket cliente1=servidor.accept();
		System.out.println(cliente1.getPort());
		Socket cliente2=servidor.accept();
		System.out.println(cliente2.getPort());
		servidor.close();
	}

}
