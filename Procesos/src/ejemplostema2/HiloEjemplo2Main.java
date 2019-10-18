package ejemplostema2;

public class HiloEjemplo2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread.currentThread().setName("Principal");
		System.out.println(Thread.currentThread().getName());	
		System.out.println(Thread.currentThread().toString());
		
		HiloEjemplo2 h=null;
		
		for (int i = 0; i < 3; i++) {
			h=new HiloEjemplo2();
			h.setName("HILO "+i );
			h.setPriority(i+1);
			h.start();
			System.out.println("Información el "+h.getName()+ ": "+h.toString());
		}
		
		System.out.println("3 HILOS CREADOS...");
		System.out.println("Hilos activados: "+Thread.activeCount());
	}

}
