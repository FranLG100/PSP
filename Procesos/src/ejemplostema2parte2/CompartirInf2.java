package ejemplostema2parte2;

public class CompartirInf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador cont=new Contador(100);
		HiloASincronizado a=new HiloASincronizado("Hilo A",cont);
		HiloBSincronizado b=new HiloBSincronizado("Hilo B",cont);
		
		
		b.start();
		a.start();
	}

}
