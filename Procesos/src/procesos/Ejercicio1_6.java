package procesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio1_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	//Este programa lo usaremos para Ejercicio1_6_2
	//Simplemente, pide que se introduzcan dos numeros por parametro de entrada, y 
	//sale por pantalla la suma de los mismos
	InputStreamReader in=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(in);
	int a;
	int b;
	try {
		System.out.println("Introduzca una dos numeros");
		a=Integer.parseInt(br.readLine());
		b=Integer.parseInt(br.readLine());
		System.out.println("Suma: "+(a+b));
		in.close();
	} catch (Exception e) {
		System.out.println("No has introducido numeros");
	}
	}

}
