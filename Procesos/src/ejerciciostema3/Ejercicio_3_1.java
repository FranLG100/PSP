package ejerciciostema3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Ejercicio_3_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca web o equipo para visualizar su información");
		String direccion=lector.readLine();
		
		InetAddress dir=null;
		System.out.println("====================================");
		System.out.println("SALIDA PARA LOCALHOST: ");
		try {
			dir= InetAddress.getByName("localhost");
			pruebaMetodos(dir);
			
			System.out.println("=====================================");
			System.out.println("SALIDA PARA UNA URL: ");
			dir=InetAddress.getByName(direccion);
			pruebaMetodos(dir);
			
			System.out.println("\tDIRECCIONES IP PARA: "+dir.getHostName());
			InetAddress[] direcciones=InetAddress.getAllByName(dir.getHostName());
			
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t"+direcciones[i].toString());
			}
			
			System.out.println("========================================");
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMetodo getByName(): "+dir);
		InetAddress dir2;
		try {
			dir2= InetAddress.getLocalHost();
			System.out.println("\tMetodo getLocalHost(): "+dir2);
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("\tMetodo getHostName(): "+dir.getHostName());
		System.out.println("\tMetodo getHostAddress(): "+dir.getHostAddress());
		System.out.println("\tMetodo toString(): "+dir.toString());
		System.out.println("\tMetodo getCanonicalHostName(): "+dir.getCanonicalHostName());
	}

}
