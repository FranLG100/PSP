package ejemplostema2parte2;

public class ColaSincronizada {

	private int numero;
	private boolean disponible=false;
	
	public synchronized int get() {
		while(!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println("Se consume: "+numero);
		disponible=false;
		notify();
		return numero;
	}
	
	public synchronized void put(int valor) {
		while(disponible) {
			try {
				
				wait();
			} catch (InterruptedException e) {
			}
		}
			//System.out.println("Se produce: "+valor);
			numero=valor;
			disponible=true;
			notify();
		}
	}

