package filosofos;

public class Silla {

	//Numero de filosofos - 1
	//Si hay n-1 filosofos sentados, al menos uno puede cenar.
	private int sillaLibre=4;
	
	//Coge silla para sentarse a la mesa
	public synchronized void cogerSilla(int i) throws InterruptedException {
		while(sillaLibre==0)
			wait();
		System.out.println("Filosofo "+i+" coge una silla");
		sillaLibre--;
	}
	
	//Deja la silla libre
	public synchronized void soltarSilla(int i) {
		sillaLibre++;
		System.out.println("Filosofo "+i+" suelta una silla");
		notify();
	}
}
