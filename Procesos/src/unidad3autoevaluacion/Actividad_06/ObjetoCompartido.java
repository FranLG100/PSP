package unidad3autoevaluacion.Actividad_06;

public class ObjetoCompartido {

	private String[][] tablero;
	private boolean acabo;
	private int ganador;
	
	public ObjetoCompartido(String [][] tablero) {
		this.tablero=tablero;
		this.acabo=false;
		// TODO Auto-generated constructor stub
	}
	
	public boolean seAcabo() {
		return acabo;
	}
	
	public int getGanador() {
		return ganador;
	}
	
	public synchronized String nuevaJugada(int jugador, int primerNumero, int segundoNumero) {
		String cad="";
		if(!seAcabo()) {
			cad=tablero[primerNumero][segundoNumero];
			/*if(suNumero>numero) {
				cad="Numero demasiado grande";
			}
			if(suNumero<numero) {
				cad="Numero demasiado bajo";
			}*/
			if(primerNumero==0 && segundoNumero==0) {
				cad="Jugador "+jugador+" gana, se lleva "+tablero[0][0];
				acabo=true;
				ganador=jugador;
			}
		}else {
			cad="Jugador "+ganador+" se lleva : "+tablero[0][0];
		}
		
		return cad;
	}
}
