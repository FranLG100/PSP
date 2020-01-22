package ejerciciostema4;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Ejercicio4_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Seguramente, no funcione fuera de mi local porque tiene datos muy especificos
		//pero seguimos hacia adelante
		FTPClient cliente=new FTPClient();
		//nos conectaremos a localhost
		String servFTP="localhost";
		//String servFTP="ftp.rediris.es";
		System.out.println("Nos conectamos a: "+servFTP);
		//usuario y clave del usuario con permisos asignados a una carpeta de nuestro servidos
		String usuario="usuario1";
		String clave="usu1";
		
		String directorio="/Procesos/";
		
		try {
			//nos conectamos
			cliente.connect(servFTP);
			//Se le indica al cliente a que puerto debe conectarse, en caso de ser activo
			//seria aleatorio, pero mayor de 1024
			cliente.enterLocalPassiveMode();
			
			//Comprobamos si el login es correcto
			//si no lo es, desconectamos
			boolean login=cliente.login(usuario, clave);
			
			if(login)
				System.out.println("Login correcto");
			else {
				System.out.println("Login incorrecto");
				cliente.disconnect();
				System.exit(1);
			}
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
			
			for (int i = 0; i < files.length; i++) {
				System.out.println("\t"+files[i].getName()+" => "+tipos[files[i].getType()]);
			}
			
			//nos deslogamos
			boolean logout=cliente.logout();
			
			if(logout)
				System.out.println("Logout del servidor FTP");
			else
				System.out.println("Error al hacer logout");
			cliente.disconnect();
			System.out.println("Desconectado");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
