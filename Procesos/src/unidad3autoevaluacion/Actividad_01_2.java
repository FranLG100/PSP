package unidad3autoevaluacion;

import java.io.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Actividad_01_2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		//CLIENTE
		
		//Preparamos los datos para conectarnos al servidor (como en los ejercicios anteriores)
		String host="localhost";
		int Puerto=6000;
		BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		
		//Le pedimos al usuario que introduzca un numero
		System.out.println("Introduzca una cadena");
		String cadena=lector.readLine();
		
		//Nos conectamos al servidor
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente=new Socket(host,Puerto);
		
		//Le enviamos el numero (como es un entero, no hace falta poner
		//writeUTF, solo write nos vale)
		DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
		flujoSalida.writeUTF(cadena);
		
		//Si todo sale bien, habremos recibido el numero que enviamos, elevado al cuadrado
		DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
		int msgRecibido=flujoEntrada.read();
		System.out.println("Recibiendo del SERVIDOR:  \n\t"+msgRecibido+" CARACTERES");
		
		//Cerramos
		flujoSalida.close();
		Cliente.close();
	}

}
