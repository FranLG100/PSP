package ejemplostema3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EjemploSocket1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int puerto=6000;
		ServerSocket Servidor=new ServerSocket(puerto);
		System.out.println("Escuchando en "+Servidor.getLocalPort());
		
		Socket cliente1= Servidor.accept();
		Socket cliente2=Servidor.accept();
		
		Servidor.close();
	}

}
