package ejerciciostema2;

public class Ejercicio2_1_Hilo1 extends Thread {
	
	//Implementamos el run del hilo
	public void run() {
		//El hilo se ejecutara con duracion indefinida
		while(true) {
			//Sacando por pantalla 'TIC'
			System.out.println("TIC");
			try {
				//Esperara un segundo, y volvera a repetir el bucle
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
