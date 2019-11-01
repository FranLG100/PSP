package unidad2autoevaluacion;

import java.io.File;
import java.io.IOException;

import utilesFran.Amadeus;

public class Hilo_E03 extends Thread {

	Amadeus amadeus;
	File archivo;
	
	public Hilo_E03(File archivo) {
		// TODO Auto-generated constructor stub
		this.archivo=archivo;
	}
	
	public void run() {
		amadeus=new Amadeus();
		int nPalabras=0;
		long t_comienzo,t_fin;
		t_comienzo=System.currentTimeMillis();
		try {
			nPalabras=amadeus.cuentaPalabras(archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t_fin=System.currentTimeMillis();
		long tiempoTotal=t_fin-t_comienzo;
		System.out.println("El archivo tiene "+nPalabras+" palabras. Ha tardado "+tiempoTotal+"ms");
	}
}
