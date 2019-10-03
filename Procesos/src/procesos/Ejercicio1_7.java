package procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio1_7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File directorio=new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","procesos.Ejemplo5");
		pb.directory(directorio);
		File fBat=new File("ej7entrada.bat");
		File fOut=new File("salida.txt");
		File fErr=new File("error.txt");
		
		pb.redirectInput(fBat);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		Process p=pb.start();
		
		//OutputStream os=p.getOutputStream();
		//os.write("Hola Fran\n".getBytes());
		//os.flush(); //Para vaciar el buffer de salida
		
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
