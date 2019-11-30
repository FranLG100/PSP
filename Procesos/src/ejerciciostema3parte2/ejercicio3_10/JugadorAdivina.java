package ejerciciostema3parte2.ejercicio3_10;
import java.io.*;
import java.net.*;
import java.util.*;
public class JugadorAdivina {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String host="localhost";
		int puerto=6001;
		Socket cliente=new Socket(host,puerto);
		
		ObjectOutputStream fsalida= new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream fentrada= new ObjectInputStream(cliente.getInputStream());
		
		Scanner sc=new Scanner(System.in);
		String cadena="";
		
		Datos datos=(Datos) fentrada.readObject();
		int identificador=datos.getIdentificador();
		System.out.println("Id jugador: "+identificador);
		System.out.println(datos.getCadena());
		
		if(!datos.isJuega())
			cadena="*";
		
		while(datos.isJuega() && !cadena.trim().equals("*")) {
			System.out.println("Intento: "+(datos.getIntentos()+1)+" =>Introduce numero: ");
			cadena=sc.nextLine();
			Datos d=new Datos();
			
			if(!validarCadena(cadena)) continue;
			
			d.setCadena(cadena);
			
			fsalida.reset();
			fsalida.writeObject(d);
			
			datos=(Datos) fentrada.readObject();
			System.out.println("\t"+datos.getCadena());
			
			if(datos.getIntentos()>=5) {
				System.out.println("\t<<JUEGO FINALIZADO, NO HAY MÁS INTENTOS>>");
				cadena="*";
			}
			if(datos.isGana()) {
				System.out.println("<<HAS GANADO!! EL JUEGO HA TERMINADO>>");
				cadena="*";
			}else
				if(!(datos.isJuega())) {
					System.out.println("<<EL JUEGO HA TERMINADO, HAN ADIVINADO EL NUMERO>>");
					cadena="*";
				}
		}
		
		fsalida.close();
		fentrada.close();
		System.out.println("Fin de proceso...");
		sc.close();
		cliente.close();
	}
	
	private static boolean validarCadena(String cadena) {
		boolean valor=false;
		try {
			Integer.parseInt(cadena);
			valor=true;
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		return valor;
	}

}
