package unidad3autoevaluacion.Actividad_04;

import java.io.Serializable;

public class Asignatura implements Serializable{

	int id;
	String nombreAsig;
	
	public Asignatura(int id, String nombreAsig) {
		super();
		this.id = id;
		this.nombreAsig = nombreAsig;
	}

	public Asignatura() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreAsig() {
		return nombreAsig;
	}

	public void setNombreAsig(String nombreAsig) {
		this.nombreAsig = nombreAsig;
	}
	
	
}
