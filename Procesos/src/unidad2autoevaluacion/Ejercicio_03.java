package unidad2autoevaluacion;

import java.io.File;

public class Ejercicio_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo1=new File("entradaProceso09.txt");
		Hilo_E03 h1=new Hilo_E03(archivo1);
		
		File archivo2=new File("entradaProceso08.txt");
		Hilo_E03 h2=new Hilo_E03(archivo2);
		
		h1.start();
		h2.start();
	}

}
