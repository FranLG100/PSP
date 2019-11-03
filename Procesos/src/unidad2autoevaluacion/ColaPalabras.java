package unidad2autoevaluacion;

import java.util.ArrayList;

public class ColaPalabras {

	private char cadena;
	private boolean disponible;
	private boolean finalizado=false;
	private ArrayList<Character> caracteres=new ArrayList<Character>();
	
	public ColaPalabras() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void putPalabra(char cad) throws InterruptedException {
		while(disponible) {
			wait();
		}
		cadena=cad;
		disponible=true;
		notify();
	}
	
	public synchronized char getPalabra() throws InterruptedException {
		while(!disponible) {
			wait();
		}
		notify();
		disponible=false;
		return cadena;
	}
	
	public boolean getFin() {
		return finalizado;
	}
	
	public void acabar() {
		finalizado=true;
	}
}
