package unidad3autoevaluacion.Actividad_02.controlador;

import java.io.IOException;
import java.net.UnknownHostException;

import ejerciciostema3parte2.ejercicio3_10.JugadorAdivina;
import ejerciciostema3parte2.ejercicio3_10.vista.Vista;
import unidad3autoevaluacion.Actividad_02.modelo.Servidor;
import unidad3autoevaluacion.Actividad_02.vista.VistaServidor;

public class MainServidor {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new ControladorServidor(new VistaServidor(), new Servidor()).iniciar();
	}

}
