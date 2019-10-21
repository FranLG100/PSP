package ejerciciostema2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ejemplostema2.MyHiloEj4;

public class Ejercicio2_4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Este hilo es de un ejemplo (el paquete ejemplos).
		//Lo que hace es contar hasta el infinito (el infinito que le deje java)
		//Mientras tanto, podemos escribir
		MyHiloEj4 h=new MyHiloEj4();
		BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		String comprobador="";
		h.start();
		do {
			comprobador=lector.readLine();
			//Si escribimos 's', el hilo entra en espera (wait()), hasta que
			if(comprobador.equalsIgnoreCase("s"))
					h.Suspende();
			if(comprobador.equalsIgnoreCase("r"))
				//escribamos 'r', para reanudarlo. (notifyAll())
				h.Reanuda();
		} while (!comprobador.equalsIgnoreCase("*"));
		//Cuando pongamos '*', el hilo finaliza
		h.Finaliza();
	}

}
