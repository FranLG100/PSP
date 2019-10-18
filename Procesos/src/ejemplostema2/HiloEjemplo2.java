package ejemplostema2;

public class HiloEjemplo2 extends Thread {
	
	public void run() {
		System.out.println(
				"Dentro del Hilo : "+Thread.currentThread().getName()+
				"\n\tPrioridad: "+Thread.currentThread().getPriority()+
				"\n\tID: "+Thread.currentThread().getId()+
				"\n\tHilosActivos: "+Thread.currentThread().activeCount()
				);
	}
}
