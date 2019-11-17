package ejemplostema3;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPclienteEjemplo2 {

	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DatagramSocket clientSocket=new DatagramSocket();
		
		InetAddress IPServidor=InetAddress.getLocalHost();
		int puerto=12345;
		
		System.out.println("Introduce mensaje: ");
		String cadena=sc.nextLine();
		
		byte[] enviados=new byte[1024];
		enviados=cadena.getBytes();
		
		DatagramPacket envio=new DatagramPacket(enviados, enviados.length,IPServidor,puerto);
		
		clientSocket.send(envio);
		
		byte[] recibidos=new byte[2];
		DatagramPacket recibo=new DatagramPacket(recibidos, recibidos.length);
		System.out.println("Esperando datagrama...");
		clientSocket.receive(recibo);
		
		byte[] hh=recibo.getData();
		int numero=hh[0];
		
		System.out.println("Recibo Nº de caracteres que son a=> "+numero);
		
		clientSocket.close();
	}

}
