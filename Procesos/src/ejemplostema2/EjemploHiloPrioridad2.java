package ejemplostema2;

public class EjemploHiloPrioridad2 extends Thread {

	EjemploHiloPrioridad2(String nom){
		this.setName(nom);
	}
	
	public void run() {
		System.out.println("Ejecutando ["+getName()+"]");
		for (int i = 0; i <=5; i++) {
			System.out.println("\t("+getName()+": "+i+")");
		}
	}
	
	public static void main(String[] args) {
		EjemploHiloPrioridad2 h1=new EjemploHiloPrioridad2("Uno");
		EjemploHiloPrioridad2 h2=new EjemploHiloPrioridad2("Dos");
		EjemploHiloPrioridad2 h3=new EjemploHiloPrioridad2("Tres");
		EjemploHiloPrioridad2 h4=new EjemploHiloPrioridad2("Cuatro");
		EjemploHiloPrioridad2 h5=new EjemploHiloPrioridad2("Cinco");
		
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
