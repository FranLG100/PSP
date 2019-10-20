package ejemplostema2;

public class EjemploJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HiloJoin h1=new HiloJoin("Hilo 1", 2);
		HiloJoin h2=new HiloJoin("Hilo 2", 5);
		HiloJoin h3=new HiloJoin("Hilo 3", 7);
		h1.start();
		h2.start();
		h3.start();
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("FIN PROGRAMA");
	}

}
