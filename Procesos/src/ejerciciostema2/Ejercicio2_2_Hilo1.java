package ejerciciostema2;

public class Ejercicio2_2_Hilo1 implements Runnable {
	
	//Es como el ejercicio anterior, solo que con Runnable
	
	//Implementamos el run del hilo
	public void run() {
		//El hilo se ejecutara con duracion indefinida
		while(true) {
			//Sacando por pantalla 'TAC'
			System.out.println("TAC");
			try {
				//Esperara un segundo, y volvera a repetir el bucle
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
