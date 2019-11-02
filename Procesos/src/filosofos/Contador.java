package filosofos;

import java.util.ArrayList;

public class Contador extends Thread {

	ArrayList<Filosofo> filosofos;//
	
	public Contador(ArrayList<Filosofo> filosofos) {
		// TODO Auto-generated constructor stub
		this.filosofos=filosofos;
	}
	
	//Esto es mas que nada para contar cuantas veces ha cenado cada filosofo y ver si es equitativo
	public void run() {
		while(true) {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Filosofo filosofo : filosofos) {
			System.out.println("El filosofo "+filosofo.getIdFilosofo()+" ha cenado "+filosofo.haCenado()+" veces");
		}
	}
	}
}
