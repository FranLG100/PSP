package ejemplostema2parte2;

public class HiloCadenaNotify extends Thread{

	private ObjetoCompartido objeto;
	String cad;
	
	public HiloCadenaNotify(ObjetoCompartido c, String s) {
		this.objeto=c;
		this.cad=s;
	}

	public void run() {
		synchronized (objeto) {
			for (int i = 0; i < 10; i++) {
				objeto.PintaCadena(cad);
				objeto.notify();
				try {
					objeto.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			objeto.notify();
			System.out.println("\n"+cad+ "finalizado");
		}
		
	}
}
