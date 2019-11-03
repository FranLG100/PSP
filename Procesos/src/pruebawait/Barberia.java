package pruebawait;

import java.util.ArrayList;

public class Barberia {

	private ArrayList<ClienteBarberia> clientes=new ArrayList<ClienteBarberia>();
	
	public Barberia() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void afeitar() throws InterruptedException {
		while(clientes.size()==0) {
			System.out.println("El barbero se pone a dormir");
			wait();
		}
			System.out.println("El barbero se pone a afeitar a "+clientes.get(0).getNombre());
			clientes.get(0).setAtendido();
			clientes.remove(0);
			Thread.sleep(3000);
			System.out.println("Hay "+(2-clientes.size())+" sillas disponibles");
			notify();
			System.out.println("El cliente ha sido afeitado");
			Thread.sleep(1000);
	}
	
	public synchronized void hacerCola(String s, ClienteBarberia cliente) throws InterruptedException {
		while(clientes.size()==2) {
			System.out.println(s+" tiene que esperar fuera de la barberia");
			wait();
		}
		if(!cliente.getSentado()) {
			cliente.setSentado();
			System.out.println(s+" espera su turno");
			clientes.add(cliente);
			notify();
		}
	}
	
	public int nSillas() {
		return clientes.size();
	}
}
