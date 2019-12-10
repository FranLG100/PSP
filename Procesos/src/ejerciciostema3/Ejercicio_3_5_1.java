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

		//SERVIDOR
		
		//En este caso, el servidor ira atendiendo clientes y diciendoles que numero
		//de clientes son. Cuanto lleguen al maximo, cerrara.
		
		//En este caso, atendera hasta tres conexiones.
		int numeroPuerto=6000;
		int nClientes=0;
		int maxConexiones=3;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		
		//Cuando se conecta un cliente...
		do {
			Socket clienteConectado=null;
			System.out.println("Esperando al cliente...");
			clienteConectado=servidor.accept();
			//Lo aceptamos y aumentamos el contador
			nClientes++;
			
			//Le mandamos un mensaje
			OutputStream salida=null;
			salida= clienteConectado.getOutputStream();
			DataOutputStream flujoSalida=new DataOutputStream(salida);
			
			//Diciendole en que orden ha entrado
			flujoSalida.writeUTF("Eres el clientes numero "+nClientes);
			
			//Y cerramos los flujos
			salida.close();
			flujoSalida.close();
			clienteConectado.close();
		}while(nClientes!=maxConexiones); //Cuando hemos llegado al limite, continuamos

		//Informamos de a cuanto hemos atendido
		System.out.println("Se han atendido a "+nClientes);
		
		//Y cerramos
		servidor.close();
		
	}

}
