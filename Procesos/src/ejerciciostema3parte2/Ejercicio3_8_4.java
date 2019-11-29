package ejerciciostema3parte2;
import java.io.*;
import java.net.*;

public class Ejercicio3_8_4 {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
		
		InetAddress destino=InetAddress.getLocalHost();
		int puerto=6000;
		int numero=0;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		DatagramSocket cliente=new DatagramSocket(6001);
	
		
		do {
			System.out.println("Escriba un número: ");
			numero=Integer.parseInt(entrada.readLine());
			
			Numeros dato=new Numeros(numero, 0, 0);
			
			ByteArrayOutputStream bs=new ByteArrayOutputStream();
			ObjectOutputStream out=new ObjectOutputStream(bs);
			out.writeObject(dato);
			out.close();
			
			byte[] mensaje=bs.toByteArray();
			
			DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,puerto);
			
			cliente.send(envio);
			
			byte[] recibidos=new byte[1024];
			
			System.out.println("Esperando datagrama...");
			DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);
			cliente.receive(recibo);

			ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
			ObjectInputStream in=new ObjectInputStream(bais);
			Numeros n=(Numeros) in.readObject();
			System.out.println(n.getCuadrado()+" - - - "+n.getCubo());
			
			in.close();

		}while(numero>0);

		cliente.close();
	}

}
