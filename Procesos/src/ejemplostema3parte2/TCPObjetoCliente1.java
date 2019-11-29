package ejemplostema3parte2;
import java.io.*;
import java.net.*;

public class TCPObjetoCliente1 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String host="localhost";
		int puerto=6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente=new Socket(host,puerto);
		
		ObjectInputStream perEnt=new ObjectInputStream(cliente.getInputStream());
		
		Persona dato=(Persona) perEnt.readObject();
		
		System.out.println("Recibo: "+dato.getNombre()+" * "+dato.getEdad());
		
		dato.setNombre("Juan Ramos");
		dato.setEdad(22);
		
		ObjectOutputStream perSal=new ObjectOutputStream(cliente.getOutputStream());
		
		perSal.writeObject(dato);
		System.out.println("Envio: "+dato.getNombre()+" * "+dato.getEdad());
		
		perEnt.close();
		perSal.close();
		cliente.close();
	}

}
