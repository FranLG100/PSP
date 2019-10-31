package ejerciciotema2parte2;

public class ColaSincronizada {

	private int numero;
	private boolean disponible=false;
	private String cadena;
	
	//Mientras no este disponible (no haya algo en la cola), espera.
	//Cuando algo llega a la cola, sale del bucle.
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
	
	//Mientras este disponible (haya algo en la cola), espera.
	//Cuando la cola se vacia, sale del bucle, se mete en la cola el siguiente valor, y vuelve
	//a estar disponible
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

