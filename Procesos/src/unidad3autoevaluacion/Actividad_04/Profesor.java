package unidad3autoevaluacion.Actividad_04;

import java.io.Serializable;

public class Profesor implements Serializable{

	int idProfesor;
	String nombre;
	Asignatura[] asignaturas;
	Especialidad espe;
	
	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}
	
	public Profesor(String nombre) {
		this.nombre=nombre;
	}

	public Profesor(int idProfesor, String nombre, Asignatura[] asignaturas, Especialidad espe) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.asignaturas = asignaturas;
		this.espe = espe;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Asignatura[] asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Especialidad getEspe() {
		return espe;
	}

	public void setEspe(Especialidad espe) {
		this.espe = espe;
	}
	
	
	
}
