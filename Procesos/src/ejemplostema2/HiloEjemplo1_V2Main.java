package ejemplostema2;

public class HiloEjemplo1_V2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloEjemplo1_V2 h1=new HiloEjemplo1_V2("Hilo 1");
		HiloEjemplo1_V2 h2=new HiloEjemplo1_V2("Hilo 2");
		HiloEjemplo1_V2 h3=new HiloEjemplo1_V2("Hilo 3");
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("3 HILOS INICIADOS");
	}

}
