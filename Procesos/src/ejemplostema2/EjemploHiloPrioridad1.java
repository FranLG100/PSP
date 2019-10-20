package ejemplostema2;

public class EjemploHiloPrioridad1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		HiloPrioridad1 h1=new HiloPrioridad1("Hilo 1");
		HiloPrioridad1 h2=new HiloPrioridad1("Hilo 2");
		HiloPrioridad1 h3=new HiloPrioridad1("Hilo 3");
		
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);
		
		h1.start();
		h2.start();
		h3.start();
		
		Thread.sleep(5000);
		
		h1.pararHilo();
		h2.pararHilo();
		h3.pararHilo();
		
		System.out.println("h2 PRIORIDAD MAXIMA: "+h2.getContador());
		System.out.println("h1 PRIORIDAD MEDIA: "+h1.getContador());
		System.out.println("h3 PRIORIDAD MINIMA: "+h3.getContador());
	}

}
