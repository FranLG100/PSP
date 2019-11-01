package unidad2autoevaluacion;

public class Hilo_E02 implements Runnable{

	String n;
	public Hilo_E02(String n) {
		this.n=n;
	}
	
	public void run() {
		try {
			Thread.sleep(Thread.currentThread().getId()*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId()+": Hola mundo. Mensaje: "+n);
	}
}
