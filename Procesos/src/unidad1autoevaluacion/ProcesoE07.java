package unidad1autoevaluacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcesoE07 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String cadena="";
		
		System.out.println("Escribe cadenas:");
		do {
			cadena=br.readLine();
			System.out.println(cadena);
		} while (!cadena.equalsIgnoreCase("*"));
	}

}
