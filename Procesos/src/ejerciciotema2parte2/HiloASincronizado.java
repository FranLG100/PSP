package ejerciciotema2parte2;

import ejemplostema2parte2.Contador;

public class HiloASincronizado extends Thread{
	private Contador contador;
	
	public HiloASincronizado(String n, Contador c) {
		setName(n);
		contador=c;
	}
	
	public void run() {
		synchronized(contador) {
		for (int i = 0; i < 5000; i++) {
			contador.incrementa();
			}
		System.out.println(getName()+" contador vale "+contador.valor());
		}
	}
}
