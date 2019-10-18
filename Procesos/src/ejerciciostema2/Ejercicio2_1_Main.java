package ejerciciostema2;

public class Ejercicio2_1_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ejercicio2_1_Hilo1 h1=new Ejercicio2_1_Hilo1();
		Ejercicio2_1_Hilo2 h2=new Ejercicio2_1_Hilo2();
		
		h1.start();
		h2.start();
		
		//En cuanto a la respuesta: NO, No se ejecutaran en orden.
		//Puede dar la casualidad, pero no, muchas veces saldra TAC TIC TIC TAC TAC TIC
	}

}
