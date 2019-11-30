package unidad3autoevaluacion.Actividad_02.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Servidor {

	MulticastSocket ms;
	BufferedReader in;
	int puerto=55557;
	InetAddress grupo=InetAddress.getByName("230.0.0.1");
	String cadena="";
	
	public Servidor() throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));	
		ms= new MulticastSocket();
		this.cadena="";
		System.out.println("Datos a enviar al grupo: ");
	}
	
	public void enviarMsg(String cadena) throws IOException {
		this.cadena=cadena;
		DatagramPacket paquete=new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
		ms.send(paquete);
	}
	
	public void cerrar() {
		this.ms.close();
		System.out.println("Socket cerrado...");
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		//while(!cadena.trim().equals("*")) {
			//System.out.println("Datos a enviar al grupo: ");
			//cadena=in.readLine();
			
			//DatagramPacket paquete=new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
			
			//ms.send(paquete);
			
		//};
		//ms.close();
		//System.out.println("Socket cerrado...");
		
	}

}
