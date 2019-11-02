package filosofos;

public class Filosofo extends Thread {

	private int id;
	private Tenedor izda,dcha;
	private Silla s;
	private int nCenas=0;
	
	//Se le asigna dos tenedores, una id, y una silla para que se siente.
	public Filosofo(int id,Tenedor izda, Tenedor dcha, Silla s) {
		this.id=id;
		this.izda=izda;
		this.dcha=dcha;
		this.s=s;
	}
	
	public void run() {
		while(true) {
			try {
				//Coge la silla, se sienta, y coge los tenedores
				s.cogerSilla(id);
				izda.cogerTenedor(id);
				dcha.cogerTenedor(id);
				//Come
				sleep(1000);
				System.out.println("FILOSOFO "+id+" ESTA COMIENDO");
				sleep(1000);
				//Suelta los tenedores y se levanta de la silla
				dcha.soltarTenedor(id);
				izda.soltarTenedor(id);
				s.soltarSilla(id);
				nCenas++;
				//Se pone a pensar, como filosofo que es
				System.out.println("FILOSOFO "+id+" PENSANDO");
				sleep(2000);
				System.out.println(id+ "acabó de pensar");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public int haCenado() {
		return nCenas;
	}
	
	public int getIdFilosofo() {
		return id;
	}
}
