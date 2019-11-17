package ejemplostema3;

import java.io.IOException;
import java.net.*;

public class UDPServidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte[] bufer=new byte[1024];
		
		DatagramSocket socket=new DatagramSocket(12345);
		
		System.out.println("Esperando datagrama...");
		DatagramPacket recibo=new DatagramPacket(bufer,bufer.length);
		socket.receive(recibo);
		int bytesRec=recibo.getLength();
		String paquete=new String(recibo.getData());
		
		System.out.println("Número de bytes recibidos: "+bytesRec);
		System.out.println("Contenido del paquete: "+paquete.trim());
		System.out.println("Puerto origen del mensaje: "+recibo.getPort());
		System.out.println("IP de origen: "+recibo.getAddress().getHostAddress());
		System.out.println("Puerto destino del mensaje: "+socket.getLocalPort());
		
		socket.close();
	}

}
