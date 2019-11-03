package pruebawait;

public class Barbero extends Thread {

	private Barberia b;
	
	public Barbero(Barberia b) {
		this.b=b;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		while(true) {
			try {
				b.afeitar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
