package procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio1_8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Esto es una variante del ejercicio anterior
		File directorio=new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","procesos.Ejemplo5");
		pb.directory(directorio);
		
		//Vamos a especificar de donde va a coger los comandos
		File fBat=new File("ej7entrada.bat");
		//Hacia donde va a enviar la salida
		File fOut=new File("salidaEj8.txt");
		//Y hacia donde va a enviar los errores, si se produjesen
		File fErr=new File("errorEj8.txt");
		
		//Hacemos las redirecciones
		//Como variante del anterior, hacemos Redirect.from/appendTo/INHERIT/to
		//Cogemos la entrada de este fichero
		pb.redirectInput(ProcessBuilder.Redirect.from(fBat));
		//Redireccionamos la salida a este fichero
		pb.redirectOutput(ProcessBuilder.Redirect.appendTo(fOut));
		//O a la consola de Eclipse (Si comentamos esta linea, sera solo al fichero de salida)
		//De lo contrario, se pondra solo en la consola
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		//Redireccionamos los errores a este fichero
		pb.redirectError(ProcessBuilder.Redirect.to(fErr));
		Process p=pb.start();
		
		//Y cuando se ejecute el programa, deberian crearse o sobrescribirse los archivos txt
	}

}