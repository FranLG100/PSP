package ejerciciostema3parte2.ejercicio3_10;

public class ObjetoCompartido {

	private int numero;
	private boolean acabo;
	private int ganador;
	
	public ObjetoCompartido(int numero) {
		this.numero=numero;
		this.acabo=false;
		// TODO Auto-generated constructor stub
	}
	
	public boolean seAcabo() {
		return acabo;
	}
	
	public int getGanador() {
		return ganador;
	}
	
	//Metodo que recibe id del jugador y su numero
	//Le da pistas de como se esta acercando
	public synchronized String nuevaJugada(int jugador, int suNumero) {
		String cad="";
		if(!seAcabo()) {
			if(suNumero>numero) {
				cad="Numero demasiado grande";
			}
			if(suNumero<numero) {
				cad="Numero demasiado bajo";
			}
			//Si coincide, gana la partida
			if (suNumero==numero) {
				cad="Jugador "+jugador+" gana, adivino el numero: "+numero;
				acabo=true;
				ganador=jugador;
			}
		//Pero puede darse el caso de que otro jugador se le adelante
		}else {
			cad="Jugador "+ganador+" adivino el numero: "+numero;
		}
		
		return cad;
	}
}
