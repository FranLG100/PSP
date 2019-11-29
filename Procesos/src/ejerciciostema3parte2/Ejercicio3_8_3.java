package ejerciciostema3parte2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio3_8_3 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		int numeroPuerto=6000;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		
		System.out.println("Esperando al cliente...");
		Socket cliente=servidor.accept();
		int numero=0;
		
		ByteArrayOutputStream bs=new ByteArrayOutputStream();
		ObjectOutputStream outObjeto=new ObjectOutputStream(bs);
		
		byte[] recibido=new byte[1024];
		ByteArrayInputStream bais=new ByteArrayInputStream(recibido);
		ObjectInputStream inObjeto=new ObjectInputStream(bais);
		
		
		
		do{
			Numeros dato= (Numeros) inObjeto.readObject();
			numero=dato.getNumero();
			System.out.println("Recibo: "+dato.getNumero());
			
			dato.setCuadrado(numero*numero);
			dato.setCubo(dato.getCuadrado()*numero);
			
			outObjeto.writeObject(dato);
			System.out.println("Envio: "+dato.getCuadrado()+"    "+dato.getCubo());
			
		}while(numero>0);
		
		
		outObjeto.close();
		inObjeto.close();
		cliente.close();
		servidor.close();
	}

}
