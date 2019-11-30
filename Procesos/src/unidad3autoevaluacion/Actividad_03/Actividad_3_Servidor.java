package unidad3autoevaluacion.Actividad_03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;

import ejerciciostema3parte2.Persona;

public class Actividad_3_Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Curso c1=new Curso("C01", "Desarrollo Aplicaciones Multiplataforma");
		Curso c2=new Curso("C02", "Realizacion Audiovisual");
		Curso c3=new Curso("C03", "Literatura Castellana");
		Alumno a1=new Alumno("A01", "Francisco Lorente", c1, 9);
		Alumno a2=new Alumno("A02", "Alejandro Hinojosa", c1, 6);
		Alumno a3=new Alumno("A03", "Firas Velazquez", c2, 7);
		Alumno a4=new Alumno("A04", "Almudena Jimenez", c2, 9);
		Alumno a5=new Alumno("A05", "Jairo Rodriguez", c3, 10);
		Alumno a;
		Curso c;
		HashMap<String,Alumno> alumnos=new HashMap<String,Alumno>();
		
		alumnos.put(a1.getIdalumno(), a1);
		alumnos.put(a2.getIdalumno(), a2);
		alumnos.put(a3.getIdalumno(), a3);
		alumnos.put(a4.getIdalumno(), a4);
		alumnos.put(a5.getIdalumno(), a5);
		
		String paquete="";
		DatagramSocket socket=new DatagramSocket(12345);
		byte[] recibidos=new byte[1024];
		
		
		//RECIBO
		do {
			System.out.println("Esperando datagrama...");
			DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
			
			socket.receive(recibo);
			paquete=new String(recibo.getData()).trim();
			System.out.println("Recibido: "+paquete);
			
			
			
			//ENVIO
			if(alumnos.containsKey(paquete)) {
				a=alumnos.get(paquete);
			}else {
				c=new Curso("0","No existe");
				a=new Alumno("0", "No existe", c, 0);
			}
			ByteArrayOutputStream bs=new ByteArrayOutputStream();
			ObjectOutputStream out=new ObjectOutputStream(bs);
			out.writeObject(a);
			out.close();
			
			byte[] mensaje=bs.toByteArray();
			
			InetAddress destino=InetAddress.getLocalHost();
			int port=12346;
			
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,port);
			
	
			socket.send(envio);
		}while(!paquete.trim().contains("*"));
		
		socket.close();
	}

}
