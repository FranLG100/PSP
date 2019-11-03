package pruebawait;

public class Productor extends Thread{

	private String n;
	private Cola c;
	
	public Productor(String n, Cola c) {
		this.c=c;
		this.n=n;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		while(true) {
			try {
				c.put(n, 10);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
