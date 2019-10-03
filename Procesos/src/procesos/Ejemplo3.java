package procesos;

import java.io.File;
import java.io.IOException;

import java.io.InputStream;

public class Ejemplo3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//File directorio = new File(".\\bin\\procesos");
		
		ProcessBuilder pb=new ProcessBuilder("java","LeerNombre");
		
		//pb.directory(directorio);
		System.out.printf("Directorio de trabajo: %s%n", pb.directory());
		
		Process p=pb.start();
		
		int exitVal;
		try {
			InputStream is= p.getInputStream();
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
