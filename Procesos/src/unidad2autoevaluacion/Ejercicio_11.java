package unidad2autoevaluacion;

public class Ejercicio_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Arbitro arbitro=new Arbitro(4);
		Jugador j1=new Jugador(1, arbitro);
		Jugador j2=new Jugador(2, arbitro);
		Jugador j3=new Jugador(3, arbitro);
		Jugador j4=new Jugador(4, arbitro);
		
		j1.start();
		j2.start();
		j3.start();
		j4.start();
		
	}

}
