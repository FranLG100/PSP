package ejerciciostema3parte2;
import java.io.*;
import java.net.*;

public class Ejercicio3_8_4 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
		
		String host="localhost";
		int puerto=6000;
		int numero=0;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente=new Socket(host,puerto);
		
		ObjectInputStream numEnt=new ObjectInputStream(cliente.getInputStream());
		ObjectOutputStream numSal=new ObjectOutputStream(cliente.getOutputStream());
		
		
		do {
			System.out.println("Escriba un número: ");
			numero=Integer.parseInt(entrada.readLine());
			
			Numeros dato=new Numeros(numero, 0, 0);
			
			numSal.writeObject(dato);
			System.out.println("Envio: "+dato.getNumero());
			
			dato=(Numeros) numEnt.readObject();
			System.out.println("Cuadrado: "+dato.getCuadrado()+" --- Cubo: "+dato.getCubo());
		}while(numero>0);
		
		numEnt.close();
		numSal.close();
		cliente.close();
	}

}
