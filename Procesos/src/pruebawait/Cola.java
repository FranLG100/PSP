package pruebawait;

public class Cola {

	private int contador=0;
	private boolean disponible=false;
	
	public synchronized void put(String n,int valor) throws InterruptedException {
		while(disponible) {
			wait();
		}
		//System.out.println(n+" se despierta y pone "+valor+" en la cola");
		this.contador=valor;
		disponible=true;
		
		notify();
	}
	
	public synchronized void get(String n) throws InterruptedException {
			while(!disponible) {
				//System.out.println(n+" tiene que esperar");
				wait();	
			}
			
			disponible=false;
			contador=0;
			System.out.println(n+" entra y se lleva los 10 productos");
			notify();
			//Thread.sleep(1000);
			
			
		}
	
	public boolean getDisponibilidad(){
		return disponible;
	}
}
