package ejemplostema2parte2;

public class ConsumidorSync extends Thread {

	private ColaSincronizada cola;
	private int n;
	
	public ConsumidorSync(ColaSincronizada c, int n) {
		// TODO Auto-generated constructor stub
		this.cola=c;
		this.n=n;
	}
	
	public void run() {
		int valor=0;
		for (int i = 0; i < 5; i++) {
			valor=cola.get();
			System.out.println(i+" =>Consumidor: "+n+", consume: "+valor);
		}
	}
}
