package ejemplostema2;

public class HiloEjemploInterrup extends Thread {
	public void run() {
		
			try {
				while(!isInterrupted()) {
					System.out.println("En el hilo");
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("HA OCURRIDO UNA EXCEPCION");
			}
			
			System.out.println("FIN DE HILO");
		}
	
	public void interrumpir() {
		interrupt();
	}
	
	public static void main (String[] args) {
		HiloEjemploInterrup h=new HiloEjemploInterrup();
		h.start();
		for (int i = 0; i < 1000000000; i++);
		h.interrumpir();
	}
	}

