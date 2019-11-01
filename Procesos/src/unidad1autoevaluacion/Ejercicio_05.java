package unidad1autoevaluacion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejercicio_05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File directorio=new File(".\\bin");
		ProcessBuilder pb=new ProcessBuilder("java","unidad1autoevaluacion.ProcesoE05","Prueba");
		pb.directory(directorio);
		Process p=pb.start();
		
		//Lee la consola del otro proceso
		InputStream entrada=p.getInputStream();
		int ch;
		while((ch=entrada.read())!=-1)
			System.out.print((char)ch);
		entrada.close();
		
		//Para capturar el error/salida
		int exitVal=0;
		try {
			InputStream is=p.getErrorStream();
			int c=0;
			while ((c=is.read())!=-1) {
				System.out.println((char)c);
			}
			is.close();
			exitVal=p.waitFor();
			System.out.println("Valor de salida: "+exitVal);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
