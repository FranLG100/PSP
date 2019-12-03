package unidad3autoevaluacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad_01_1 {

	public static void main(String[] args) throws IOException {
		//Deberia funcionar
		//SERVIDOR
		
				//Abrimos el servidor, puerto 6000
				int numeroPuerto=6000;
				ServerSocket servidor=new ServerSocket(numeroPuerto);
				Socket clienteConectado=null;
				String recibo;
				int nCaracteres;
				
				InputStream entrada=null;
				DataInputStream flujoEntrada;
				
				OutputStream salida=null;
				DataOutputStream flujoSalida;
				
				do {
					//Esperamos al cliente
					System.out.println("Esperando al cliente...");
					clienteConectado=servidor.accept();
					
					
					//Nos preparamos para recibir información del cliente
					
					entrada=clienteConectado.getInputStream();
					flujoEntrada=new DataInputStream(entrada);
					
					//Como es un entero, no nos hace falta poner readUTF,
					//solo con read nos vale
					recibo=flujoEntrada.readUTF();
					System.out.println("Recibiendo del CLIENTE:  \n\t"+recibo);
					
					//Elevamos el numero al cuadrado
					nCaracteres=recibo.length();
					
					//Y se lo devolvemos al cliente
					
					salida= clienteConectado.getOutputStream();
					flujoSalida=new DataOutputStream(salida);
					
					flujoSalida.write(nCaracteres);
				}while(!recibo.trim().equals("*"));
				
				//Cerramos todos los flujos
				entrada.close();
				flujoEntrada.close();
				salida.close();
				flujoSalida.close();
				clienteConectado.close();
				servidor.close();
				
			}

}
