package unidad3autoevaluacion.Actividad_06;
import java.io.*;
import java.net.*;
public class ServidorAdivina {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket servidor=new ServerSocket(6001);
		System.out.println("Servidor iniciado...");
		
		String[][] tablero=new String[3][4];
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j]="NADA";
			}
		}
		
		tablero[0][0]="CRUCERO";
		tablero[1][2]="ENTRADAS";
		tablero[2][0]="MASAJE";
		tablero[2][3]="1000E";
		
		
		//int numero=(int)(1+25*Math.random());
		//System.out.println("NUMERO A ADIVINAR=> "+numero);
		
		ObjetoCompartido objeto=new ObjetoCompartido(tablero);
		int id=0;
		
		while(true) {
			Socket cliente= new Socket();
			cliente=servidor.accept();
			id++;
			HiloServidorAdivina hilo=new HiloServidorAdivina(cliente, objeto, id,objeto.getPremios());
			hilo.start();
		}
	}

}
