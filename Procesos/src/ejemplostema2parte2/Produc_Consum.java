package ejemplostema2parte2;

public class Produc_Consum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cola cola=new Cola();
		Productor p=new Productor(cola,1);
		Consumidor c=new Consumidor(cola, 1);
		
		//Con en el sleep en el productor, el consumidor lo consume todo antes de 
		//que el productor produzca más.
		//¿No sería mejor que hubiese wait para avisar de que se han producido?
		p.start();
		c.start();
	}

}
