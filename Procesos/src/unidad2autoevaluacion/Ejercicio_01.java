package unidad2autoevaluacion;

public class Ejercicio_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hilo_E01 a=new Hilo_E01("A");
		Hilo_E01 b=new Hilo_E01("B");
		Hilo_E01 c=new Hilo_E01("C");
		Hilo_E01 d=new Hilo_E01("D");
		Hilo_E01 e=new Hilo_E01("E");
		
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}

}
