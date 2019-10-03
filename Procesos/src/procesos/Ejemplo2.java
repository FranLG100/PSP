package procesos;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Process p= new ProcessBuilder("CMD","/C","DIR").start();

		try {
			int c;
			InputStream is=p.getInputStream();
			while((c=is.read()) !=-1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int exitVal;
		try {
			//El wait for espera a que el proceso p finalice.
			//El método recoge lo que System.exit() devuelve, por defecto en Java, 0 si el proceso
			//acaba correctamente.
			exitVal=p.waitFor();
			System.out.println("Valor de salida: "+exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
