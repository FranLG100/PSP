package procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeerNombreEjecucion {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		//Establecemos el directorio del cual vamos a iniciar el programa
		File directorio = new File(".\\bin");
		
		//Creamos el proceso (pero no lo iniciamos)
		//Le pasamos el comando, la clase a ejecutar (LeerNombre, del paquete procesos), y un parametro de entrada
		ProcessBuilder pb=new ProcessBuilder("java","procesos.LeerNombre","Prueba");
		pb.directory(directorio);
		System.out.printf("Directorio de trabajo: %s%n", pb.directory());
		
		//Iniciamos el proceso
		Process p=pb.start();
		
		//Creamos una variable para recoger el valor de salida del proceso
		int exitVal;
		//Imprimimos tanto el valor de salida, como los posibles errores
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
