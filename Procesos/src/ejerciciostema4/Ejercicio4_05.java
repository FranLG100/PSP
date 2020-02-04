package ejerciciostema4;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

public class Ejercicio4_05 {

	//Metodo para recuperar solo las cabeceras de los mensajes
	private static void RecuperarCabeceras(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: "+(i+1));
			POP3MessageInfo msginfo=men[i];
			
			System.out.println("Cabecera del mensaje: ");
			BufferedReader reader=(BufferedReader) pop3.retrieveMessageTop(msginfo.number,0);
			String linea;
			while((linea=reader.readLine())!=null)
				System.out.println(linea.toString());
			reader.close();
		}
	}
	
	//Metodo para recuperar el mensaje al completo, cabecera y texto
	private static void RecuperarMensaje(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: "+(i+1));
			POP3MessageInfo msginfo=men[i];
			
			System.out.println("Mensaje: ");
			BufferedReader reader=(BufferedReader) pop3.retrieveMessage(msginfo.number);
			String linea;
			while((linea=reader.readLine())!=null)
				System.out.println(linea.toString());
			reader.close();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Datos necesarios para acceder a nuestra cuenta de gmail
		String server="pop.gmail.com";
		String username="fralg100@gmail.com";
		String password="canoncien100";
		int puerto = 995;
		
		//Ese true es para comenzar la negociacion ssl tls justo despues de establecer
		//la conexion
		POP3SClient pop3=new POP3SClient(true);
		
		try {
			//nos conectamos
			pop3.connect(server,puerto);
			System.out.println("Conexion realizada  al servidor POP3 "+server);
			
			//comprobamos si nos logamos o no
			if(!pop3.login(username, password))
				System.err.println("Error al hacer login");
			else {
				POP3MessageInfo[] men=pop3.listMessages();
				
				//si hay mensajes
				if(men==null)
					System.out.println("Imposible recuperar mensajes");
				else
					System.out.println("N de mensajes: "+men.length);
				
				//Recuperamos el mensaje, cabeceras y cuerpo
				System.out.println(pop3.getReplyString());
				//RecuperarCabeceras(men, pop3);
				RecuperarMensaje(men, pop3);
				pop3.logout();
			}
			pop3.disconnect();
			//Salimos
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
	}

}
