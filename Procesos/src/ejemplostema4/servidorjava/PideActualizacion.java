package ejemplostema4.servidorjava;

import java.io.Serializable;

public class PideActualizacion implements Serializable{

	String pathDirectorio;
	
	public PideActualizacion(String pathDirectorio) {
		this.pathDirectorio=pathDirectorio;
	}
	
	public String getPathDirectorio() {
		return pathDirectorio;
	}
	
}
