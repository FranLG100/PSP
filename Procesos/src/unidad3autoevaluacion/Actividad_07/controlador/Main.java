package unidad3autoevaluacion.Actividad_07.controlador;

import java.io.IOException;
import java.net.UnknownHostException;

import unidad3autoevaluacion.Actividad_07.JugadorAdivina;
import unidad3autoevaluacion.Actividad_07.vista.VistaMastermind;

public class Main {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new Controlador(new VistaMastermind(), new JugadorAdivina()).iniciar();
	}

}
