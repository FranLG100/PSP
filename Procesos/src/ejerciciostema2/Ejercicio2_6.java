package ejerciciostema2;

public class Ejercicio2_6 extends Thread {

	Ejercicio2_6(String nom){
		this.setName(nom);
	}
	
	public void run() {
		System.out.println("Ejecutando ["+getName()+"]");
		for (int i = 0; i <=5; i++) {
			System.out.println("\t("+getName()+": "+i+")");
		}
	}
	
	public static void main(String[] args) {
		Ejercicio2_6 h1=new Ejercicio2_6("Uno");
		Ejercicio2_6 h2=new Ejercicio2_6("Dos");
		Ejercicio2_6 h3=new Ejercicio2_6("Tres");
		Ejercicio2_6 h4=new Ejercicio2_6("Cuatro");
		Ejercicio2_6 h5=new Ejercicio2_6("Cinco");
		
		h1.setPriority(1);
		h2.setPriority(3);
		h3.setPriority(5);
		h4.setPriority(7);
		h5.setPriority(10);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
	}
}
