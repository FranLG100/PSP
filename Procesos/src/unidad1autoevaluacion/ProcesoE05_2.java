package unidad1autoevaluacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcesoE05_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String cadena="";
		
		System.out.println("Introduzca una cadena");
		cadena=br.readLine();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(cadena);
		}

}
}
