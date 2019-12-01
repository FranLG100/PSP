package unidad3autoevaluacion.Actividad_06;

public class ObjetoCompartido {

	private String[][] tablero;
	private boolean acabo;
	private int ganador;
	private int premios;
	private boolean pDinero;
	private boolean pMasaje;
	private boolean pCrucero;
	private boolean pEntradas;
	//public static int premios=4;
	
	public ObjetoCompartido(String [][] tablero) {
		this.tablero=tablero;
		this.acabo=false;
		this.premios=4;
		this.pCrucero=false;
		this.pEntradas=false;
		this.pMasaje=false;
		this.pDinero=false;
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
			cad="["+primerNumero+"] ["+segundoNumero+"] "+tablero[primerNumero][segundoNumero];
			/*if(suNumero>numero) {
				cad="Numero demasiado grande";
			}
			if(suNumero<numero) {
				cad="Numero demasiado bajo";
			}*/
			if(primerNumero==0 && segundoNumero==0) {
				if(pCrucero) {
					cad="Ya se ha repartido ese premio";
				}else {
					cad="Jugador "+jugador+" se lleva "+tablero[0][0];
					premios=premios-1;
					pCrucero=true;
					ComprobarAciertos(jugador, cad);
				}
				//cad="Jugador "+jugador+" gana, se lleva "+tablero[0][0];
				//acabo=true;
				//ganador=jugador;
			}
			if(primerNumero==2 && segundoNumero==3) {
				if(pDinero) {
					cad="Ya se ha repartido ese premio";
				}else {
					cad="Jugador "+jugador+" se lleva "+tablero[2][3];
					premios=premios-1;
					pDinero=true;
					ComprobarAciertos(jugador, cad);
				}
			}
			if(primerNumero==1 && segundoNumero==2) {
				if(pEntradas) {
					cad="Ya se ha repartido ese premio";
				}else {
					cad="Jugador "+jugador+" se lleva "+tablero[1][2];
					premios=premios-1;
					pEntradas=true;
					ComprobarAciertos(jugador, cad);
				}
			}
			if(primerNumero==2 && segundoNumero==0) {
				if(pMasaje) {
					cad="Ya se ha repartido ese premio";
				}else {
					cad="Jugador "+jugador+" se lleva "+tablero[2][0];
					premios=premios-1;
					pMasaje=true;
					ComprobarAciertos(jugador, cad);
				}
			}
		}else {
			cad="Jugador "+ganador+" se lleva : "+tablero[0][0];
		}
		
		return cad;
	}
	
	public void ComprobarAciertos(int jugador, String cad) {
		if(pCrucero && pDinero && pEntradas && pMasaje) {
			cad="Se han repartido todos los premios, suerte la proxima vez";
			acabo=true;
		}
	}

	public int getPremios() {
		return premios;
	}

	public void setPremios(int premios) {
		this.premios = premios;
	}
	
	

	
	
}
