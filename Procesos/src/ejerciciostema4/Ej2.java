package ejerciciostema4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import utilesFran.Amadeus;

public class Ej2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Seguramente, no funcione fuera de mi local porque tiene datos muy especificos
		//pero seguimos hacia adelante
		Amadeus amadeus=new Amadeus();
		String usuario;
		do {
			System.out.println("Introduzca usuario");
			usuario=amadeus.recibeTexto();
			
			System.out.println("Introduzca pass");
			String clave=amadeus.recibeTexto();
			
			FTPClient cliente=new FTPClient();
			//nos conectaremos a localhost
			String servFTP="localhost";
			//String servFTP="ftp.rediris.es";
			System.out.println("Nos conectamos a: "+servFTP);
			//usuario y clave del usuario con permisos asignados a una carpeta de nuestro servidos
			
			
			String directorio="/LOG/";
			
			try {
				//nos conectamos
				cliente.connect(servFTP);
				//Se le indica al cliente a que puerto debe conectarse, en caso de ser activo
				//seria aleatorio, pero mayor de 1024
				cliente.enterLocalPassiveMode();
				
				//Comprobamos si el login es correcto
				//si no lo es, desconectamos
				boolean login=cliente.login(usuario, clave);
				
				if(login) {
					System.out.println("Login correcto");
				
				//imprimimos el directorio actual
				System.out.println("Directorio actual: "+cliente.printWorkingDirectory());
				//hacemos un array de archivos (los listamos)
				FTPFile[] files=cliente.listFiles();
				System.out.println("Ficheros en el directorio actual: "+files.length);
				
				//Y de tipos (para imprimir)
				String tipos[]= {"Fichero","Directorio","Enlace simb."};
				
				//imprimimos los nombres de los archivos y sus tipos
				for (int i = 0; i < files.length; i++) {
					System.out.println("\t"+files[i].getName()+" => "+tipos[files[i].getType()]);
				}
				
				//volvemos a cambiar de directorio
				//y volvemos a listar
				cliente.changeWorkingDirectory(directorio);
				System.out.println("Directorio actual: "+cliente.printWorkingDirectory());
				files=cliente.listFiles();
				System.out.println("Ficheros en el directorio actual: "+files.length);
				
				String text="\nHora de conexion: "+LocalDateTime.now();
				try (ByteArrayInputStream local = new ByteArrayInputStream(text.getBytes("UTF-8"))) {
				    cliente.appendFile("LOG.txt", local);
				} catch (IOException ex) {
				    throw new RuntimeException("Uh-oh", ex);
				}
				
				/*for (int i = 0; i < files.length; i++) {
					System.out.println("\t"+files[i].getName()+" => "+tipos[files[i].getType()]);
				}*/
				
				//nos deslogamos
				boolean logout=cliente.logout();
				
				if(logout)
					System.out.println("Logout del servidor FTP");
				else
					System.out.println("Error al hacer logout");
				cliente.disconnect();
				System.out.println("Desconectado");
				}else {
					System.out.println("Login incorrecto");
					cliente.disconnect();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}while(!usuario.equalsIgnoreCase("*"));
	}

}