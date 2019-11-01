package unidad1autoevaluacion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejercicio_08 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ProcessBuilder pb= new ProcessBuilder("java", "unidad1autoevaluacion.ProcesoE08");
		File directorio=new File(".\\bin");
		pb.directory(directorio);
		
		
		File FIn=new File("entradaProceso08.txt");
		File FError=new File("errorProceso08.txt");
		pb.redirectInput(FIn);
		pb.redirectError(FError);
		
		Process p=pb.start();
		
		InputStream entrada=p.getInputStream();
		int ch;
		while((ch=entrada.read())!=-1)
			System.out.print((char)ch);
		entrada.close();
	}

}
