package ejerciciotema2parte2;

import ejemplostema2parte2.Contador;

public class HiloARunnable implements Runnable{
	private Contador contador;
	private String name;
	
	public HiloARunnable(String n, Contador c) {
		this.name=n;
		contador=c;
	}
	
	public String getName(){
		return name;
	}
	
	public void run() {
		for (int i = 0; i < 5000; i++) {
			contador.incrementa();
			}
		System.out.println(getName()+" contador vale "+contador.valor());
	}
}
