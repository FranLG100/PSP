package ejerciciostema3;

import java.io.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejercicio_3_4_2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		String host="localhost";
		int Puerto=6000;
		BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduzca un número");
		int numero=Integer.parseInt(lector.readLine());
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente=new Socket(host,Puerto);
		
		
		
		
		
		
	
		DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
		flujoSalida.write(numero);
		
		DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
		int msgRecibido=flujoEntrada.read();
		System.out.println("Recibiendo del SERVIDOR:  \n\t"+msgRecibido);
		
		flujoSalida.close();
		Cliente.close();
	}

}
