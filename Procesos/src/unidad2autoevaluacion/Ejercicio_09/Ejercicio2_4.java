package unidad2autoevaluacion.Ejercicio_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2_4 {

	MyHiloEj4 h;
	String comprobador="";
	int valor=0;
	
	public Ejercicio2_4(MyHiloEj4 h) {
		this.h=h;
		this.comprobador="";
		this.valor=0;
	}
	
	public void Iniciar() {
		this.h.start();
	}
	
	
	public MyHiloEj4 getH() {
		return h;
	}



	public void setH(MyHiloEj4 h) {
		this.h = h;
	}



	public String getComprobador() {
		return comprobador;
	}



	public void setComprobador(String comprobador) {
		this.comprobador = comprobador;
	}



	public int getValor() {
		valor=h.getContador();
		return valor;
	}



	public void setValor(int valor) {
		this.valor = valor;
	}

	public void suspender() throws InterruptedException {
		h.Suspende();
	}
	
	public void reiniciar() {
		h.Reanuda();
	}
	
	public void finalizar() {
		h.Finaliza();
	}


	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Este hilo es de un ejemplo (el paquete ejemplos).
		//Lo que hace es contar hasta el infinito (el infinito que le deje java)
		//Mientras tanto, podemos escribir
		//MyHiloEj4 h=new MyHiloEj4();
		//BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
		String comprobador="";
		h.start();
		do {
			comprobador=lector.readLine();
			//Si escribimos 's', el hilo entra en espera (wait()), hasta que
			if(comprobador.equalsIgnoreCase("s"))
					h.Suspende();
			if(comprobador.equalsIgnoreCase("r"))
				//escribamos 'r', para reanudarlo. (notifyAll())
				h.Reanuda();
		} while (!comprobador.equalsIgnoreCase("*"));
		//Cuando pongamos '*', el hilo finaliza
		h.Finaliza();
	}*/

}
