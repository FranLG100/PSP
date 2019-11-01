package unidad1autoevaluacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejercicio_06 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Cadena a introducir: ");
		String cadena;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		cadena=br.readLine();
		
		//Lo que queremos escribir cinco veces, llega desde los argumentos del main
		ProcessBuilder pb= new ProcessBuilder("java","unidad1autoevaluacion.ProcesoE06",cadena);
		File directorio=new File(".\\bin");
		pb.directory(directorio);
		

		File fOut=new File("salidaE06.txt");
		pb.redirectOutput(fOut);
		
		
		Process p=pb.start();
	
		//Salida a txt
		
		try {
			int exitVal=0;
			int c=0;
			InputStream is=p.getErrorStream();
			while((c=is.read())!=-1) {
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
