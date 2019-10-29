package ejemplostema2parte2;

public class CompartirInf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador cont=new Contador(100);
		HiloA a=new HiloA("Hilo A",cont);
		HiloB b=new HiloB("Hilo B",cont);
		
		a.start();
		b.start();
	}

}
