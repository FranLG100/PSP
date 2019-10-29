package ejemplostema2parte2;

public class HiloB extends Thread{
	private Contador contador;
	
	public HiloB(String n, Contador c) {
		setName(n);
		contador=c;
	}
	
	public void run() {
		synchronized(contador) {
		for (int i = 0; i < 300; i++) {
			contador.decrementa();
		}
		System.out.println(getName()+" contador vale "+contador.valor());
	}
	}
}
