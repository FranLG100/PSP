package ejemplostema2parte2;

public class Contador {

	private int c=0;
	
	public Contador(int c){
		this.c=c;
	}
	
	public void incrementa() {
		c=c+1;
	}
	
	public void decrementa() {
		c=c-1;
	}
	
	public int valor() {
		return c;
	}
}