package ejemplostema2;

public class HiloJoin extends Thread {

	private String nom;
	private int n;
	
	public HiloJoin(String nom, int n) {
		this.nom=nom;
		this.n=n;
	}
	
	public void run() {
		for (int i = 0; i <= n; i++) {
			System.out.println(nom+": "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin bucle: "+nom);
	}
}
