package pruebawait;

public class MainPistola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pistola p=new Pistola();
		Cargar c=new Cargar(p);
		Descargar d=new Descargar(p);
		
		c.start();
		d.start();
	}

}
