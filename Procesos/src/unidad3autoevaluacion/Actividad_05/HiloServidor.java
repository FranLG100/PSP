package unidad3autoevaluacion.Actividad_05;
import java.io.*;
import java.net.*;

public class HiloServidor extends Thread{

	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket = null;
	
	//Necesitamos un socket como parametro de entrada, para conectarnos a el
	public HiloServidor(Socket s) throws IOException {
		socket = s;
		
		//Preparamos la entrada y salida de datos
		fsalida= new PrintWriter(socket.getOutputStream(),true);
		fentrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void run() {
		String cadena="";
		//Imprimimos el socket
		System.out.println("COMUNICO CON: "+socket.toString());
		
		//Si recibimos asterisco, cerramos el socket al cliente
		while(!cadena.trim().equals("*")) {
			try {
				cadena=fentrada.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Si no, ponemos en mayusculas el texto recibido y lo mandamos de vuelta
			fsalida.println(cadena.trim().toUpperCase());
			System.out.println("Escribo "+cadena.trim().toUpperCase());
		}
		
		System.out.println("FIN CON: "+socket.toString());
		
		//Proceso de cerrar el socket y los bufers
		fsalida.close();
		try {
			fentrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
