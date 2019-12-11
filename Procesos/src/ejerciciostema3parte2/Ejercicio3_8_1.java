package ejerciciostema3parte2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio3_8_1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//SERVIDOR UDP
		//Preparamos el puerto al que podran enviarnos datagramas
		DatagramSocket socket=new DatagramSocket(12345);
		byte[] recibidos=new byte[1024];
		
		//Esperamos recibir datagrama
		System.out.println("Esperando datagrama...");
		DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
		//Lo recibimos
		socket.receive(recibo);

		//Preparamos las herramientas para 'interpretar' el datagrama
		//recibido como un objeto
		ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
		ObjectInputStream in=new ObjectInputStream(bais);
		//Leemos el datagrama (como objeto), e imprimimos sus datos
		Persona persona=(Persona) in.readObject();
		System.out.println(persona.getNombre());
		System.out.println(persona.getEdad());
		
		//Obtenemos el puerto de quien nos envia el datagrama
		int puertoEnvio=recibo.getPort();
		in.close();
		
		
		//Alteramos las propiedades el objeto
		persona.setEdad(24);
		persona.setNombre("Juan");
		
		//Preparamos las herramientas para enviarlo
		ByteArrayOutputStream bs=new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(bs);
		//Lo escribimos para ser enviado
		out.writeObject(persona);
		out.close();
		
		byte[] mensaje=bs.toByteArray();
		
		InetAddress destino=InetAddress.getLocalHost();
		int port=12346;
		
		//Preparamos el datagrama
		DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,puertoEnvio);
		
		//Lo enviamos
		socket.send(envio);
		socket.close();
		
		/*System.out.println("Numero de bytes recibidos: "+bytesRec);
		System.out.println("Contenido del paquete: "+paquete.trim());
		System.out.println("Puerto origen del mensaje: "+recibo.getPort());
		System.out.println("IP de origen: "+recibo.getAddress().getHostAddress());
		System.out.println("Puerto destino del mensaje: "+socket.getLocalPort());*/
		
	}

}
