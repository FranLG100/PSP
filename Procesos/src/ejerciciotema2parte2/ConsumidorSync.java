package ejerciciotema2parte2;

public class ConsumidorSync extends Thread {

	private ColaSincronizada cola;
	private int n;
	
	public ConsumidorSync(ColaSincronizada c, int n) {
		// TODO Auto-generated constructor stub
		this.cola=c;
		this.n=n;
	}
	
	public void run() {
		String valor="";
		for (int i = 0; i < 25; i++) {
			valor=cola.get();
			System.out.println("\t"+i+" =>Consumidor: "+n+", consume: "+valor);
		}
	}
}
