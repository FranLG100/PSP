package procesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio1_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	InputStreamReader in=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(in);
	int a;
	int b;
	try {
		System.out.println("Introduzca una dos números");
		a=Integer.parseInt(br.readLine());
		b=Integer.parseInt(br.readLine());
		System.out.println("Suma: "+(a+b));
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
