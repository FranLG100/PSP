package ejerciciostema3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Ejercicio_3_6_2 {

private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//CLIENTE
		
		//En este caso, enviaremos datagramas al servidor, esperando que nos devuelva el mensaje
		//pero en mayusculas.
		DatagramSocket clientSocket=new DatagramSocket();
		
		InetAddress IPServidor=InetAddress.getLocalHost();
		int puerto=12345;
		String cadena="";
		do{
			//Escribimos el mensaje
			System.out.println("Introduce mensaje: ");
			cadena=sc.nextLine();
		
			//Lo preparamos
			byte[] enviados=new byte[1024];
			enviados=cadena.getBytes();
			
			//Y lo enviamos
			DatagramPacket envio=new DatagramPacket(enviados, enviados.length,IPServidor,puerto);
			clientSocket.send(envio);
			
			
			//Esperamos la respuesta
			byte[] recibidos=new byte[1024];
			DatagramPacket recibo=new DatagramPacket(recibidos, recibidos.length);
			System.out.println("Esperando datagrama...");
			//Si pasa de los 4s de espera, cerramos la  conexión
			clientSocket.setSoTimeout(4000);
			try{
				//Si no, lo recibimos y vemos el mensaje que nos ha devuelto el servidor
				clientSocket.receive(recibo);
				String respuesta=new String(recibo.getData());
				System.out.println(respuesta);
			}catch (InterruptedIOException e) {
				System.out.println("El paquete se ha perdido :(");
				cadena="*";
			}
	
			//Repetiremos el proceso hasta escribir un asterisco, o
			//comprobar que no tenemos conexión
		}while(!cadena.equalsIgnoreCase("*"));
		
		//Cerramos
		clientSocket.close();
	}

}
