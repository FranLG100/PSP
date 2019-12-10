package ejerciciostema3parte2.Actividad_03;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import ejerciciostema3parte2.Persona;

public class Actividad_3_Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		InetAddress destino=InetAddress.getLocalHost();
		int port=12345;
		Alumno a=null;
		BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket socket=new DatagramSocket(12346);
		byte[] mensaje=new byte[1024];
		
		String saludos="";
		
		do {
		System.out.println("Introduzca id a consultar");
		saludos=entrada.readLine();
		mensaje=saludos.getBytes();
		
		DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,port);
		socket.send(envio);
		
		
		byte[] recibidos=new byte[1024];
		
		System.out.println("Esperando datagrama...");
		DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
		socket.receive(recibo);

		ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
		ObjectInputStream in=new ObjectInputStream(bais);
		a=(Alumno) in.readObject();
		
		System.out.println(a.getIdalumno());
		System.out.println(a.getNombre());
		System.out.println("Curso:");
		System.out.println("\t"+a.getCurso().getId());
		System.out.println("\t"+a.getCurso().getDescripcion());
		System.out.println("\tNota: "+a.getNota());
		
		in.close();
		}while(!saludos.trim().equals("*"));
		
		socket.close();
	}

}
