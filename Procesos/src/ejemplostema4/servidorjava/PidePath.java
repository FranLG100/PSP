package ejemplostema4.servidorjava;

import java.io.Serializable;

public class PidePath implements Serializable{

	String pathDirectorio;
	
	public PidePath(String pathDirectorio) {
		this.pathDirectorio=pathDirectorio;
	}
	
	public String getPathDirectorio() {
		return pathDirectorio;
	}
	
}
