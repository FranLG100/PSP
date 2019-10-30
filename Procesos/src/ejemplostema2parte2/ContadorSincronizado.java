package ejemplostema2parte2;

public class ContadorSincronizado {
	
	private int c=0;
	
	public synchronized void incrementa() {
		c=c++;
	}
	
	public synchronized void decrementa() {
		c=c--;
	}
	
	public synchronized int valor() {
		return c;
	}

}
