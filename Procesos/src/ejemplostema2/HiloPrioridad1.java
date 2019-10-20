package ejemplostema2;

public class HiloPrioridad1 extends Thread {

	private int c=0;
	private boolean stopHilo=false;
	private String nombre;
	
	public HiloPrioridad1 (String nombre) {
		this.nombre=nombre;
	}
	
	public int getContador() {
		return c;
	}
	
	public void pararHilo() {
		stopHilo=true;
	}
	
	public void run() {
		while(!stopHilo) {
			try {
				sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c++;
		}
		System.out.println("Fin de hilo "+nombre);
	}
	
}
