package unidad3autoevaluacion.Actividad_07;

public class ObjetoCompartido {

	private int[] numero;
	private boolean acabo;
	private int ganador;
	private int aciertos;
	private int tocados;
	
	public ObjetoCompartido(int[] numero) {
		this.numero=numero;
		this.acabo=false;
		this.aciertos=0;
		this.tocados=0;
		// TODO Auto-generated constructor stub
	}
	
	public boolean seAcabo() {
		return acabo;
	}
	
	public int getGanador() {
		return ganador;
	}
	
	public synchronized String[] nuevaJugada(int jugador, int num1, int num2, int num3, int num4) {
		String cad[]=new String[2];
		cad[0]="";
		cad[1]="";
		aciertos=0;
		tocados=0;
		if(!seAcabo()) {
			if(numero[0]==num1)
				aciertos++;
			if(numero[1]==num2)
				aciertos++;
			if(numero[2]==num3)
				aciertos++;
			if(numero[3]==num4)
				aciertos++;
			if (aciertos==4) {
				cad[0]="Jugador "+jugador+" gana, adivino la combinacion.";
				acabo=true;
				ganador=jugador;
				return cad;
			}
			
			for (int i = 0; i < numero.length; i++) {
				if((numero[i]==num1)||(numero[i]==num2)||(numero[i]==num3)||(numero[i]==num4))
					tocados++;
			}
			tocados=tocados-aciertos;
			cad[0]="["+num1+"]["+num2+"]["+num3+"]["+num4+"] --> ACIERTOS: "+aciertos;
			cad[1]="["+num1+"]["+num2+"]["+num3+"]["+num4+"] --> TOCADOS: "+tocados;
			return cad;
		}else {
			cad[0]="Jugador "+ganador+" adivino la combinacion.";
		}
		
		return cad;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public int getTocados() {
		return tocados;
	}

	public void setTocados(int tocados) {
		this.tocados = tocados;
	}
}
