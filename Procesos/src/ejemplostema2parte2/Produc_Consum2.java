package ejemplostema2parte2;

public class Produc_Consum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColaSincronizada cola=new ColaSincronizada();
		ProductorSync p=new ProductorSync(cola,1);
		ConsumidorSync c=new ConsumidorSync(cola, 1);
		
		
		p.start();
		c.start();
	}

}
