package ejemplostema4;

import java.io.Writer;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class ClienteSMTP2 {

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
			String destino1="fralg100@gmail.com";
			String destino2="fralg100@gmail.com";
			String mensaje="SALUDOS DESDE ECLIPSE";
			String asunto="DESDE ECLIPSE";
			String remitente="postmaster@localhost";
			
			SimpleSMTPHeader cabecera=new SimpleSMTPHeader(remitente, destino1, asunto);
			cabecera.addCC(destino2);
			
			client.setSender(remitente);
			
			client.addRecipient(destino1);
			client.addRecipient(destino2);
			
			Writer writer=client.sendMessageData();
			if(writer==null) {
				System.out.println("FALLO AL ENVIAR DATA");
				System.exit(1);
			}
			
			System.out.println(cabecera.toString());
			
			writer.write(cabecera.toString());
			writer.write(mensaje);
			writer.close();
			
			if(!client.completePendingCommand()) {
				System.out.println("FALLO AL FINALIZAR LA TRANSACCION");
				System.exit(1);
			}
			
			client.logout();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("NO SE PUEDE CONECTAR AL SERVIDOR");
			e.printStackTrace();
			System.exit(2);
		}
	}

}
