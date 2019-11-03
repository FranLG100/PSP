package ejerciciotema2parte2;

import ejemplostema2parte2.Contador;


public class ejercicio2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contador cont=new Contador(0);
		Contador contS=new Contador(0);
		Contador contR=new Contador(0);
		Contador contRS=new Contador(0);
		
		//Hilos que incrementan un contador, sin control ninguno.
		HiloA a1=new HiloA("Hilo A1",cont);
		HiloA a2=new HiloA("Hilo A2",cont);
		HiloA a3=new HiloA("Hilo A3",cont);
		HiloA a4=new HiloA("Hilo A4",cont);
		HiloA a5=new HiloA("Hilo A5",cont);
		
		//Hilos que incrementan un contador, de forma sincronizada
		//(Accediendo al objeto de forma sincronizada)
		//synchronized(contador)
		HiloASincronizado as1=new HiloASincronizado("Hilo ASinc1",contS);
		HiloASincronizado as2=new HiloASincronizado("Hilo ASinc2",contS);
		HiloASincronizado as3=new HiloASincronizado("Hilo ASinc3",contS);
		HiloASincronizado as4=new HiloASincronizado("Hilo ASinc4",contS);
		HiloASincronizado as5=new HiloASincronizado("Hilo ASinc5",contS);
		
		//Hilos que acceden al contador implementando runnable, sin control
		HiloARunnable aR1=new HiloARunnable("Hilo AR1",contR);
		HiloARunnable aR2=new HiloARunnable("Hilo AR2",contR);
		HiloARunnable aR3=new HiloARunnable("Hilo AR3",contR);
		HiloARunnable aR4=new HiloARunnable("Hilo AR4",contR);
		HiloARunnable aR5=new HiloARunnable("Hilo AR5",contR);
		
		//Hilos que acceden al contador implementando runnable, de forma sincronizada
		//(Accediendo al objeto de forma sincronizada)
		//synchronized(contador)
		HiloASincronizadoRunnable aRS1=new HiloASincronizadoRunnable("Hilo ARS1",contRS);
		HiloASincronizadoRunnable aRS2=new HiloASincronizadoRunnable("Hilo ARS2",contRS);
		HiloASincronizadoRunnable aRS3=new HiloASincronizadoRunnable("Hilo ARS3",contRS);
		HiloASincronizadoRunnable aRS4=new HiloASincronizadoRunnable("Hilo ARS4",contRS);
		HiloASincronizadoRunnable aRS5=new HiloASincronizadoRunnable("Hilo ARS5",contRS);
		
		
		//COMENTAR LOS BLOQUES QUE NO SE QUIERAN MOSTRAR
		
		//PRIMER INTENTO:
		//No suele salir lo que tiene que salir. No suele llegar a 25000
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
		
		//SEGUNDO INTENTO:
		//Todas las veces que he probado, llega a 25000 sin problemas
		as1.start();
		as2.start();
		as3.start();
		as4.start();
		as5.start();
		
		//TERCER INTENTO:
		//Todas las veces que he probado, llega a 25000 sin problemas
		new Thread(aR1).start();
		new Thread(aR2).start();
		new Thread(aR3).start();
		new Thread(aR4).start();
		new Thread(aR5).start();
		
		
		//CUARTO INTENTO:
		//Todas las veces que he probado, llega a 25000 sin problemas
		new Thread(aRS1).start();
		new Thread(aRS2).start();
		new Thread(aRS3).start();
		new Thread(aRS4).start();
		new Thread(aRS5).start();
		
	}

}
