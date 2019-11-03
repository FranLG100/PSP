package pruebawait;

public class MainContador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contador c=new Contador();
		HiloContador h1=new HiloContador("A", c);
		HiloContador h2=new HiloContador("B", c);
		HiloContador h3=new HiloContador("C", c);
		HiloContador h4=new HiloContador("D", c);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
	}

}
