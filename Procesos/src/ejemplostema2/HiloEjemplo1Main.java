package ejemplostema2;

public class HiloEjemplo1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloEjemplo1 h1=new HiloEjemplo1("Hilo 1");
		HiloEjemplo1 h2=new HiloEjemplo1("Hilo 2");
		HiloEjemplo1 h3=new HiloEjemplo1("Hilo 3");
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("3 HILOS INICIADOS");
	}

}
