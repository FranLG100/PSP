package ejerciciostema3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejercicio_3_3_2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		//CLIENTE
		
		//Nos conectaremos al puerto 6000 del localhost
		String host="localhost";
		int Puerto=6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente=new Socket(host,Puerto);
		
		//Nos preparamos para recibir un mensaje
		DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
		//Lo recibimos
		String msgRecibido=flujoEntrada.readUTF();
		System.out.println("Recibiendo del SERVIDOR:  \n\t"+msgRecibido);
		
		//Ahora, pasamos el mensaje a minusculas y se lo devolvemos al servidor
		DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
		flujoSalida.writeUTF(msgRecibido.toLowerCase());
		
		
		//Por ultimo, cerramos todos los flujos (y el cliente)
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();
	}

}
