package pruebawait;

public class Cargar extends Thread {

	private Pistola p;
	
	public Cargar(Pistola p) {
		this.p=p;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				p.apuntar(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
