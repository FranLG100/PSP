package ejerciciostema3parte2;
import java.io.*;
import java.net.*;

public class Ejercicio3_8_2 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		InetAddress destino=InetAddress.getLocalHost();
		int port=12345;
		
		//Creamos el objeto Persona a enviar
		Persona p=new Persona("Maria",22);

		//Nos preparamos para su envio
		ByteArrayOutputStream bs=new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(bs);
		out.writeObject(p);
		out.close();
		
		byte[] mensaje=bs.toByteArray();
		
		//Preparamos el datagrama
		DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,port);
		DatagramSocket socket=new DatagramSocket();
		
		//Lo enviamos
		socket.send(envio);
		
		byte[] recibidos=new byte[1024];
		
		//Recibimos el datagrama
		System.out.println("Esperando datagrama...");
		DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
		socket.receive(recibo);

		//Nos preparamos para convertirlo a un objeto
		ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
		ObjectInputStream in=new ObjectInputStream(bais);
		//Lo convertimos
		Persona persona=(Persona) in.readObject();
		//Leemos su Nombre y su Edad
		System.out.println(persona.getNombre());
		System.out.println(persona.getEdad());
		
		in.close();
		
		//Cerramos
		socket.close();
	}

}
