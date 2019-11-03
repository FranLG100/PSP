package unidad2autoevaluacion;

public class Consumidor extends Thread{

	private String nombre;
	private char caracter;
	private ColaPalabras c;
	
	public Consumidor(String nombre, ColaPalabras c) {
		this.nombre=nombre;
		this.c=c;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		while(!c.getFin()) {
			try {
				caracter=c.getPalabra();
				System.out.println(nombre+" consume "+caracter);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Fin consumidor");
				interrupt();
			}
		}
	}
}
