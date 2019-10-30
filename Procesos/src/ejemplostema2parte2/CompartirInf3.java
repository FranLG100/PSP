package ejemplostema2parte2;

public class CompartirInf3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta c=new Cuenta(40);
		SacarDinero h1=new SacarDinero("Ana",c);
		SacarDinero h2=new SacarDinero("Juan",c);
		
		h1.start();
		h2.start();
	}

}
