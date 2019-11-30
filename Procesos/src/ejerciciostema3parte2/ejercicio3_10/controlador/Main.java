package ejerciciostema3parte2.ejercicio3_10.controlador;

import java.io.IOException;
import java.net.UnknownHostException;

import ejerciciostema3parte2.ejercicio3_10.JugadorAdivina;
import ejerciciostema3parte2.ejercicio3_10.vista.Vista;

public class Main {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new Controlador(new Vista(), new JugadorAdivina()).iniciar();
	}

}
