package ejemplostema4;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class ClienteFTP1 {

	public static void main(String[] args) throws SocketException, IOException {
		// TODO Auto-generated method stub

		FTPClient cliente=new FTPClient();
		String servFTP="ftp.rediris.es";
		System.out.println("Nos conectamos a: "+servFTP);
		cliente.connect(servFTP);

		System.out.println(cliente.getReplyString());
		
		int respuesta=cliente.getReplyCode();
		System.out.println("Respuesta: "+respuesta);
		
		if(!FTPReply.isPositiveCompletion(respuesta)) {
			cliente.disconnect();
			System.out.println("Conexion rechazada: "+respuesta);
			System.exit(0);
		}
		
		cliente.disconnect();
		System.out.println("Conexion finalizada");
		
		

	}
}
