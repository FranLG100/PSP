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
	
	public synchronized String nuevaJugada(int jugador, int suNumero) {
		String cad="";
		if(!seAcabo()) {
			if(suNumero>numero) {
				cad="Numero demasiado grande";
			}
			if(suNumero<numero) {
				cad="Numero demasiado bajo";
			}
			if (suNumero==numero) {
				cad="Jugador "+jugador+" gana, adivinó el número: "+numero;
				acabo=true;
				ganador=jugador;
			}
		}else {
			cad="Jugador "+ganador+" adivinó el número: "+numero;
		}
		
		return cad;
	}
}
