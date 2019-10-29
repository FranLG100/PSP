package ejemplostema2parte2;

public class HiloASincronizado extends Thread{
	private Contador contador;
	
	public HiloASincronizado(String n, Contador c) {
		setName(n);
		contador=c;
	}
	
	public void run() {
		synchronized(contador) {
		for (int i = 0; i < 300; i++) {
			contador.incrementa();
			}
		System.out.println(getName()+" contador vale "+contador.valor());
		}
	}
}
