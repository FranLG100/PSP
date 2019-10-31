package ejerciciotema2parte2;

public class ColaSincronizada {

	private int numero;
	private boolean disponible=false;
	private String cadena;
	
	public synchronized String get() {
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
		return cadena;
	}
	
	public synchronized void put(String cad) {
		while(disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
			//System.out.println("Se produce: "+valor);
			this.cadena=cad;
			disponible=true;
			notify();
		}
	}

