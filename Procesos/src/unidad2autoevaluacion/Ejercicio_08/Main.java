package unidad2autoevaluacion.Ejercicio_08;

import java.io.IOException;
import java.net.UnknownHostException;

import unidad2autoevaluacion.Ejercicio_08.controlador.Controlador;
import unidad2autoevaluacion.Ejercicio_08.vista.Vista;



public class Main {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new Controlador(new Vista(), new Ejercicio2_4(new MyHiloEj4()), new Ejercicio2_4(new MyHiloEj4())).iniciar();
	}

}
