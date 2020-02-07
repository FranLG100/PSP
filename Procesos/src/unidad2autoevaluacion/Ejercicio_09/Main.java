package unidad2autoevaluacion.Ejercicio_09;

import java.io.IOException;
import java.net.UnknownHostException;

import unidad2autoevaluacion.Ejercicio_09.controlador.Controlador;
import unidad2autoevaluacion.Ejercicio_09.vista.Vista;




public class Main {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new Controlador(new Vista(), new Ejercicio2_4(new MyHiloEj4(2000)), new Ejercicio2_4(new MyHiloEj4(1000))).iniciar();
	}

}
