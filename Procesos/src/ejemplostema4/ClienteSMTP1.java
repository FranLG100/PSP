package ejemplostema4;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;

public class ClienteSMTP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SMTPClient client= new SMTPClient();
		
		try {
			int respuesta;
			
			client.connect("localhost");
			
			System.out.println(client.getReplyString());
			respuesta=client.getReplyCode();
			
			if(!SMTPReply.isPositiveCompletion(respuesta)) {
				client.disconnect();
				System.out.println("Conexion RECHAZADA");
				System.exit(1);
			}
			
			client.login();
			String destinatario="fralg100@gmail.com";
			String mensaje="SALUDOS DESDE ECLIPSE";
			String remitente="postmaster@localhost";
			
			if(client.sendSimpleMessage(remitente, destinatario, mensaje))
				System.out.println("Mensaje enviado a "+destinatario);
			else
				System.out.println("No se ha podido enviar el mensaje");
			
			client.logout();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("NO SE PUEDE CONECTAR AL SERVIDOR");
			e.printStackTrace();
			System.exit(2);
		}
	}

}
