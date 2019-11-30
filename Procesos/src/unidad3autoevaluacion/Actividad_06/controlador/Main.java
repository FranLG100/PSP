package unidad3autoevaluacion.Actividad_06.controlador;

import java.io.IOException;
import java.net.UnknownHostException;

import ejerciciostema3parte2.ejercicio3_10.vista.Vista;
import unidad3autoevaluacion.Actividad_06.JugadorAdivina;
import unidad3autoevaluacion.Actividad_06.vista.VistaPremios;

public class Main {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new Controlador(new VistaPremios(), new JugadorAdivina()).iniciar();
	}

}
