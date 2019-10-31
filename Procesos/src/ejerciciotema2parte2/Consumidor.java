package ejerciciotema2parte2;

import ejemplostema2parte2.Cola;

public class Consumidor extends Thread {

	private Cola cola;
	private int n;
	
	public Consumidor(Cola c, int n) {
		// TODO Auto-generated constructor stub
		this.cola=c;
		this.n=n;
	}
	
	public void run() {
		int valor=0;
		for (int i = 0; i < 5; i++) {
			valor=cola.get();
			System.out.println(i+" =>Consumidor: "+n+", consume: "+valor);
			try {
				sleep(1050);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
