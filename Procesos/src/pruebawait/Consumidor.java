package pruebawait;

public class Consumidor extends Thread{

	private String n;
	private Cola c;
	
	public Consumidor(String n, Cola c) {
		this.c=c;
		this.n=n;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		while(true) {
			try {
				c.get(n);
				System.out.println(n+" se ha llevado las tartas");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
