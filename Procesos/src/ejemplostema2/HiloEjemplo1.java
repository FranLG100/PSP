package ejemplostema2;

public class HiloEjemplo1 extends Thread {
	String nombre;
	
	public HiloEjemplo1(String nombre) {
		this.nombre=nombre;
		System.out.println("CREANDO HILO: "+nombre);
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hilo: " + nombre + " C = "+i);
		}
	}
	
	

}
