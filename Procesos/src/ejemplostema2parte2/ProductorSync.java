package ejemplostema2parte2;

public class ProductorSync extends Thread {

	private ColaSincronizada cola;
	private int n;
	
	public ProductorSync(ColaSincronizada c, int n) {
		cola=c;
		this.n=n;
	}
	
	
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			cola.put(i);
			System.out.println(i+" => Productor : "+n+" produce: "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
