package ejerciciotema2parte2;

import ejemplostema2parte2.Contador;


public class ejercicio2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contador cont=new Contador(0);
		HiloA a1=new HiloA("Hilo A1",cont);
		HiloA a2=new HiloA("Hilo A2",cont);
		HiloA a3=new HiloA("Hilo A3",cont);
		HiloA a4=new HiloA("Hilo A4",cont);
		HiloA a5=new HiloA("Hilo A5",cont);
		
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
		
		//PRIMER INTENTO:
		//No suele salir lo que tiene que salir. No suele llegar a 25000
	}

}
