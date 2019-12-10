package ejerciciostema3parte2.Actividad_05;
import java.io.*;
import java.net.*;

public class Cliente {

	String host;
	int puerto;
	Socket cliente;
	PrintWriter fsalida;
	BufferedReader fentrada;
	BufferedReader in;

	String cadena;
	String eco;
	
	public Cliente() throws UnknownHostException, IOException {
		host="localhost";
		puerto=6000;
		cliente=new Socket(host,puerto);
		fsalida=new PrintWriter(cliente.getOutputStream(), true);
		fentrada= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		in= new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void enviar(String cad) throws IOException {
		//System.out.println("Introduce una cadena: ");
		//cadena=in.readLine();
		fsalida.println(cad);
	}
	
	public String recibir() throws IOException {
		eco=fentrada.readLine();
		System.out.println(" => ECO: "+eco);
		return eco;
	}
	
	public void cerrar() throws IOException {
		fsalida.println("*");
		fsalida.close();
		fentrada.close();
		System.out.println("FIN");
		in.close();
		cliente.close();
	}
	
	//public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		//PrintWriter fsalida=new PrintWriter(cliente.getOutputStream(), true);
		//BufferedReader fentrada= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		//BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		
		//String cadena, eco="";
		
		//do {
			//System.out.println("Introduce una cadena: ");
			//cadena=in.readLine();
			//fsalida.println(cadena);
			//eco=fentrada.readLine();
			//System.out.println(" => ECO: "+eco);
		//}while(!cadena.trim().equals("*"));
		
		
		/*fsalida.close();
		fentrada.close();
		System.out.println("FIN");
		in.close();
		cliente.close();*/
	//}

}
