package ejerciciostema3parte2.ejercicio3_10;
import java.io.*;
import java.net.*;

public class HiloServidorAdivina extends Thread {

	ObjectInputStream fentrada;
	ObjectOutputStream fsalida;
	Socket socket=null;
	ObjetoCompartido objeto;
	int identificador;
	int intentos=0;
	
	public HiloServidorAdivina(Socket s, ObjetoCompartido objeto, int id){
		this.socket=s;
		this.objeto=objeto;
		this.identificador=id;
		try {
			fsalida=new ObjectOutputStream(socket.getOutputStream());
			fentrada=new ObjectInputStream(socket.getInputStream());
		}catch (IOException e) {
			System.out.println("ERROR DE E/S en HiloServidor");
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("=>Cliente conectado: "+identificador);
		
		//Creamos el objeto Datos
		Datos datos=new Datos("Adivina un Numero entre 1 y 25", intentos, identificador);
		
		//Mientras no se adivine el numero, se sigue jugando
		if(objeto.seAcabo()) {
			datos.setCadena("LO SENTIMOS, EL JUEGO HA TERMINADO, HAN ADIVINADO EL NUMERO");
			datos.setJuega(false);
		}
		try {
			fsalida.reset();
			fsalida.writeObject(datos);
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error en el hilo al realizar el primero envio al jugador: "+identificador);
			return;
		}
		
		//Se ve mejor que en el comentario anterior. Mientras el juego NO haya acabado
		//ni se llegue a 5 intentos, el juego continua
		while(!objeto.seAcabo() || !(datos.getIntentos()==5)) {
			int numecli=0;
			try {
				Datos d=(Datos) fentrada.readObject();
				numecli=Integer.parseInt(d.getCadena());
			}catch (IOException e) {
				System.out.println("Error en el hilo al leer del jugador: "+identificador);
				break;
			}catch (NumberFormatException n) {
				System.out.println("El jugador "+identificador+" se ha desconectado");
				break;
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}
			
			//Se obtiene la nueva jugada del jugador (su id, y el numero que prueba a adivinar)
			String cad=objeto.nuevaJugada(identificador, numecli);
			intentos++;
			
			datos=new Datos(cad,intentos,identificador);
			
			if(objeto.seAcabo()) {
				datos.setJuega(false);
				if(identificador==objeto.getGanador())
					datos.setGana(true);
			}
			
			try {
				fsalida.reset();
				fsalida.writeObject(datos);
			} catch (IOException n1) {
				// TODO: handle exception
				System.out.println("Error escribiendo en el flujo de salida del jugador: "+identificador+" * "+n1.getMessage());
				break;
			} catch (NullPointerException n) {
				// TODO: handle exception
				System.out.println("El jugador "+identificador+" ha desconectado");
				break;
			}
		}
		
		if(objeto.seAcabo()) {
			System.out.println("EL JUEGO SE HA ACABADO...");
			System.out.println("\t==>Desconecta: "+identificador);
		}
		try {
			fsalida.close();
			fentrada.close();
			socket.close();
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error en el hilo al cerrar cliente: "+identificador);
			e.printStackTrace();
		}
	}
}
