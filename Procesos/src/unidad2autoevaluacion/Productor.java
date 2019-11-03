package unidad2autoevaluacion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import utilesFran.Amadeus;

public class Productor extends Thread {

	private File archivo;
	private ColaPalabras c;
	private ArrayList<Character> caracteres;
	private Amadeus amadeus=new Amadeus();
	private ArrayList<Consumidor> t;
	
	public Productor(File archivo, ColaPalabras c, ArrayList<Consumidor> t) throws IOException {
		this.archivo=archivo;
		this.c=c;
		caracteres=amadeus.obtenerCaracterPorCaracter(archivo);
		this.t=t;
	}
	
	public void run() {
		int i=0;
		while(i<caracteres.size()) {
			try {
				c.putPalabra(caracteres.get(i));
				System.out.println("El productor ha puesto "+caracteres.get(i));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		c.acabar();
		for (Consumidor consumidor : t) {
			consumidor.interrupt();
		}
		System.out.println("Fin hilo Productor");
	}
}
