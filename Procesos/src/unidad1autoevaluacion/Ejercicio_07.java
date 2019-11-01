package unidad1autoevaluacion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio_07 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ProcessBuilder pb= new ProcessBuilder("java", "unidad1autoevaluacion.ProcesoE07");
		File directorio=new File(".\\bin");
		pb.directory(directorio);
		
		Process p=pb.start();
		
		OutputStream os=p.getOutputStream();
		os.write("Prueba\nOtra Prueba\nFinal\n*\n".getBytes());
		os.flush();
		
		InputStream entrada=p.getInputStream();
		int ch;
		while((ch=entrada.read())!=-1)
			System.out.print((char)ch);
		entrada.close();
	}

}
