package ejerciciotema2parte2;

import ejemplostema2parte2.Contador;

public class HiloASincronizadoRunnable implements Runnable{
	private Contador contador;
	private String name;
	
	public HiloASincronizadoRunnable(String n, Contador c) {
		this.name=n;
		contador=c;
	}
	
	public String getName(){
		return name;
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
