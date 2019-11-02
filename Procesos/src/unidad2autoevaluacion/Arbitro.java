package unidad2autoevaluacion;

public class Arbitro {

	int numero;
	int turno;
	int njugadores;
	boolean finalizado=false;
	
	public Arbitro(int njugadores) {
		// TODO Auto-generated constructor stub
		this.njugadores=njugadores;
		numero=1+(int)(10*Math.random());
		turno=1;
		
		System.out.println("NUMERO A ADIVINAR: "+numero);
	}
	
	public synchronized void comprobar(int idJugador, int numeroAcertar) throws InterruptedException {
		if(numeroAcertar==numero) {
			finalizado=true;
			System.out.println("Jugador "+idJugador+" acerto el numero. \nFIN DEL JUEGO");
		}else {
			
			turno++;
			if(turno>njugadores)
				turno=1;
			}
		}

	
	public boolean getFinalizado() {
		return finalizado;
	}
	
	public int getTurno() {
		return turno;
	}
}
