package ejerciciostema3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio_3_5_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int numeroPuerto=6000;
		int nClientes=0;
		int maxConexiones=3;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		
		do {
			Socket clienteConectado=null;
			System.out.println("Esperando al cliente...");
			clienteConectado=servidor.accept();
			nClientes++;
			
	
			OutputStream salida=null;
			salida= clienteConectado.getOutputStream();
			DataOutputStream flujoSalida=new DataOutputStream(salida);
			
			flujoSalida.writeUTF("Eres el clientes nº "+nClientes);
			
			salida.close();
			flujoSalida.close();
			clienteConectado.close();
		}while(nClientes!=maxConexiones);

		System.out.println("Se han atendido a "+nClientes);
		servidor.close();
		
	}

}
