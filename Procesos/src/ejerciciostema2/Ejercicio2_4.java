package ejerciciostema2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ejemplostema2.MyHiloEj4;

public class Ejercicio2_4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		MyHiloEj4 h=new MyHiloEj4();
		BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		String comprobador="";
		h.start();
		do {
			comprobador=lector.readLine();
			if(comprobador.equalsIgnoreCase("s"))
					h.Suspende();
			if(comprobador.equalsIgnoreCase("r"))
				h.Reanuda();
		} while (!comprobador.equalsIgnoreCase("*"));
		h.Finaliza();
	}

}
