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

		int numeroPuerto=6000;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		Socket clienteConectado=null;
		System.out.println("Esperando al cliente...");
		clienteConectado=servidor.accept();
		
		
		
		InputStream entrada=null;
		entrada=clienteConectado.getInputStream();
		DataInputStream flujoEntrada=new DataInputStream(entrada);
		
		int cuadrado=flujoEntrada.read();
		System.out.println("Recibiendo del CLIENTE:  \n\t"+cuadrado);
		
		cuadrado=cuadrado*cuadrado;
		
		OutputStream salida=null;
		salida= clienteConectado.getOutputStream();
		DataOutputStream flujoSalida=new DataOutputStream(salida);
		
		flujoSalida.write(cuadrado);
		
		
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
		
	}

}
