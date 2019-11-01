package unidad1autoevaluacion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejercicio_04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File directorio=new File(".\\bin");
		ProcessBuilder pb=new ProcessBuilder("java","unidad1autoevaluacion.ProcesoE04","-4");
		pb.directory(directorio);
		Process p=pb.start();
		
		int exitVal;
		try {
			//Capturamos el error
			/*Lo que nos aparecera por pantalla al ejecutar un programa de java que
			 * no existe, sera : 'No se ha encontrado o cargado la clase principal (nombre)*/
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
