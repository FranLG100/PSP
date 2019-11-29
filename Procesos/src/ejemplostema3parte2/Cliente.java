package ejemplostema3parte2;
import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		String host="localhost";
		int puerto=6000;
		Socket cliente=new Socket(host,puerto);
		
		PrintWriter fsalida=new PrintWriter(cliente.getOutputStream(), true);
		BufferedReader fentrada= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		
		String cadena, eco="";
		
		do {
			System.out.println("Introduce una cadena: ");
			cadena=in.readLine();
			fsalida.println(cadena);
			eco=fentrada.readLine();
			System.out.println(" => ECO: "+eco);
		}while(!cadena.trim().equals("*"));
		
		
		fsalida.close();
		fentrada.close();
		System.out.println("FIN");
		in.close();
		cliente.close();
	}

}
