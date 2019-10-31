package ejerciciotema2parte2;

public class ProductorSync extends Thread {

	private ColaSincronizada cola;
	private int n;
	
	public ProductorSync(ColaSincronizada c, int n) {
		cola=c;
		this.n=n;
	}
	
	
	//Va poniendo en la cola un ping o un pong cada segundo
	public void run() {
		for (int i = 0; i < 50; i++) {
			if(i%2==0) {
				cola.put("PING");
			}else {
				cola.put("PONG");
			}
			//System.out.println(i+" => Productor : "+n+" produce: "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("FIN DEL PRODUCTOR");
	}
}
