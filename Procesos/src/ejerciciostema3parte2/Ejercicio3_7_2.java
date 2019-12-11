package ejerciciostema3parte2;
import java.io.*;
import java.net.*;

public class Ejercicio3_7_2 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		
		//CLIENTE
		
		//Usaremos esto para escribir por consola
		BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
		
		//Datos de conexion
		String host="localhost";
		int puerto=6000;
		int numero=0;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente=new Socket(host,puerto);
		
		ObjectInputStream numEnt=new ObjectInputStream(cliente.getInputStream());
		ObjectOutputStream numSal=new ObjectOutputStream(cliente.getOutputStream());
		
		
		//Repetiremos el bucle hasta que introduzcamos 0 o un numero negativo
		do {
			//Escribimos el numero
			System.out.println("Escriba un numero: ");
			numero=Integer.parseInt(entrada.readLine());
			
			//Guardamos el numero en el objeto Numeros
			Numeros dato=new Numeros(numero, 0, 0);
			
			//Escribimos el objeto para enviarlo al servidor
			numSal.writeObject(dato);
			System.out.println("Envio: "+dato.getNumero());
			
			//Recibimos el objeto de nuevo. Lo leemos y lo imprimimos
			dato=(Numeros) numEnt.readObject();
			System.out.println("Cuadrado: "+dato.getCuadrado()+" --- Cubo: "+dato.getCubo());
		}while(numero>0);
		
		//Cerramos la conexion
		numEnt.close();
		numSal.close();
		cliente.close();
	}

}
