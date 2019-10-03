package procesos;

import java.io.IOException;
import java.io.InputStream;

public class Ejercicio1_5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//File directorio = new File(".\\bin\\procesos");
		
				//ProcessBuilder pb=new ProcessBuilder("CMD","/C","DIRR");
				ProcessBuilder pb=new ProcessBuilder("java","procesos.LeerNombreEjecucion");
				//pb.directory(directorio);
				
				/*Lo que nos aparecería por pantalla al ejecutar un programa de java que
				 * no existe, sería : 'No se ha encontrado o cargado la clase principal (nombre)*/
				
				Process p=pb.start();
				
				int exitVal;
				try {
					InputStream is= p.getErrorStream();
					int c;
					while((c=is.read())!=-1)
						System.out.print((char)c);
					is.close();
					exitVal=p.waitFor();
					System.out.println("Valor de salida: "+exitVal);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
