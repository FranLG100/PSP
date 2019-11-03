package pruebawait;

public class Descargar extends Thread {

	private Pistola p;
	
	public Descargar(Pistola p) {
		this.p=p;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				p.disparar(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
