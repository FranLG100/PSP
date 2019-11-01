package unidad1autoevaluacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utilesFran.Amadeus;

public class ProcesoE08 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String cadena="";
		
		System.out.println("Introduzca una cadena");
		cadena=br.readLine();
		
		if(cadena.trim().length()==0)
			System.out.println("Es una cadena vacía");
		else {
			System.out.println(cadena);
			amadeus.Palindromo(cadena);
	}}

}
