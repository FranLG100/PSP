package ejerciciostema3parte2.ejercicio3_10;
import java.io.*;
import java.net.*;
public class ServidorAdivina {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//SERVIDOR
		//Puerto del servidor
		ServerSocket servidor=new ServerSocket(6001);
		System.out.println("Servidor iniciado...");
		
		//Se genera numero aleatorio a adivinar
		int numero=(int)(1+25*Math.random());
		System.out.println("NUMERO A ADIVINAR=> "+numero);
		
		//Se crea el objeto compartido entre todos los jugadores
		ObjetoCompartido objeto=new ObjetoCompartido(numero);
		//Id incremental del jugador que se conecta
		int id=0;
		
		//Mientras funcione, ira atendiendo jugadores (incrementandoles el id)
		while(true) {
			Socket cliente= new Socket();
			cliente=servidor.accept();
			id++;
			HiloServidorAdivina hilo=new HiloServidorAdivina(cliente, objeto, id);
			hilo.start();
		}
	}

}
