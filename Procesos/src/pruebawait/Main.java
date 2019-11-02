package pruebawait;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pasteleria c=new Pasteleria();
		
		Sujeto h1=new Sujeto("Cocinero", c,true);
		Sujeto h2=new Sujeto("Juan", c,false);
		Sujeto h3=new Sujeto("Ana", c,false);
		Sujeto h4=new Sujeto("Fran", c,false);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
	}

}
