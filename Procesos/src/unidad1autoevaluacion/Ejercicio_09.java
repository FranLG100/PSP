package unidad1autoevaluacion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio_09 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		ProcessBuilder pb= new ProcessBuilder("java", "unidad1autoevaluacion.ProcesoE07");
		File directorio=new File(".\\bin");
		pb.directory(directorio);
		
		File entrada=new File("entradaProceso09.txt");
		pb.redirectInput(entrada);
		Process p=pb.start();
		
		InputStream entradad=p.getInputStream();
		int ch;
		while((ch=entradad.read())!=-1)
			System.out.print((char)ch);
		entradad.close();
	}

}
