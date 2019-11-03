package pruebawait;

public class Pistola {

	private boolean apuntando=false;
	
	public Pistola() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void disparar(int i) throws InterruptedException {
		while(!apuntando) {
			wait();
		}
		System.out.println("Se ha disparado la bala "+i);
		apuntando=false;
		notify();
	}
	
	public synchronized void apuntar(int i) throws InterruptedException {
		while(apuntando) {
			wait();
		}
		System.out.println("Se ha cargado la bala "+i);
		apuntando=true;
		notify();
	}
}
