package unidad3autoevaluacion.Actividad_06;
import java.io.*;

public class Datos implements Serializable {

	String cadena;
	String cadenaX;
	String cadenaY;
	
	int intentos;
	int identificador;
	boolean gana;
	boolean juega;
	int premios;
	
	

	public Datos(String cadena, int intentos, int identificador, int premios) {
		this.cadena=cadena;
		this.intentos=intentos;
		this.identificador=identificador;
		this.gana=false;
		this.juega=true;
		this.premios=premios;
	}
	
	public Datos() {
		super();
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public boolean isGana() {
		return gana;
	}

	public void setGana(boolean gana) {
		this.gana = gana;
	}

	public boolean isJuega() {
		return juega;
	}

	public void setJuega(boolean juega) {
		this.juega = juega;
	}
	
	public String getCadenaX() {
		return cadenaX;
	}

	public void setCadenaX(String cadenaX) {
		this.cadenaX = cadenaX;
	}

	public String getCadenaY() {
		return cadenaY;
	}

	public void setCadenaY(String cadenaY) {
		this.cadenaY = cadenaY;
	}

	public int getPremios() {
		return premios;
	}

	public void setPremios(int premios) {
		this.premios = premios;
	}
	

	
	
}
