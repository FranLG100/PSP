package unidad3autoevaluacion.Actividad_07;
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
		
		String aux[]=new String[2];
		aux[0]="Adivina la combinacion ganadora";
		aux[1]="";
		Datos datos=new Datos(aux, intentos, identificador);
		
		if(objeto.seAcabo()) {
			aux[0]="LO SENTIMOS, EL JUEGO HA TERMINADO, HAN ADIVINADO EL NUMERO";
			datos.setCadena(aux);
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
		
		while(!objeto.seAcabo() || !(datos.getIntentos()==5)) {
			int numecli1=0;
			int numecli2=0;
			int numecli3=0;
			int numecli4=0;
			try {
				Datos d=(Datos) fentrada.readObject();
				numecli1=Integer.parseInt(d.getCadena1());
				numecli2=Integer.parseInt(d.getCadena2());
				numecli3=Integer.parseInt(d.getCadena3());
				numecli4=Integer.parseInt(d.getCadena4());
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
			
			String[] cad=objeto.nuevaJugada(identificador, numecli1,numecli2,numecli3,numecli4);
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
