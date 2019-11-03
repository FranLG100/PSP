package pruebawait;

public class MainCola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cola c=new Cola();
		Productor p=new Productor("El Productor", c);
		Consumidor c1=new Consumidor("Fran", c);
		Consumidor c2=new Consumidor("Darth Vader", c);
		Consumidor c3=new Consumidor("Ludwig", c);
		
		p.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
