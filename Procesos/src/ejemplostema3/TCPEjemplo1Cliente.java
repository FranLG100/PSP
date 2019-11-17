package ejemplostema3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEjemplo1Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		String host="localhost";
		int Puerto=6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente=new Socket(host,Puerto);
		
		DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
		flujoSalida.writeUTF("Saludos al servidor desde el cliente");
		
		
		DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
		System.out.println("Recibiendo del SERVIDOR:  \n\t"+flujoEntrada.readUTF());
		
	
		
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();
	}

}
