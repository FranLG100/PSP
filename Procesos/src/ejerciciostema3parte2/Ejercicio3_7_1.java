package ejerciciostema3parte2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio3_7_1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		//SERVIDOR
		int numeroPuerto=6000;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		
		//Atendemos a un cliente
		System.out.println("Esperando al cliente...");
		Socket cliente=servidor.accept();
		int numero=0;
		
		ObjectOutputStream outObjeto=new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream inObjeto=new ObjectInputStream(cliente.getInputStream());
		
		//Repetimos el bucle hasta recibir 0 o un numero negativo
		do{
			//Leemos el objeto que nos envia el cliente
			Numeros dato= (Numeros) inObjeto.readObject();
			numero=dato.getNumero();
			System.out.println("Recibo: "+dato.getNumero());
			
			//Lo elevamos al cuadrado y al cubo
			dato.setCuadrado(numero*numero);
			dato.setCubo(dato.getCuadrado()*numero);
			
			//Sobreescribimos el objeto Numeros y se lo reenviamos al cliente
			outObjeto.writeObject(dato);
			System.out.println("Envio: "+dato.getCuadrado()+"    "+dato.getCubo());
			
		}while(numero>0);
		
		//Cerramos la conexion
		outObjeto.close();
		inObjeto.close();
		cliente.close();
		servidor.close();
	}

}
