package pruebawait;

public class ClienteBarberia extends Thread {

	private String nombre;
	private Barberia b;
	private boolean atendido=false;
	private boolean sentado=false;
	
	public ClienteBarberia(String nombre,Barberia b) {
		this.nombre=nombre;
		this.b=b;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void run() {
		while(!atendido) {
			try {
				b.hacerCola(nombre, this);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setAtendido() {
		atendido=true;
	}
	
	public void setSentado() {
		sentado=true;
	}
	
	public boolean getSentado() {
		return sentado;
	}
}
