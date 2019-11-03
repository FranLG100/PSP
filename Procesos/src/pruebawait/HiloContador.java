package pruebawait;

public class HiloContador extends Thread {

	private String nombre;
	private Contador c;
	
	public HiloContador(String n, Contador c) {
		this.nombre=n;
		this.c=c;
	}
	
	public void run() {
		while(true) {
			try {
				if(c.getCuenta()>0) {
					c.toma(nombre);
					Thread.sleep(1000);
				}else {
					c.anhade(nombre);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
}
