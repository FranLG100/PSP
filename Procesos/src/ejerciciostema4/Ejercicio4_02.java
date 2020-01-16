package ejerciciostema4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Ejercicio4_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		FTPClient cliente=new FTPClient();
		String servidor="localhost";
		String user="usuario";
		String pass="usuario";
		
		//Proceso de conectarnos al servidor
		try {
			System.out.println("Conectandose a "+servidor);
			cliente.connect(servidor);
			cliente.enterLocalPassiveMode();
			boolean login=cliente.login(user, pass);
			
			//Preparando la subida de archivos, a la carpeta subidas
			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			String direc="/subidas";
			
			if(login) {
				System.out.println("Login correcto");
				
				//Si no existe la carpeta subida
				if(!cliente.changeWorkingDirectory(direc)) {
					String directorio="subidas";
					//la creamos
					if(cliente.makeDirectory(directorio)) {
						System.out.println("Directorio creado");
						//y nos cambiamos a ella
						cliente.changeWorkingDirectory(directorio);
					}else {
						System.out.println("No se ha podido crear el directorio");
						System.exit(0);
					}
				}
				
				//Imprimimos el directorio actual
				System.out.println("Directorio actual: "+cliente.printWorkingDirectory());
				//Con filechooser, escogemos el fichero a subir
				JFileChooser jfc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				String ruta="";
				String archivo="";
				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				//cuando le demos a aceptar
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					//cogemos su ruta y su nombre
					ruta=selectedFile.getAbsolutePath();
					archivo=selectedFile.getName();
				}
				
				BufferedInputStream in=new BufferedInputStream(new FileInputStream(ruta));
				//y lo subimos al servidor
				cliente.storeFile(archivo,in);
				in.close();
				cliente.logout();
				cliente.disconnect();
				
			}else
				System.out.println("Login incorrecto");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
