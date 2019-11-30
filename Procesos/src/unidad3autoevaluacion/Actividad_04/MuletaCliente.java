package unidad3autoevaluacion.Actividad_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import ejemplostema3parte2.Persona;

public class MuletaCliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String host="localhost";
		int puerto=6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente=new Socket(host,puerto);
		
		
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter fsalida=new PrintWriter(cliente.getOutputStream(), true);
		
		
		
		System.out.println("Introduce una cadena: ");
		String cadena=in.readLine();
		fsalida.println(cadena);
		
		ObjectInputStream perEnt=new ObjectInputStream(cliente.getInputStream());
		
		
		Profesor dato=(Profesor) perEnt.readObject();
		
		System.out.println("Recibo: "+dato.getNombre()+" * ");
		
		
		perEnt.close();
		cliente.close();
	}

}
