package procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio1_6_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File directorio=new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","procesos.Ejercicio1_6");
		pb.directory(directorio);
		Process p=pb.start();
		
		//Le escribimos, con el write, los parametros que le vamos a meter al proceso para que ejecute la suma
		OutputStream os=p.getOutputStream();
		os.write("3\n9\n".getBytes());
		os.flush(); //Para vaciar el buffer de salida
		
		//lectura -- obtiene la salida del proceso Ejercicio1_6
		InputStream is=p.getInputStream();
		int c;
		while((c=is.read())!=-1)
			System.out.print((char)c);
		is.close();
		
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
