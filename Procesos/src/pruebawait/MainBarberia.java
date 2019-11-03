package pruebawait;

public class MainBarberia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Barberia b=new Barberia();
		Barbero bar=new Barbero(b);
		ClienteBarberia c1=new ClienteBarberia("Vicente", b);
		ClienteBarberia c2=new ClienteBarberia("Victor", b);
		ClienteBarberia c3=new ClienteBarberia("Virgilio", b);
		ClienteBarberia c4=new ClienteBarberia("Venancio", b);
		ClienteBarberia c5=new ClienteBarberia("Fran", b);
		
		bar.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}

}
