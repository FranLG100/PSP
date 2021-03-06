package unidad3autoevaluacion.Actividad_06;
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
	int premios;
	
	public JugadorAdivina() throws UnknownHostException, IOException {
		this.identificador=0;
		this.premios=0;
		this.cadena="";
		this.host="localhost";
		this.puerto=6001;
		this.cliente=new Socket(host,puerto);
		this.fsalida= new ObjectOutputStream(cliente.getOutputStream());
		this.fentrada= new ObjectInputStream(cliente.getInputStream());
	}

	public void Conectar() throws UnknownHostException, IOException, ClassNotFoundException {
		Datos datos=(Datos) fentrada.readObject();
		identificador=datos.getIdentificador();
		premios=datos.getPremios();
		System.out.println("Id jugador: "+identificador);
		setIdentificador(identificador);
		
		System.out.println(datos.getCadena());
		
		if(!datos.isJuega())
			cadena="*";
	}
	
	public void EnviarNumero(String x, String y) throws IOException, ClassNotFoundException {
		System.out.println(x);
		Datos d=new Datos();
		
		//if(!validarCadena(cadena)) continue;
		
		d.setCadenaX(x);
		d.setCadenaY(y);
		
		fsalida.reset();
		fsalida.writeObject(d);
		
		datos=(Datos) fentrada.readObject();
		System.out.println("\t"+datos.getCadena());
		this.cadena=datos.getCadena();
	}
	
	public boolean validarCadena(String cadenax, String cadenay) {
		boolean valor=false;
		try {
			Integer.parseInt(cadenax);
			Integer.parseInt(cadenay);
			valor=true;
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		return valor;
	}
	
	public void Cerrar() throws IOException {
		fsalida.close();
		fentrada.close();
		System.out.println(identificador+" :Fin de proceso...");
		cliente.close();
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
	
	

	public int getPremios() {
		return premios;
	}

	public void setPremios(int premios) {
		this.premios = premios;
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
