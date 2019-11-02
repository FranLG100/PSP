package filosofos;

public class Tenedor {

	private int id;
	private boolean libre=true;
	
	public Tenedor(int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	
	//Metodo para coger el tenedor (si esta libre, si no, espera)
	public synchronized void cogerTenedor(int i) throws InterruptedException {
		while(!libre)
			wait();
		System.out.println("Filosofo "+i+" coge tenedor "+id);
		libre=false;
	}
	
	//Suelta el tenedor (lo deja libre)
	public synchronized void soltarTenedor(int i) {
		libre=true;
		System.out.println("Filosofo "+i+" suelta el tenedor "+id);
		notify();
	}
}
