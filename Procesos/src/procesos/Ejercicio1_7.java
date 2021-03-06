package procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio1_7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Esto es una variante del ejercicio anterior
		File directorio=new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","procesos.Ejemplo5");
		pb.directory(directorio);
		
		//Vamos a especificar de donde va a coger los comandos
		File fBat=new File("ej7entrada.bat");
		//Hacia donde va a enviar la salida
		File fOut=new File("salida.txt");
		//Y hacia donde va a enviar los errores, si se produjesen
		File fErr=new File("error.txt");
		
		//Hacemos las redirecciones
		pb.redirectInput(fBat);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		Process p=pb.start();
		
		//Y cuando se ejecute el programa, deberian crearse o sobrescribirse los archivos txt
		
		//COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal=p.waitFor();
			System.out.println("Valor de salida: "+exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
