package unidad2autoevaluacion;

public class Ejercicio_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hilo_E02 a=new Hilo_E02("Primer hilo");
		Hilo_E02 b=new Hilo_E02("Segundo hilo");
		Hilo_E02 c=new Hilo_E02("Tercero");
		Hilo_E02 d=new Hilo_E02("Cuarto");
		Hilo_E02 e=new Hilo_E02("Quinto");
		
		new Thread(a).start();
		new Thread(b).start();
		new Thread(c).start();
		new Thread(d).start();
		new Thread(e).start();
	}

}
