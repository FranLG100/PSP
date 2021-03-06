package ejerciciostema4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import utilesFran.Amadeus;

public class Ej2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Seguramente, no funcione fuera de mi local porque tiene datos muy especificos
		//pero seguimos hacia adelante
		Amadeus amadeus=new Amadeus();//Esta es mi libreria personal de utilidades
		String usuario; //Usuario del servidor FTP, usuario1, usuario2 o usuario3
		int usuariosCorrectos=0; //numero de veces que se logean correctamente
		do {
			//Se les pide los datos a los usuarios
			System.out.println("Introduzca usuario");
			usuario=amadeus.recibeTexto();
			
			System.out.println("Introduzca pass");
			String clave=amadeus.recibeTexto();
			
			FTPClient cliente=new FTPClient();
			//nos conectaremos a localhost
			String servFTP="localhost";
			//String servFTP="ftp.rediris.es";
			System.out.println("Nos conectamos a: "+servFTP);
			
			
			//Guardamos esto, nos sera de utilidad
			String directorio="/LOG/";
			
			try {
				//nos conectamos
				cliente.connect(servFTP);
				
				cliente.enterLocalPassiveMode();
				
				//Comprobamos si el login es correcto
				//si no lo es, seguimos, pero no contamos un login exitoso
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
					
					//Ahora, aprovechamos para escribir en el LOG.txt personal de cada usuario, a que hora entro
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
					//Sumamos uno al numero de logins correctos
					usuariosCorrectos++;
				}else {
					System.out.println("Login incorrecto");
					cliente.disconnect();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}while(!usuario.equalsIgnoreCase("*"));
		
		
		//Comenzamos el proceso de enviarnos un correo para ver el numero
		//de logins correctos que se han sucedido en la sesion.
		
		AuthenticatingSMTPClient client=new AuthenticatingSMTPClient();
		
		String server="smtp.gmail.com";
		String username="fralg100@gmail.com";
		String password="canoncien100";
		int puerto=587;
		String remitente="fralg100@gmail.com";
		
		try {
			int respuesta;
			KeyManagerFactory kmf=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(null,null);
			KeyManager km=kmf.getKeyManagers()[0];
			
			//Nos conectamos al servidor de correo y al puerto correspondiente.
			client.connect(server,puerto);
			System.out.println("1 - "+client.getReplyString());
			client.setKeyManager(km);
			
			respuesta=client.getReplyCode();
			if(!SMTPReply.isPositiveCompletion(respuesta)) {
				client.disconnect();
				System.err.println("Conexion rechazada");
				System.exit(1);
			}
				
				client.ehlo(server);
				System.out.println("2 - "+client.getReplyString());
				
				//Comienza la negociacion SSL TLS
				if(client.execTLS()) {
					System.out.println("3 - "+client.getReplyString());
					
					if(client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username, password)) {
						//Nos lo enviamos a nosotros mismos
						System.out.println("4 - "+client.getReplyString());
						String destino1="fralg100@gmail.com";
						String asunto="Numero de conexiones correctas";
						String mensaje="Se han conectado correctamente "+usuariosCorrectos+" usuarios";
						
						SimpleSMTPHeader cabecera=new SimpleSMTPHeader(remitente,destino1,asunto);
						
						client.setSender(remitente);
						client.addRecipient(destino1);
						System.out.println("5 - "+client.getReplyString());
						
						Writer writer=client.sendMessageData();
						
						if(writer==null) {
							System.out.println("FALLO AL ENVIAR DATA");
							System.exit(1);
						}
						
						writer.write(cabecera.toString());
						writer.write(mensaje);
						writer.close();
						System.out.println("6 - "+client.getReplyString());
						
						boolean exito=client.completePendingCommand();
						System.out.println("7 - "+client.getReplyString());
						
						if(!exito) {
							System.out.println("FALLO AL FINALIZAR TRANSACCION");
							System.exit(1);
						}else
							System.out.println("Mensaje enviado con EXITO");
					}else
							System.out.println("USUARIO NO AUTENTICADO");
				}else
					System.out.println("FALLO AL EJECUTAR STARTLLS");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Could not connect to server");
			e.printStackTrace();
			System.exit(1);
		}
		try {
			client.disconnect();
		} catch (IOException f) {
			// TODO: handle exception
			f.printStackTrace();
		}
		
		System.out.println("Fin de envio");
		System.exit(0);
	}

}