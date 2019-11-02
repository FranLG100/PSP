package pruebawait;

public class Pasteleria {

	private int tarta=0;
	
	public synchronized void consumir(String nombre) throws InterruptedException{
		if(tarta>0) {
			Thread.sleep(1000);
			tarta--;
			System.out.println(nombre+" se ha comido un trozo, quedan "+tarta);
		}else {
			System.out.println(nombre+" no ha podido comerse un trozo, toca esperar más tarta");
			notifyAll();
			wait();
			
		}
	}
	
	public synchronized void cocinar() throws InterruptedException {
		if (tarta==0) {
			tarta=10;
			System.out.println("Han vuelto a cocinar, quedan 10 porciones");
			notifyAll();
		}else {
			System.out.println("El cocinero se pone a dormir");
			wait();
			
		}
	}
}
