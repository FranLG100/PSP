package ejemplostema4;

import java.io.IOException;
import java.io.Writer;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import org.apache.commons.net.smtp.*;

public class ClienteSMTP3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AuthenticatingSMTPClient client=new AuthenticatingSMTPClient();
		
		String server="smtp.gmail.com";
		String username="fralg100@gmail.com";
		String password="GDFGDGSDGBFCB";
		int puerto=587;
		String remitente="fralg100@gmail.com";
		
		try {
			int respuesta;
			KeyManagerFactory kmf=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(null,null);
			KeyManager km=kmf.getKeyManagers()[0];
			
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
				
				if(client.execTLS()) {
					System.out.println("3 - "+client.getReplyString());
					
					if(client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username, password)) {
						System.out.println("4 - "+client.getReplyString());
						String destino1="fralg100@gmail.com";
						String asunto="Prueba SMTP Client GMAIL";
						String mensaje="Hola, estoy escribiendo desde Eclipse y tal";
						
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
