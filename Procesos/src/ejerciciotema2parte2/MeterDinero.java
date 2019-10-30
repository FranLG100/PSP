package ejerciciotema2parte2;

public class MeterDinero extends Thread{

	private Saldo c;
	String nom;
	
	public MeterDinero(String n, Saldo c) {
		super(n);
		this.c=c;
	}
	
	public void run() {
		for (int i = 1; i <= 4; i++) {
			c.sumarDinero(10, getName());
		}
	}
}
