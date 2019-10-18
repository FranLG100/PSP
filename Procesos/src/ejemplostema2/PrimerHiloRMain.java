package ejemplostema2;

public class PrimerHiloRMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrimerHiloR hilo1=new PrimerHiloR();
		new Thread(hilo1).start();
		
		PrimerHiloR hilo2=new PrimerHiloR();
		new Thread(hilo2).start();
		
		PrimerHiloR hilo3=new PrimerHiloR();
		new Thread(hilo3).start();
	}

}
