package ejerciciostema5;

import java.io.IOException;
import java.security.*;

import utilesFran.Amadeus;

public class Ejercicio5_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		MessageDigest md;
		Amadeus amadeus=new Amadeus();
		
		//Primera parte del ejercicio, con MD5
		System.out.println("PRUEBA CON MD5");
		try {
			md= MessageDigest.getInstance("MD5"); //Escogemos el algoritmo a implementar
			String texto="Esto es un texto plano"; //Texto a cifrar
			String clave="Clave de cifrado"; //Clave de cifrado
			
			byte dataBytes[]= texto.getBytes();
			
			//Y lo ciframos
			md.update(dataBytes);
			
			//byte resumen[]=md.digest();
			byte resumen[]=md.digest(clave.getBytes()); //Con la clave
			
			System.out.println("Mensaje original: "+texto);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			
			System.out.println("Mensaje en Hexadecimal "+Hexadecimal(resumen));
			
			Provider proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		System.out.println("AHORA COMPARAREMOS DOS CADENAS CON SHA-256");
		
		try {
			md= MessageDigest.getInstance("SHA-256");
			
			System.out.println("INTRODUCE UNA CLAVE");
			String clave=amadeus.recibeTexto();
			System.out.println("INTRODUCE UN TEXTO");
			String texto1=amadeus.recibeTexto();
			System.out.println("INTRODUCE OTRO");
			String texto2=amadeus.recibeTexto();
			
			
			System.out.println("\nCASO UNO");
			byte dataBytes[]= texto1.getBytes();
			md.update(dataBytes);
			
			//byte resumen[]=md.digest();
			byte resumen[]=md.digest(clave.getBytes());
			
			System.out.println("Mensaje original: "+texto1);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			
			System.out.println("Mensaje en Hexadecimal "+Hexadecimal(resumen));
			
			Provider proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
			
			
			System.out.println("\nCASO DOS");
			dataBytes= texto2.getBytes();
			md.update(dataBytes);
			
			//byte resumen[]=md.digest();
			resumen=md.digest(clave.getBytes());
			
			System.out.println("Mensaje original: "+texto2);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			
			System.out.println("Mensaje en Hexadecimal "+Hexadecimal(resumen));
			
			proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
			System.out.println("\nCOMO HEMOS COMPROBADO, LOS RESUMENES NO SON IGUALES");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	static String Hexadecimal(byte[] resumen) {
		String hex="";
		for (int i = 0; i < resumen.length; i++) {
			String h=Integer.toHexString(resumen[i] & 0xFF);
			if(h.length()==1) hex+="0";
			hex+=h;
		}
		return hex.toUpperCase();
	}

}