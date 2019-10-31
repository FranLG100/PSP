package ejerciciotema2parte2;

public class ejercicio2_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColaSincronizada cola=new ColaSincronizada();
		ProductorSync p=new ProductorSync(cola,1);
		ConsumidorSync c=new ConsumidorSync(cola, 1);
		ConsumidorSync c2=new ConsumidorSync(cola, 2);
		
		//El productor produce 'Ping' y 'Pong' de forma alterna.
		//Un consumidor cogera todos los Ping, y otro, todos los Pong
		//Ya que se van turnando
		//Cuando hay un Ping en la cola, c lo recoge, el productor produce un Pong
		//y c2 lo recoge, el productor vuelve a producir un Ping
		//Y asi 50 veces
		p.start();
		c.start();
		c2.start();
	}

}
