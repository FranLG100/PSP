package unidad3autoevaluacion.Actividad_05.controlador;

import java.io.IOException;
import java.net.UnknownHostException;

import ejerciciostema3parte2.ejercicio3_10.JugadorAdivina;
import ejerciciostema3parte2.ejercicio3_10.vista.Vista;
import unidad3autoevaluacion.Actividad_02.modelo.Servidor;
import unidad3autoevaluacion.Actividad_02.vista.VistaCliente;
import unidad3autoevaluacion.Actividad_02.vista.VistaServidor;
import unidad3autoevaluacion.Actividad_05.Cliente;
import unidad3autoevaluacion.Actividad_05.vista.VistaClienteEco;

public class MainCliente {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new ControladorCliente(new VistaClienteEco(), new Cliente()).iniciar();
	}

}
