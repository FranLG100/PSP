package ejemplostema2parte2;

public class Cuenta {

	private int saldo;
	
	public Cuenta(int s) {
		this.saldo=s;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	void restar(int cantidad) {
		this.saldo-=cantidad;
	}
	
	public synchronized void retirarDinero(int cant, String nom) {
		if(getSaldo() >= cant) {
			System.out.println(nom+": SE VA A RETIRAR SALDO (ACTUAL ES: "+getSaldo()+")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			restar(cant);
			System.out.println("\t"+nom+" retira => "+cant+ " (ACTUAL ES: "+getSaldo()+")");
		}else {
			System.out.println(nom+" no puede retirar dinero, NO HAY SALDO ( "+getSaldo()+" )");
		}
		if(getSaldo()<0) {
			System.out.println("SALDO NEGATIVO => "+getSaldo());
		}
	}
}
