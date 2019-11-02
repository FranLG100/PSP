package unidad2autoevaluacion;

public class Cuenta {

	private int saldo;
	private int maximo;
	
	public Cuenta(int saldo,int maximo) {
		// TODO Auto-generated constructor stub
		this.saldo=saldo;
		this.maximo=maximo;
	}
	
	public synchronized void ingreso(String n, int cantidad) {
		if((cantidad+saldo)>maximo) {
			System.out.println(n+" :NO se han podido añadir "+cantidad+"E, exceso de saldo");
		}else {
			saldo+=cantidad;
			System.out.println(n+" :Se han sumado "+cantidad+"E. Actual: "+saldo);
		}
	}
	
	public synchronized void reintegro(String n,int cantidad) {
		if((saldo-cantidad)<0) {
			System.out.println(n+" :NO se han podido retirar "+cantidad+"E, saldo negativo");
		}else {
			saldo-=cantidad;
			System.out.println(n+" :Se han retirado "+cantidad+"E. Actual: "+saldo);
		}
	}
}
