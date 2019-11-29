package ejemplostema3parte2;
import java.io.*;
import java.net.*;

public class HiloServidor extends Thread{

	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket = null;
	
	public HiloServidor(Socket s) throws IOException {
		socket = s;
		
		fsalida= new PrintWriter(socket.getOutputStream(),true);
		fentrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void run() {
		String cadena="";
		System.out.println("COMUNICO CON: "+socket.toString());
		
		while(!cadena.trim().equals("*")) {
			try {
				cadena=fentrada.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fsalida.println(cadena.trim().toUpperCase());
		}
		
		System.out.println("FIN CON: "+socket.toString());
		
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
