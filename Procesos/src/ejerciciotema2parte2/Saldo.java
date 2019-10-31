package ejerciciotema2parte2;

public class Saldo {

	private int saldo;
	
	public Saldo(int s) {
		this.saldo=s;
	}
	
	public void setSaldo(int saldo) {
		this.saldo=saldo;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	void sumar(int cantidad) {
		this.saldo+=cantidad;
	}
	
	//Metodo sincronizado que suma dinero
	//Si no estuviese sincronizado, podria darse que dos hilos entrasen a la vez
	//y se distrajese dinero
	public synchronized void sumarDinero(int cant, String nom) {
			System.out.println(nom+": SE VA A SUMAR SALDO (ACTUAL ES: "+getSaldo()+")");
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sumar(cant);
			System.out.println("\t"+nom+" suma => "+cant+ " (ACTUAL ES: "+getSaldo()+")");
	}
}
