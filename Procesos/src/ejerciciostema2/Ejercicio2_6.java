package ejerciciostema2;

public class Ejercicio2_6 extends Thread {

	//Este ejercicio trata basicamente de jugar con las prioridades y 
	//observar como esto afecta a los hilos
	Ejercicio2_6(String nom){
		this.setName(nom);
	}
	
	//Los hilos, lo unico que haran, es contar hasta cinco
	public void run() {
		System.out.println("Ejecutando ["+getName()+"]");
		for (int i = 0; i <=5; i++) {
			System.out.println("\t("+getName()+": "+i+")");
		}
	}
	
	public static void main(String[] args) {
		//Le ponemos nombre a los hilos
		Ejercicio2_6 h1=new Ejercicio2_6("Uno");
		Ejercicio2_6 h2=new Ejercicio2_6("Dos");
		Ejercicio2_6 h3=new Ejercicio2_6("Tres");
		Ejercicio2_6 h4=new Ejercicio2_6("Cuatro");
		Ejercicio2_6 h5=new Ejercicio2_6("Cinco");
		
		//Les establecemos prioridades
		h1.setPriority(1);
		h2.setPriority(3);
		h3.setPriority(5);
		h4.setPriority(7);
		h5.setPriority(10);
		
		//Los iniciamos
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		
		//Los hilos intentaran cumplir con la prioridad.
		//Pero vamos, que no se asegura que se cumplan. Puede,
		//perfectamente, acabar ultimo el primero y primero el ultimo.
		
		//Pero lo intentaran.
	}
}
