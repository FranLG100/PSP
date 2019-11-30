package ejerciciostema3parte2.ejercicio3_10;
import java.io.*;
import java.net.*;
public class ServidorAdivina {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket servidor=new ServerSocket(6001);
		System.out.println("Servidor iniciado...");
		
		int numero=(int)(1+25*Math.random());
		System.out.println("NÚMERO A ADIVINAR=> "+numero);
		
		ObjetoCompartido objeto=new ObjetoCompartido(numero);
		int id=0;
		
		while(true) {
			Socket cliente= new Socket();
			cliente=servidor.accept();
			id++;
			HiloServidorAdivina hilo=new HiloServidorAdivina(cliente, objeto, id);
			hilo.start();
		}
	}

}
