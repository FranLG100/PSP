package ejerciciostema3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejercicio_3_3_2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		String host="localhost";
		int Puerto=6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente=new Socket(host,Puerto);
		
		
		
		
		DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
		String msgRecibido=flujoEntrada.readUTF();
		System.out.println("Recibiendo del SERVIDOR:  \n\t"+msgRecibido);
		
	
		DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
		flujoSalida.writeUTF(msgRecibido.toLowerCase());
		
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();
	}

}
