package ejerciciotema2parte2;

import ejemplostema2parte2.Cuenta;
import ejemplostema2parte2.SacarDinero;

public class ejercicio2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Saldo c=new Saldo(0);
		MeterDinero h1=new MeterDinero("Ana",c);
		MeterDinero h2=new MeterDinero("Juan",c);
		MeterDinero h3=new MeterDinero("Pedro",c);
		MeterDinero h4=new MeterDinero("Maria",c);
		MeterDinero h5=new MeterDinero("Fran",c);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		
		//SI NO METEMOS EL SYNCHRONIZED, AUNQUE MAYORMENTE LO HACE BIEN,
		//ES POSIBLE QUE A VECES, NO SE LLEGUE A LA CANTIDAD NO LLEGUE A LO QUE DEBE LLEGAR.
		//DEBE LLEGAR A 200, Y EN RARAS OCASIONES, SE LLEGA A 190.
		
		//Si simulamos esto a un banco real, con millones de usuarios, no seria raro, que si
		//no se controla, se pierda datos de los saldos
	}

}
