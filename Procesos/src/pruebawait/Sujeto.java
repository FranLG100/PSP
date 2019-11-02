package pruebawait;

public class Sujeto extends Thread {

	private String nombre;
	private Pasteleria c;
	private boolean cocinero;
	
	public Sujeto(String nombre,Pasteleria c,boolean cocinero) {
		this.nombre=nombre;
		this.c=c;
		this.cocinero=cocinero;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		while(true) {
		if(cocinero) {
			try {
				c.cocinar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println(nombre+" va a intentar coger un trozo de tarta");
			try {
				c.consumir(nombre);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}
	
}
