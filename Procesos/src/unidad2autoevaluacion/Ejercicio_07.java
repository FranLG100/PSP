package unidad2autoevaluacion;

public class Ejercicio_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuenta c=new Cuenta(300, 800);
		Persona p1=new Persona("Ana", c);
		Persona p2=new Persona("Alex", c);
		Persona p3=new Persona("Fran", c);
		Persona p4=new Persona("Pilar", c);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
	}

}
