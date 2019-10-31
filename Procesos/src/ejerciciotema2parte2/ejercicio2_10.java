package ejerciciotema2parte2;

public class ejercicio2_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColaSincronizada cola=new ColaSincronizada();
		ProductorSync p=new ProductorSync(cola,1);
		ConsumidorSync c=new ConsumidorSync(cola, 1);
		ConsumidorSync c2=new ConsumidorSync(cola, 2);
		
		
		p.start();
		c.start();
		c2.start();
	}

}
