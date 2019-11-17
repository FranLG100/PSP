package ejemplostema3;

import java.io.IOException;
import java.net.*;

public class UDPCliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InetAddress destino=InetAddress.getLocalHost();
		int port=12345;
		byte[] mensaje=new byte[1024];
		String saludos="Enviando saludos";
		mensaje=saludos.getBytes();
		
		DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,port);
		DatagramSocket socket=new DatagramSocket(34567);
		
		System.out.println("Longitud del datagrama: "+mensaje.length);
		System.out.println("Host destino: "+destino.getHostName());
		System.out.println("IP destino: "+destino.getHostAddress());
		System.out.println("Puerto Local del Socket: "+socket.getLocalPort());
		System.out.println("Puerto de envío: "+envio.getPort());
		
		socket.send(envio);
		socket.close();
	}

}
