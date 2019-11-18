package ejerciciostema3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio_3_4_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//SERVIDOR
		
		//Abrimos el servidor, puerto 6000
		int numeroPuerto=6000;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		Socket clienteConectado=null;
		
		//Esperamos al cliente
		System.out.println("Esperando al cliente...");
		clienteConectado=servidor.accept();
		
		
		//Nos preparamos para recibir información del cliente
		InputStream entrada=null;
		entrada=clienteConectado.getInputStream();
		DataInputStream flujoEntrada=new DataInputStream(entrada);
		
		//Como es un entero, no nos hace falta poner readUTF,
		//solo con read nos vale
		int cuadrado=flujoEntrada.read();
		System.out.println("Recibiendo del CLIENTE:  \n\t"+cuadrado);
		
		//Elevamos el numero al cuadrado
		cuadrado=cuadrado*cuadrado;
		
		//Y se lo devolvemos al cliente
		OutputStream salida=null;
		salida= clienteConectado.getOutputStream();
		DataOutputStream flujoSalida=new DataOutputStream(salida);
		
		flujoSalida.write(cuadrado);
		
		//Cerramos todos los flujos
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
		
	}

}
