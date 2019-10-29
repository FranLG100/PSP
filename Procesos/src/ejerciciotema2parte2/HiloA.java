package ejerciciotema2parte2;

import ejemplostema2parte2.Contador;

public class HiloA extends Thread{
	private Contador contador;
	
	public HiloA(String n, Contador c) {
		setName(n);
		contador=c;
	}
	
	public void run() {
		for (int i = 0; i < 5000; i++) {
			contador.incrementa();
			}
		System.out.println(getName()+" contador vale "+contador.valor());
	}
}
