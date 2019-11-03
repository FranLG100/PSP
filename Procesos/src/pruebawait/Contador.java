package pruebawait;

public class Contador {

	private int cont=0;
	private boolean libre=true;
	
	public synchronized void anhade(String s) throws InterruptedException {
			cont+=3;
			System.out.println(s+" ha entrado y ha puesto el contador a "+cont);
			Thread.sleep(1000);
			System.out.println(s+" sale y deja su hueco");
			notify();
	}
	
	public synchronized void toma(String s) throws InterruptedException {
		if(cont>0) {
			cont--;
			System.out.println(s+" ha entrado y se ha llevado 1, pone el contador a "+cont);
		}else {
			System.out.println(s+" tiene que esperar, se pone a dormir");
			wait();
		}
	}
	
	public int getCuenta() {
		return cont;
	}
}
