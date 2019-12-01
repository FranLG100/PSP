package unidad3autoevaluacion.Actividad_07;
import java.io.*;

public class Datos implements Serializable {

	String[] cadena;
	String cadena1;
	String cadena2;
	String cadena3;
	String cadena4;
	int intentos;
	int identificador;
	boolean gana;
	boolean juega;
	
	public Datos(String[] cadena, int intentos, int identificador) {
		this.cadena=cadena;
		this.intentos=intentos;
		this.identificador=identificador;
		this.gana=false;
		this.juega=true;
	}
	
	public Datos() {
		super();
	}

	public String[] getCadena() {
		return cadena;
	}

	public void setCadena(String[] cadena) {
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

	public String getCadena1() {
		return cadena1;
	}

	public void setCadena1(String cadena1) {
		this.cadena1 = cadena1;
	}

	public String getCadena2() {
		return cadena2;
	}

	public void setCadena2(String cadena2) {
		this.cadena2 = cadena2;
	}

	public String getCadena3() {
		return cadena3;
	}

	public void setCadena3(String cadena3) {
		this.cadena3 = cadena3;
	}

	public String getCadena4() {
		return cadena4;
	}

	public void setCadena4(String cadena4) {
		this.cadena4 = cadena4;
	}
	
	
	
	
}
