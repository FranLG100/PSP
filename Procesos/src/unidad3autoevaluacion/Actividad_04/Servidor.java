package unidad3autoevaluacion.Actividad_04;
import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket servidor;
		servidor=new ServerSocket(6000);
		System.out.println("Servidor iniciado...");
		int id=1;
		
		while(true) {
			Socket cliente=new Socket();
			cliente = servidor.accept();
			HiloServidor hilo=new HiloServidor(cliente,id);
			id++;
			hilo.start();
		}
		
	}

}
