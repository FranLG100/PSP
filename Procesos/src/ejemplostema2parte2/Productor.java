package ejemplostema2parte2;

public class Productor extends Thread {

	private Cola cola;
	private int n;
	
	public Productor(Cola c, int n) {
		cola=c;
		this.n=n;
	}
	
	
	//Produce para la cola
	//'Pone en la mesa'
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
