package unidad2autoevaluacion;

public class Hilo_E01 extends Thread{

	public Hilo_E01(String n) {
		super(n);
	}
	
	public void run() {
		System.out.println("Hola mundo desde el hilo "+Thread.currentThread().getName());
	}
}
