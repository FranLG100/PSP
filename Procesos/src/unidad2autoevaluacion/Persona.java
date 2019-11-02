package unidad2autoevaluacion;

public class Persona extends Thread {

	private String nombre;
	private Cuenta c;
	
	public Persona(String nombre, Cuenta c) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		this.c=c;
	}
	
	public void run() {
		System.out.println(nombre + " acude al cajero");
		c.ingreso(nombre,(int)((Math.random()*500)+1));
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre + " acude al cajero");
		c.reintegro(nombre,(int)((Math.random()*500)+1));
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre + " acude al cajero");
		c.ingreso(nombre,(int)((Math.random()*500)+1));
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre + " acude al cajero");
		c.reintegro(nombre,(int)((Math.random()*500)+1));
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
