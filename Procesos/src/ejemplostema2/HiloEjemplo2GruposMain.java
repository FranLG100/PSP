package ejemplostema2;

public class HiloEjemplo2GruposMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadGroup grupo = new ThreadGroup("Grupo de hilos");
		HiloEjemplo2Grupos h = new HiloEjemplo2Grupos();
		
		Thread h1= new Thread(grupo,h,"Hilo 1");
		Thread h2= new Thread(grupo,h,"Hilo 2");
		Thread h3= new Thread(grupo,h,"Hilo 3");
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("3 HILOS CREADOS...");
		System.out.println("Hilos activos: "+Thread.activeCount());
		
	}

}
