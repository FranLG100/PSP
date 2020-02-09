package unidad5autoevaluacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.security.Provider;

import javax.swing.JFileChooser;

import utilesFran.Amadeus;

public class Actividad_02 {
	
	public static String leerArchivo(File archivo) {
		String devolucion="";
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String lectura;
			lectura = entrada.readLine();
			while (lectura != null) {
				devolucion+=lectura+"\n";
				lectura = entrada.readLine();
			}
			entrada.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return devolucion;
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

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String txtCifrar="";
		MessageDigest md; 
		
		try {
			JFileChooser f= new JFileChooser();
			f.setFileSelectionMode(JFileChooser.FILES_ONLY);
			f.setDialogTitle("Selecciona el Fichero");
			int returnVal=f.showDialog(f, "Cargar");
			File file=f.getSelectedFile();
			String archivo=file.getAbsolutePath();
			String nombreArchivo=file.getName();
			
			
			System.out.println("\nCASO UNO");
			md= MessageDigest.getInstance("MD5"); //Escogemos el algoritmo a implementar
			String texto=leerArchivo(file); //Texto a cifrar
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
			
			
			
			System.out.println("\nCASO DOS");
			md= MessageDigest.getInstance("SHA-256"); //Escogemos el algoritmo a implementar
			texto=leerArchivo(file); //Texto a cifrar
			clave="Clave de cifrado"; //Clave de cifrado
			
			dataBytes= texto.getBytes();
			
			//Y lo ciframos
			md.update(dataBytes);
			
			//byte resumen[]=md.digest();
			resumen=md.digest(clave.getBytes()); //Con la clave
			
			System.out.println("Mensaje original: "+texto);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			
			System.out.println("Mensaje en Hexadecimal "+Hexadecimal(resumen));
			
			proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
