package unidad2autoevaluacion;

public class Jugador extends Thread {

	int identificador;
	Arbitro arb;
	boolean esperaTurno=true;
	
	public Jugador(int id, Arbitro arb) {
		// TODO Auto-generated constructor stub
		this.identificador=id;
		this.arb=arb;
	}
	
	public int jugarNumero() {
		int numero=1+(int)(10*Math.random());
		System.out.println("Jugador "+identificador+" juega el "+numero);
		return numero;
	}
	
	public void darTurno() {
		esperaTurno=false;
	}
	
	public void run() {
		while (!arb.getFinalizado()) {
			if(arb.getTurno()==identificador) {
			 	int numero=jugarNumero();
			 	try {
					arb.comprobar(identificador, numero);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
