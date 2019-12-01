package unidad3autoevaluacion.Actividad_07;
import java.io.*;
import java.net.*;
public class ServidorAdivina {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket servidor=new ServerSocket(6001);
		System.out.println("Servidor iniciado...");
		
		
		int[] numero= new int[]{0,9,3,6};
		System.out.println("NUMERO A ADIVINAR=> "+numero[0]+" "+numero[1]+" "+numero[2]+" "+numero[3]);
		
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
