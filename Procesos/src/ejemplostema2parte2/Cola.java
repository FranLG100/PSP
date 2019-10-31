package ejemplostema2parte2;

public class Cola {

	private int numero;
	private boolean disponible=false;
	
	//Metodo para obtener de la cola
	public int get() {
		if (disponible) {
			disponible=false;
			return numero;
		}
		return -1;
	}
	
	//Metodo para poner en la cola
	public void put(int valor) {
		numero=valor;
		disponible=true;
	}
}
