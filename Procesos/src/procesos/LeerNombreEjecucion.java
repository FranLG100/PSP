package procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeerNombreEjecucion {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

File directorio = new File(".\\bin");
		
		ProcessBuilder pb=new ProcessBuilder("java","procesos.LeerNombre","Prueba");
		//pb.command("java","LeerNombre");
		pb.directory(directorio);
		System.out.printf("Directorio de trabajo: %s%n", pb.directory());
		
		Process p=pb.start();
		
		int exitVal;
		try {
			InputStream is= p.getErrorStream();
			int c;
			while((c=is.read())!=-1)
				System.out.print((char)c);
			is.close();
			exitVal=p.waitFor();
			System.out.println("Valor de salida: "+exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
