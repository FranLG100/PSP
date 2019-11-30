package unidad3autoevaluacion.Actividad_04;
import java.io.*;
import java.net.*;

import ejemplostema3parte2.Persona;

public class Cliente{

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String host="localhost";
		int puerto=6000;
		String cadena="";
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente=new Socket(host,puerto);
		
		
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter fsalida=new PrintWriter(cliente.getOutputStream(), true);
		ObjectInputStream perEnt=null;
		
		do{
			System.out.println("Introduce una cadena: ");
			cadena=in.readLine();
			fsalida.println(cadena);
			
			perEnt=new ObjectInputStream(cliente.getInputStream());
			
			Profesor dato=(Profesor) perEnt.readObject();
			
			System.out.println("Recibo: "+dato.getNombre()+" * ");
		}while((!cadena.trim().equals("*")) );
		System.out.println("Salimos");
		perEnt.close();
		cliente.close();
	}

}
