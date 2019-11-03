package unidad2autoevaluacion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import utilesFran.Amadeus;

public class Ejercicio_10 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		File archivo=new File("ColaTexto.txt");
		ColaPalabras c=new ColaPalabras();

		Consumidor c1=new Consumidor("A", c);
		Consumidor c2=new Consumidor("B", c);
		ArrayList<Consumidor> consumidores=new ArrayList<Consumidor>();
		consumidores.add(c1);
		consumidores.add(c2);
		Productor p=new Productor(archivo, c,consumidores);
		
		
		p.start();
		c1.start();
		c2.start();
		
	}

}
