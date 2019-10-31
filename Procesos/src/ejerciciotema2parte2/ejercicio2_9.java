package ejerciciotema2parte2;

import ejemplostema2parte2.Cola;
import ejemplostema2parte2.Productor;

public class ejercicio2_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cola cola=new Cola();
		Productor p=new Productor(cola,1);
		Consumidor c=new Consumidor(cola, 1);
		p.start();
		c.start();
		
		//El 100 por 100 de los intentos que he probado, sale el resultado deseado
		//Puede ser casualidad, o que funcione.
		//Aun asi, creo que es mas seguro usar wait y notify para esto que ponerle un poco
		//mas de sleep al hilo consumidor
	}

}
