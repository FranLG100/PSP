package ejerciciostema3parte2.ejercicio3_10;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ejerciciostema3parte2.ejercicio3_10.vista.Vista;
public class JugadorAdivina {

	ObjectOutputStream fsalida;
	ObjectInputStream fentrada;
	int identificador;
	String cadena;
	int puerto;
	String host;
	Socket cliente;
	Datos datos;
	
	public JugadorAdivina() throws UnknownHostException, IOException {
		this.identificador=0;
		this.cadena="";
		this.host="localhost";
		this.puerto=6001;
		this.cliente=new Socket(host,puerto);
		this.fsalida= new ObjectOutputStream(cliente.getOutputStream());
		this.fentrada= new ObjectInputStream(cliente.getInputStream());
	}

	//Metodo para conectarse al Servidor (y recibir id)
	public void Conectar() throws UnknownHostException, IOException, ClassNotFoundException {
		Datos datos=(Datos) fentrada.readObject();
		identificador=datos.getIdentificador();
		System.out.println("Id jugador: "+identificador);
		setIdentificador(identificador);
		
		System.out.println(datos.getCadena());
		
		if(!datos.isJuega())
			cadena="*";
	}
	
	//Metodo para jugar un numero
	public void EnviarNumero(String cadena2) throws IOException, ClassNotFoundException {
		System.out.println(cadena2);
		Datos d=new Datos();
		
		//if(!validarCadena(cadena)) continue;
		
		d.setCadena(cadena2);
		
		fsalida.reset();
		fsalida.writeObject(d);
		
		datos=(Datos) fentrada.readObject();
		System.out.println("\t"+datos.getCadena());
		this.cadena=datos.getCadena();
	}
	
	//Metodo para controlar que lo que se inserta es un numero
	public boolean validarCadena(String cadena) {
		boolean valor=false;
		try {
			Integer.parseInt(cadena);
			valor=true;
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		return valor;
	}
	
	
	
	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		/*String host="localhost";
		int puerto=6001;
		Socket cliente=new Socket(host,puerto);
		
		ObjectOutputStream fsalida= new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream fentrada= new ObjectInputStream(cliente.getInputStream());
		
		Scanner sc=new Scanner(System.in);
		String cadena="";*/
		
		/*Datos datos=(Datos) fentrada.readObject();
		int identificador=datos.getIdentificador();
		System.out.println("Id jugador: "+identificador);
		
		System.out.println(datos.getCadena());
		
		if(!datos.isJuega())
			cadena="*";*/
		
		/*while(datos.isJuega() && !cadena.trim().equals("*")) {
			System.out.println("Intento: "+(datos.getIntentos()+1)+" =>Introduce numero: ");
			vista.campoIntentos.setText(Integer.toString(datos.getIntentos()+1));
			cadena=sc.nextLine();
			Datos d=new Datos();
			
			if(!validarCadena(cadena)) continue;
			
			d.setCadena(cadena);
			
			fsalida.reset();
			fsalida.writeObject(d);
			
			datos=(Datos) fentrada.readObject();
			System.out.println("\t"+datos.getCadena());
			
			if(datos.getIntentos()>=5) {
				System.out.println("\t<<JUEGO FINALIZADO, NO HAY MAS INTENTOS>>");
				cadena="*";
			}
			if(datos.isGana()) {
				System.out.println("<<HAS GANADO!! EL JUEGO HA TERMINADO>>");
				cadena="*";
			}else
				if(!(datos.isJuega())) {
					System.out.println("<<EL JUEGO HA TERMINADO, HAN ADIVINADO EL NUMERO>>");
					cadena="*";
				}
		}
		
		fsalida.close();
		fentrada.close();
		System.out.println("Fin de proceso...");
		sc.close();
		cliente.close();
	}
	
	private static boolean validarCadena(String cadena) {
		boolean valor=false;
		try {
			Integer.parseInt(cadena);
			valor=true;
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		return valor;
	}*/

		
	}
}
