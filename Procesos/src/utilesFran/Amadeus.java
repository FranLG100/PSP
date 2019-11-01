package utilesFran;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Clase de utilidades (control de variables, aplicaci�n de try catch, ...)
 * de uso personal
 * @author Francisco Antonio Lorente Girol
 * @version 31/03/2019
 * */

public class Amadeus {

	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	boolean error = false;
	Random random=new Random();

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero entero controlado
	 * */
	public int controlaInt() throws IOException {
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido");
				error = true;
			}
		} while (error);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero entero controlado positivo (incluyendo el 0)
	 * */
	public int controlaIntPositivo() throws IOException {
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor positivo");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido");
				error = true;
			}
		} while (error || entero < 0);
		return entero;
	}
	
	
	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso, entre un M�nimo
	 * y un M�ximo
	 * @param min Rango m�nimo del entero a introducir
	 * @param max Rango m�ximo del entero a introducir
	 * @return N�mero entero controlado
	 * */
	public int controlaIntMinMax(int min, int max) throws IOException {
		int aux=0;
		if(min>max) {
			aux=max;
			max=min;
			min=aux;
		}
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
				if (entero<min || entero>max)
					System.out.println("Introduzca un valor entre "+min+" y "+max);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido");
				error = true;
			}
		} while (error || entero<min || entero>max);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero entero controlado entre 0 y 100
	 * */
	public int controlaIntPorcentaje() throws IOException {
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor mayor a 0");
				if (entero > 100)
					System.out.println("Introduzca un valor menor a 100");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido");
				error = true;
			}
		} while (error || entero < 0 || entero > 100);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Double
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero del tipo double controlado
	 * */
	public double controlaDouble() throws IOException {
		double entero = 0;
		do {
			try {
				entero = Double.parseDouble(entrada.readLine());
				error = false;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido, vuelva a introducirlo");
				error = true;
			}
		} while (error);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Double
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero del tipo double positivo (incluyendo 0)
	 * */
	public double controlaDoublePositivo() throws IOException {
		double entero = 0;
		do {
			try {
				entero = Double.parseDouble(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor positivo");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido, vuelva a introducirlo");
				error = true;
			}
		} while (error || entero < 0);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Double
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero del tipo double controlado entre 0 y 100
	 * */
	public double controlaDoublePorcentaje() throws IOException {
		double entero = 0;
		do {
			try {
				entero = Double.parseDouble(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor mayor a 0");
				if (entero > 100)
					System.out.println("Introduzca un valor menor a 100");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido");
				error = true;
			}
		} while (error || entero < 0 || entero > 100);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Float
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero del tipo float controlado
	 * */
	public float controlaFloat() throws IOException {
		float entero = 0;
		do {
			try {
				entero = Float.parseFloat(entrada.readLine());
				error = false;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido, vuelva a introducirlo");
				error = true;
			}
		} while (error);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de un dato tipo Float
	 * y aplica los try catch necesarios durante el proceso.
	 * @return N�mero del tipo float positivo (incluye el 0)
	 * */
	public float controlaFloatPositivo() throws IOException {
		float entero = 0;
		do {
			try {
				entero = Float.parseFloat(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor positivo");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no v�lido, vuelva a introducirlo");
				error = true;
			}
		} while (error || entero < 0);
		return entero;
	}

	/**
	 * M�todo que aplica solicita la introducci�n de una cadena de caracteres por teclado.
	 * El m�todo comprueba si se ha escrito 's', 's�', 'si', 'yes','y', 'no','n'
	 * @return <ul>
	 * <li>true Si se ha escrito 's', 's�', 'si', 'yes','y'
	 * <li>false Si se ha escrito 'n', 'no'
	 * </ul>
	 * */
	public boolean afirmaODesmiente() throws IOException {
		String respuesta;
		do {
			respuesta = entrada.readLine();
			error = false;
			if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("y") || respuesta.equalsIgnoreCase("s�")
					|| respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("yes"))
				return true;
			else if (respuesta.equalsIgnoreCase("no") || respuesta.equalsIgnoreCase("n"))
				return false;
			else {
				error = true;
				System.out.println("Valor no v�lido, introduzca si o no");
			}
		} while (error);
		return false;
	}

	/**
	 * Solicita por consola la entrada por teclado de una cadena de caracteres.
	 * Comprueba que dicha cadena no est� vac�a o que no sean todos espacios en blanco.
	 * @return Cadena de caracteres v�lida
	 * */
	public String recibeTexto() throws IOException {
		String respuesta;
		boolean vacio = true;
		char c;
		do {
			respuesta = entrada.readLine();
			for (int i = 0; i < respuesta.length(); i++) {
				c = respuesta.charAt(i);
				if (!Character.isWhitespace(c)) {
					vacio = false;
					break;
				}
			}
			if (vacio)
				System.out.println("El texto no debe estar vac�o, introduzca datos");
		} while (vacio);
		return respuesta;
	}
	
	/**
	 * Comprueba que una cadena no est� vac�a o que no sean todos espacios en blanco.
	 * @param s Cadena de caracteres a comprobar
	 * @return Cadena de caracteres v�lida
	 * */
	public String compruebaTexto(String s) throws IOException {
		String respuesta=s;
		boolean vacio = true;
		char c;
		do {
			for (int i = 0; i < respuesta.length(); i++) {
				c = respuesta.charAt(i);
				if (!Character.isWhitespace(c)) {
					vacio = false;
					break;
				}
			}
			if (vacio) {
				System.out.println("El texto no debe estar vac�o, introduzca datos");
				respuesta = entrada.readLine();
			}
		} while (vacio);
		return respuesta;
	}
	
	/**
	 * M�todo que comprueba que el DNI tenga el formato adecuado de 8 d�gitos y una letra al final
	 * @param s DNI a comprobar
	 * @return DNI validado
	 * */
	public String compruebaNIF(String s) throws IOException {
		String respuesta=s;
		boolean error = false;
		char c;
		
		do {
			error=false;
			while(respuesta.length()!=9) {
				System.out.println("Longitud del DNI incorrecta, vuelva a introducirlo");
				respuesta=recibeTexto();
			}
			for (int i = 0; i < 8; i++) {
				c = respuesta.charAt(i);
				if (!Character.isDigit(c)) {
					error = true;
					break;
				}
			}
			if(!Character.isAlphabetic(respuesta.charAt(8)))
				error=true;
			if (error) {
				System.out.println("DNI no v�lido. Vu�lvalo a introducir");
				respuesta = entrada.readLine();
			}
		} while (error);
		return respuesta.toUpperCase();
	}
	
	/**
	 * M�todo que comprueba que el tel�fono tenga el formato adecuado de 9 d�gitos
	 * @param s Tel�fono a comprobar
	 * @return Tel�fono validado
	 * */
	public String compruebaTlf(String s) throws IOException {
		String respuesta=s;
		respuesta=respuesta.trim().replaceAll("\\s", "");
		boolean error = false;
		char c;
		
		do {
			error=false;
			while(respuesta.length()!=9) {
				System.out.println("Longitud del tel�fono incorrecta, vuelva a introducirlo");
				respuesta=recibeTexto();
				respuesta=respuesta.trim().replaceAll("\\s", "");
			}
			for (int i = 0; i < 9; i++) {
				c = respuesta.charAt(i);
				if (!Character.isDigit(c)) {
					error = true;
					break;
				}
			}
			if (error) {
				System.out.println("Tel�fono no v�lido. Vu�lvalo a introducir");
				respuesta = entrada.readLine();
				respuesta=respuesta.trim().replaceAll("\\s", "");
			}
		} while (error);
		return respuesta;
	}
	
	/**
	 * Convierte una cadena de caracteres en un String
	 * @param array Array de caracteres con el cual queremos formar una palabra
	 * @return Frase o palabra ya formada
	 * */
	public String deCadenaATexto(char[] array) {
		String string=String.copyValueOf(array);
		return string;
	}
	
	/**
	 * Divide un texto mediante unas reglas determinadas
	 * @param texto Texto a dividir
	 * @param reglas Por qu� elementos debe ser separado
	 * @return Array de palabras ya separadas
	 * */
	public String[] divideTexto(String texto, String reglas) {
		String[] palabras=texto.split(reglas);
		return palabras;
	}
	
	/**
	 * Divide un texto mediante unas reglas determinadas y lo guarda 
	 * en un StringTokenizer
	 * @param texto Texto a dividir
	 * @param reglas Por qu� elementos debe ser separado
	 * @return StringTokenizer cargado.
	 * */
	public StringTokenizer cargaTokenizer(String texto, String reglas) {
		StringTokenizer tokens=new StringTokenizer(texto,reglas);
		return tokens;
	}
	
	/*/////////////////////////////////////////////////////////////////////*/
	/*/ARRAYS//////////////////////////////////////////////////////////////*/
	/*/////////////////////////////////////////////////////////////////////*/
	
	/**
	 * M�todo que llena un array ya existente con valores aleatorios
	 * @param array Array que deseamos rellenar
	 * @param maxVal Valor m�ximo de los n�meros aleatorios generados que llenar�n el array
	 * @return El m�todo devolver� el array que metimos como par�metro de entrada ya relleno
	 * */
	public int[] rellenaArray(int[] array, int maxVal) {
		int val;
		for (int i = 0; i < array.length; i++) {
			val=random.nextInt(maxVal)+1;
			array[i]=val;
		}
		return array;
		
	}
	
	/**
	 * M�todo que crea un array ya lleno con valores aleatorios
	 * @param tamanho Tama�o del Array que deseamos crear
	 * @param maxVal Valor m�ximo de los n�meros aleatorios generados que llenar�n el array
	 * @return El m�todo devolver� un array de tama�o 'tamanho' ya lleno
	 * */
	public int[] creaArrayLleno(int tamanho,int maxVal) {
		int[] array=new int[tamanho];
		return rellenaArray(array,maxVal);
		
	}
	
	/**
	 * M�todo que imprime los valores de un array
	 * @param array Array que deseamos imprimir
	 * */
	public void imprimeArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	/**
	 * M�todo que suma los valores de dos arrays
	 * @param a Primer array que deseamos sumar
	 * @param b Segundo array que deseamos sumar
	 * @return El m�todo devolver� un array con la suma de los arrays anteriores
	 * */
	public int[] sumaArray(int[]a, int[]b) {
		int capacidad=a.length;
		int[] suma=new int[capacidad];
		for (int i = 0; i < suma.length; i++) {
			suma[i]=a[i]+b[i];
		}
		return suma;
	}
	
	/**
	 * M�todo que ordena de menor a mayor un Array
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenaArrayMenorMayor(int[] array) {
		Arrays.sort(array);
		return array;
	}
	
	/**
	 * M�todo que ordena de mayor a menor un Array
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenaArrayMayorMenor(int[] array) {
		Arrays.sort(array);
		array=invierteArray(array);
		return array;
	}
	
	/**
	 * M�todo que invierte el orden de un array
	 * @param array Array que deseamos invertir
	 * @return Array ya invertido
	 * */
	public int[] invierteArray(int[] array) {
		int[] inversion=new int[array.length];
		for (int i = 0; i < array.length; i++) {
			inversion[i]=array[array.length-1-i];
		}
		return inversion;
	}
	
	/**
	 * M�todo que ordena de menor a mayor un array mediante el m�todo de la Burbuja.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionAscendenteBurbujaArray(int[] array) {
		int aux;
		int mayor = array[0];
		boolean comprueba = true;
		while (comprueba) {
			comprueba = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					aux = array[j + 1];
					array[j + 1] = array[j];
					array[j] = aux;
					comprueba = true;
				}
			}
		}
		return array;
	}
	
	/**
	 * M�todo que ordena de mayor a menor un array mediante el m�todo de la Burbuja.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionDescendenteBurbujaArray(int[] array) {
		int aux;
		int mayor = array[0];
		boolean comprueba = true;
		while (comprueba) {
			comprueba = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] < array[j + 1]) {
					aux = array[j + 1];
					array[j + 1] = array[j];
					array[j] = aux;
					comprueba = true;
				}
			}
		}
		return array;
	}
	
	/**
	 * M�todo que ordena de menor a mayor un array mediante el m�todo de Inserci�n Directa.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionInsercionDirectaAscendenteArray(int[] array) {
		int index=0;
		int aux=0;
		for (int i = 1; i < array.length; i++) {
			index=i;
			aux=array[i];
			while((index>0)&&(array[index-1]>aux)) {
				array[index]=array[index-1];
				index--;
			}
			array[index]=aux;
		}
		return array;
	}
	
	
	/**
	 * M�todo que ordena de mayor a menor un array mediante el m�todo de Inserci�n Directa.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionInsercionDirectaDescendenteArray(int[] array) {
		int index=0;
		int aux=0;
		for (int i = 1; i < array.length; i++) {
			index=i;
			aux=array[i];
			while((index>0)&&(array[index-1]<aux)) {
				array[index]=array[index-1];
				index--;
			}
			array[index]=aux;
		}
		return array;
	}
	
	
	/**
	 * M�todo que ordena de mayor a menor un array mediante el m�todo de Selecci�n Directa.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionSeleccionDirectaAscendenteArray(int[] array) {

		// El tama�o del array
		int n = array.length;
		// las n-1 pasadas. En la primera pasada i=0, y en la �ltima i=n-2
		for (int i = 0; i < n - 1; i++) {
			// Buscamos el m�nimo supondremos que es el primero
			int posMin = i;
			// nos movemos por el resto
			for (int j = i + 1; j < n; j++) {
				// si este es menor aun
				if (array[j] < array[posMin]) {
					// tomamos nota de su posici�n
					posMin = j;
				}
			}
			// intercambiar la posici�n i y el m�nimo encontrado
			int iaux = array[i];
			array[i] = array[posMin];
			array[posMin] = iaux;
		}
		
		return array;
	}
	
	
	/**
	 * M�todo que ordena de menor a mayor un array mediante el m�todo de Selecci�n Directa.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionSeleccionDirectaDescendenteArray(int[] array) {

		// El tama�o del array
		int n = array.length;
		// las n-1 pasadas. En la primera pasada i=0, y en la �ltima i=n-2
		for (int i = 0; i < n - 1; i++) {
			// Buscamos el m�nimo supondremos que es el primero
			int posMin = i;
			// nos movemos por el resto
			for (int j = i + 1; j < n; j++) {
				// si este es menor aun
				if (array[j] > array[posMin]) {
					// tomamos nota de su posici�n
					posMin = j;
				}
			}
			// intercambiar la posici�n i y el m�nimo encontrado
			int iaux = array[i];
			array[i] = array[posMin];
			array[posMin] = iaux;
		}
		
		return array;
	}
	
	/**
	 * M�todo p�blico que cuenta el n�mero de n�meros pares de un array introducido
	 * @param array Array del cual queremos contar la cantidad de n�meros pares
	 * @return Cantidad de n�meros pares que hay en ese array
	 * */
	public int cuentaPares(int[] array) {
		int cont=0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]%2==0)
				cont++;
		}
		return cont;
	}
	
	
	/**
	 * M�todo p�blico que cuenta el n�mero de n�meros impares de un array introducido
	 * @param array Array del cual queremos contar la cantidad de n�meros impares
	 * @return Cantidad de n�meros impares que hay en ese array
	 * */
	public int cuentaImpares(int[] array) {
		int cont=0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]%2!=0)
				cont++;
		}
		return cont;
	}
	
	
	/**
	 * M�todo p�blico que extrae los n�meros pares de un array y los guarda en otro
	 * @param array Array del cual queremos extraer los n�meros pares
	 * @return Un array de n�meros pares
	 * */
	public int[] extraeParesArray(int[] array) {
		int[] pares=new int[cuentaPares(array)];
		int cont=0;
		for (int i = 0; cont < pares.length; i++) {
			if(array[i]%2==0) {
				pares[cont]=array[i];
				cont++;
			}
		}
		return pares;
	}
	
	
	/**
	 * M�todo p�blico que extrae los n�meros impares de un array y los guarda en otro
	 * @param array Array del cual queremos extraer los n�meros impares
	 * @return Un array de n�meros impares
	 * */
	public int[] extraeImparesArray(int[] array) {
		int[] impares=new int[cuentaImpares(array)];
		int cont=0;
		for (int i = 0; cont < impares.length; i++) {
			if(array[i]%2!=0) {
				impares[cont]=array[i];
				cont++;
			}
		}
		return impares;
	}
	
	
	/*/////////////////////////////////////////////////////////////////////*/
	/*/MATRICES////////////////////////////////////////////////////////////*/
	/*/////////////////////////////////////////////////////////////////////*/
	
	
	/**
	 * M�todo que llena una matriz ya existente con valores aleatorios
	 * @param matriz Matriz que deseamos rellenar
	 * @param maxVal Valor m�ximo de los n�meros aleatorios generados que llenar�n la matriz
	 * @return El m�todo devolver� la matriz que metimos como par�metro de entrada ya relleno
	 * */
	public int[][] rellenaMatriz(int[][] matriz, int maxVal) {
		int val;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				val=random.nextInt(maxVal)+1;
				matriz[i][j]=val;
			}
		}
		return matriz;	
	}
	
	
	/**
	 * M�todo que crea una matriz ya llena con valores aleatorios
	 * @param tamanho Tama�o de la matriz que deseamos crear
	 * @param maxVal Valor m�ximo de los n�meros aleatorios generados que llenar�n la matriz
	 * @return El m�todo devolver� una matriz de tama�o 'tamanho' ya lleno
	 * */
	public int[][] creaMatriz(int filas, int columnas, int maxVal) {
		int[][]matriz=new int[filas][columnas];
		return rellenaMatriz(matriz, maxVal);
	}
	
	
	/**
	 * M�todo que imprime los valores de una matriz
	 * @param matriz Matriz que deseamos imprimir
	 * */
	public void imprimeMatriz(int[][]matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * M�todo que suma los valores de dos matrices
	 * @param a Primera matriz que deseamos sumar
	 * @param b Segunda matriz que deseamos sumar
	 * @return El m�todo devolver� una matriz con la suma de las dos matrices anteriores
	 * */
	public int[][] sumaMatriz(int[][]a, int[][]b) {
		int nFilas=a.length;
		int nColumnas=a[0].length;
		int[][] suma=new int[nFilas][nColumnas];
		for (int i = 0; i < suma.length; i++) {
			for (int j = 0; j < suma[i].length; j++) {
				suma[i][j]=a[i][j]+b[i][j];
			}
		}
		return suma;
	}
	
	/**
	 * M�todo que halla el mayor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar el mayor valor
	 * @return Retorna el mayor valor de la matriz.
	 * */
	public int mayorEnLaMatriz(int[][] matriz) {
		int aux=matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]>aux)
					aux=matriz[i][j];
			}
		}
		return aux;
	}
	
	/**
	 * M�todo que halla las posiciones del mayor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar las posiciones del mayor valor
	 * @return Retorna las posiciones del mayor valor de una matriz.
	 * */
	public void posicionesMayorEnLaMatriz(int[][] matriz) {
		int mayor=mayorEnLaMatriz(matriz);
		System.out.println("El mayor n�mero se encuentra en la/s posici�n/es: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(mayor==matriz[i][j])
					System.out.print("["+i+"]["+j+"]  ");
			}
		}
	}
	
	/**
	 * M�todo que halla el menor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar el menor valor
	 * @return Retorna el menor valor de la matriz.
	 * */
	public int menorEnLaMatriz(int[][] matriz) {
		int aux=matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]<aux)
					aux=matriz[i][j];
			}
		}
		return aux;
	}
	
	
	/**
	 * M�todo que halla las posiciones del menor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar las posiciones del menor valor
	 * @return Retorna las posiciones del menor valor de una matriz.
	 * */
	public void posicionesMenorEnLaMatriz(int[][] matriz) {
		int menor=menorEnLaMatriz(matriz);
		System.out.println("El menor n�mero se encuentra en la/s posici�n/es: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(menor==matriz[i][j])
					System.out.print("["+i+"]["+j+"]  ");
			}
		}
	}
	
	/**
	 * M�todo que halla el mayor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el mayor valor
	 * @return Mayor valor de la fila
	 * */
	public int mayorEnFila(int[][] matriz, int fila) {
		int aux=matriz[fila][0];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[fila][i]>aux)
				aux=matriz[fila][i];
		}
		return aux;
	}
	
	
	//DA EL NUMERO DE COLUMNA EN EL CUAL EST�
	/**
	 * M�todo que halla las columnas del mayor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el mayor valor
	 * @return Columnas en las cuales se encuentra el mayor valor de la fila
	 * */
	public int[] posicionesMayorEnFila(int[][] matriz,int fila) {
		int aux=mayorEnFila(matriz,fila);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	/**
	 * M�todo que halla el mayor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el mayor valor
	 * @return Mayor valor de la columna
	 * */
	public int mayorEnColumna(int[][] matriz, int columna) {
		int aux=matriz[0][columna];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i][columna]>aux)
				aux=matriz[i][columna];
		}
		return aux;
	}
	
	//DA EL N�MERO DE FILA EN EL CUAL EST�
	/**
	 * M�todo que halla las filas del mayor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el mayor valor
	 * @return Filas en las cuales se encuentra el mayor valor de la columna
	 * */
	public int[] posicionesMayorEnColumna(int[][] matriz,int columna) {
		int aux=mayorEnColumna(matriz,columna);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	/**
	 * M�todo que halla el menor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el menor valor
	 * @return Menor valor de la fila
	 * */
	public int menorEnFila(int[][] matriz, int fila) {
		int aux=matriz[fila][0];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[fila][i]<aux)
				aux=matriz[fila][i];
		}
		return aux;
	}
	
	/**
	 * M�todo que halla las columnas del menor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el menor valor
	 * @return Columnas en las cuales se encuentra el menor valor de la fila
	 * */
	public int[] posicionesMenorEnFila(int[][] matriz,int fila) {
		int aux=menorEnFila(matriz,fila);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	
	/**
	 * M�todo que halla el menor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el menor valor
	 * @return Menor valor de la columna
	 * */
	public int menorEnColumna(int[][] matriz, int columna) {
		int aux=matriz[0][columna];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i][columna]<aux)
				aux=matriz[i][columna];
		}
		return aux;
	}
	
	
	/**
	 * M�todo que halla las filas del menor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el menor valor
	 * @return Filas en las cuales se encuentra el menor valor de la columna
	 * */
	public int[] posicionesMenorEnColumna(int[][] matriz,int columna) {
		int aux=menorEnColumna(matriz,columna);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	/**
	 * M�todo que ordena una fila espec�fica de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos una fila
	 * @param fila Fila espec�fica que deseamos ordenar
	 * @return Matriz con la fila ya ordenada
	 * */
	public int[][] ordenaFilaMatrizAscendente(int[][] matriz, int fila) throws IOException{
		if(fila>=matriz.length || fila<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			fila=controlaIntMinMax(0,matriz.length-1);
		}
		int[] arrayAuxiliar=new int[matriz[0].length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[fila][i];
		}
		
		arrayAuxiliar=ordenacionInsercionDirectaAscendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[fila][i]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	/**
	 * M�todo que ordena una fila espec�fica de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos una fila
	 * @param fila Fila espec�fica que deseamos ordenar
	 * @return Matriz con la fila ya ordenada
	 * */
	public int[][] ordenaFilaMatrizDescendente(int[][] matriz, int fila) throws IOException{
		if(fila>=matriz.length || fila<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			fila=controlaIntMinMax(0,matriz.length-1);
		}
		int[] arrayAuxiliar=new int[matriz[0].length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[fila][i];
		}
		
		arrayAuxiliar=ordenacionInsercionDirectaDescendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[fila][i]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	
	/**
	 * M�todo que ordena una columna espec�fica de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos una columna
	 * @param columna Columna espec�fica que deseamos ordenar
	 * @return Matriz con la columna ya ordenada
	 * */
	public int[][] ordenaColumnaMatrizAscendente(int[][] matriz, int columna) throws IOException{
		if(columna>=matriz[0].length || columna<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			columna=controlaIntMinMax(0,matriz[0].length-1);
		}
		int[] arrayAuxiliar=new int[matriz.length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[i][columna];
		}
		
		arrayAuxiliar=ordenacionInsercionDirectaAscendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[i][columna]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	
	/**
	 * M�todo que ordena una columna espec�fica de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos una columna
	 * @param columna Columna espec�fica que deseamos ordenar
	 * @return Matriz con la columna ya ordenada
	 * */
	public int[][] ordenaColumnaMatrizDescendente(int[][] matriz, int columna) throws IOException{
		if(columna>=matriz[0].length || columna<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			columna=controlaIntMinMax(0,matriz[0].length-1);
		}
		int[] arrayAuxiliar=new int[matriz.length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[i][columna];
		}
		
		arrayAuxiliar=ordenacionInsercionDirectaDescendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[i][columna]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	/**
	 * M�todo que ordena todas las filas de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos las filas
	 * @return Matriz con las filas ya ordenadas
	 * */
	public int[][] ordenaFilasMatrizAscendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz.length; i++) {
			matriz=ordenaFilaMatrizAscendente(matriz,i);
		}
		
		return matriz;
	}
	
	
	/**
	 * M�todo que ordena todas las filas de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos las filas
	 * @return Matriz con las filas ya ordenadas
	 * */
	public int[][] ordenaFilasMatrizDescendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz.length; i++) {
			matriz=ordenaFilaMatrizDescendente(matriz,i);
		}
		
		return matriz;
	}
	
	
	/**
	 * M�todo que ordena todas las columnas de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos las columnas
	 * @return Matriz con las columnas ya ordenadas
	 * */
	public int[][] ordenaColumnasMatrizAscendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz[0].length; i++) {
			matriz=ordenaColumnaMatrizAscendente(matriz,i);
		}
		
		return matriz;
	}
	
	/**
	 * M�todo que ordena todas las columnas de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos las columnas
	 * @return Matriz con las columnas ya ordenadas
	 * */
	public int[][] ordenaColumnasMatrizDescendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz[0].length; i++) {
			matriz=ordenaColumnaMatrizDescendente(matriz,i);
		}
		
		return matriz;
	}
	
	/**
	 * M�todo p�blico que comprueba si un array est� contenido en una columna de una 
	 * matriz.
	 * @param matriz Matriz en la cual queremos comprobar si el array est� contenido
	 * @param array Array que queremos comprobar si est� contenido
	 * @return  <ul>
	 * 			<li>La columna en la cual se encuentra el array, en caso de estar contenido.</li>
	 * 			<li>-1 en caso de no estar contenida en ninguna columna</li>
	 * 			</ul>
	 * */
	public int comprobarColumnaContenida(int[][] matriz, int[] array) {
		int index=0;
		int coincidencia=0;
		int aux=0;
		int columna=0;
		boolean parar=false;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				index=0;
				aux=i;
				//Comprueba las coincidencias entre columna y array a partir de la primera.
				//Est� calculado, con la �ltima expresi�n, para que no se desborde el array.
				//Si se completan todas las coincidencias, est� contenido.
				while((index<array.length)&&(array[index]==matriz[aux][j])&&((array.length-i)>(array.length-1))) {
					coincidencia++;
					index++;
					aux++;
				}
				if (coincidencia==array.length) {
					System.out.println("\nEl array se encuentra en la columna "+j);
					parar=true;
					columna=j;
					break;
				}else
					coincidencia=0;
			}
			if(parar) {
				break;
				}
			
		}
		if(parar)
			return columna;
		else
			return -1;

	}
	
	/**
	 * M�todo p�blico que comprueba si un array est� contenido en una fila de una 
	 * matriz.
	 * @param matriz Matriz en la cual queremos comprobar si el array est� contenido
	 * @param array Array que queremos comprobar si est� contenido
	 * @return  <ul>
	 * 			<li>La fila en la cual se encuentra el array, en caso de estar contenido.</li>
	 * 			<li>-1 en caso de no estar contenida en ninguna fila</li>
	 * 			</ul>
	 * */
	public int comprobarFilaContenida(int[][] matriz, int[] array) {
		int index=0;
		int coincidencia=0;
		int aux=0;
		int fila=0;
		boolean parar=false;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				index=0;
				aux=j;
				while((index<array.length)&&(array[index]==matriz[i][aux])&&((array.length-j)>(array.length-1))) {
					coincidencia++;
					index++;
					aux++;
				}
				if (coincidencia==array.length) {
					System.out.println("\nEl array se encuentra en la fila "+i);
					parar=true;
					fila=i;
					break;
				}else
					coincidencia=0;
			}
			if(parar)
				break;
			
		}
		if(parar)
			return fila;
		else
			return -1;

	}
	
	/**
	 * M�todo p�blico que extrae una fila concreta de una matriz
	 * @param matriz Matriz de la cual queremos extraer la Fila
	 * @param fila Fila en concreto que queremos extraer
	 * @return Fila ya extra�da en un array
	 * */
	public int[] extraeFila (int[][] matriz, int fila) {
		int[] arrayAuxiliar=new int[matriz[0].length];
		for (int i = 0; i < matriz[0].length; i++) {
			arrayAuxiliar[i]=matriz[fila][i];
		}
		return arrayAuxiliar;
	}
	
	
	/**
	 * M�todo p�blico que extrae una columna concreta de una matriz
	 * @param matriz Matriz de la cual queremos extraer la Columna
	 * @param columna Columna en concreto que queremos extraer
	 * @return Columna ya extra�da en un array
	 * */
	public int[] extraeColumna (int[][] matriz, int columna) {
		int[] arrayAuxiliar=new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			arrayAuxiliar[i]=matriz[i][columna];
		}
		return arrayAuxiliar;
	}
	
	/**
	 * M�todo p�blico que inserta una fila en una matriz, indicando la posici�n inicial
	 * @param posX Posici�n Y del hueco de la matriz
	 * @param posY Posici�n Y del hueco de la matriz
	 * @param array Fila que deseamos insertar
	 * @param matriz Matriz en la cual deseamos insertar la fila
	 * */
	public int[][] insertaFila(int posX, int posY, int[] array,int[][] matriz) {
		if(matriz[0].length-posY>=array.length) {
			for (int i = 0; i < array.length; i++) {
				matriz[posX][posY+i]=array[i];
			}
		}else {
			System.out.println("Esa Fila no cabe en esa posici�n");
		}
		return matriz;
	}
	
	/**
	 * M�todo p�blico que inserta una columna en una matriz, indicando la posici�n inicial
	 * @param posX Posici�n Y del hueco de la matriz
	 * @param posY Posici�n Y del hueco de la matriz
	 * @param array Columna que deseamos insertar
	 * @param matriz Matriz en la cual deseamos insertar la columna
	 * */
	public int[][] insertaColumna(int posX, int posY, int[] array,int[][] matriz) {
		if(matriz.length-posX>=array.length) {
			for (int i = 0; i < array.length; i++) {
				matriz[posX+i][posY]=array[i];
			}
		}else {
			System.out.println("Esa Columna no cabe en esa posici�n");
		}
		return matriz;
	}
	
	/**
	 * M�todo p�blico que inserta una diagonal en una matriz, indicando la posici�n inicial
	 * @param posX Posici�n Y del hueco de la matriz
	 * @param posY Posici�n Y del hueco de la matriz
	 * @param array Diagonal que deseamos insertar
	 * @param matriz Matriz en la cual deseamos insertar la diagonal
	 * */
	public int[][] insertaDiagonal(int posX, int posY, int[] array,int[][] matriz) {
		if((matriz.length-posX>=array.length) && (matriz[0].length-posY>=array.length) ) {
			for (int i = 0; i < array.length; i++) {
				matriz[posX+i][posY+i]=array[i];
			}
		}else {
			System.out.println("Esa Diagonal no cabe en esa posici�n");
		}
		return matriz;
	}
	
	
	/*/////////////////////////////////////////////////////////////////////*/
	/*/RECURSIVOS//////////////////////////////////////////////////////////*/
	/*/////////////////////////////////////////////////////////////////////*/
	
	/**
	 * M�todo est�tico que calcula el factorial de un n�mero
	 * @param num N�mero entero del cual queremos conocer el factorial
	 * @return Factorial del n�mero, calculado con este m�todo recursivo
	 * */
	public int calculaFactorial(int num) {

		if(num==0) 
			return 1;
		else
		return num*calculaFactorial(num-1); //Devuelve el n�mero y el propio m�todo llam�ndose con la misma  variable -1.
	}
	
	
	/**
	 * M�todo p�blico que calcula la serie de Fibonacci
	 */
	public int serieFibonacci(int n) {

		if (n == 0 || n == 1)
			return n;
		else {
			return serieFibonacci(n - 1) + serieFibonacci(n - 2);

		}
	}
	
	/**
	 * M�todo p�blico que imprime la serie de Fibonacci
	 * @param limite Hasta qu� n�mero se imprime la serie de Fibonacci
	 * */
	public void imprimeSerieFibonacci(int limite) {
		for (int i = 0; i < limite; i++) {
		System.out.print(serieFibonacci(i)+" ");
		}
	}
	
	
	/**
	 * M�todo p�blico que calcula el tri�ngulo de Tartaglia
	 *@param i Fila en la cual nos encontramos
	 *@param j Columna en la cual nos encontramos
	 * */
  public int Tartaglia(int i, int j) {
    if (j == 0 || j == i) {
      return 1;
    } else {
      return Tartaglia(i-1, j-1) + Tartaglia(i-1,j);
    }
  }
  
  /**
   * M�todo p�blico que imprime el tri�ngulo de Tartaglia/Pascal
   * @param tamanho Cuantas filas se desea realizar del Tr�angulo de Tartaglia
   * */
  public void imprimeTartaglia(int tamanho) {
	    for (int i = 0; i < tamanho; i++) {
	      for (int k = 0; k < tamanho - i; k++) {
	        System.out.print(" ");
	      }
	      for (int j = 0; j <= i; j++) {
	        System.out.print(Tartaglia(i, j) + " ");
	      }
	      System.out.println();
	    }
  }
  
	/*/////////////////////////////////////////////////////////////////////*/
	/*/RECREATIVOS/////////////////////////////////////////////////////////*/
	/*/////////////////////////////////////////////////////////////////////*/
  
  /**
   * M�todo p�blico que imprime una matriz en caracol
   * @param tamanho Tama�o de la matriz caracol.
   * @param contador N�mero inicial por el cual empieza la Matriz Caracol
   * */
  public void Caracol (int tamanho, int contador) {

		int principio=0; // Variable inicial, para llevar la cuenta de los l�mites
		int fin=tamanho-1; //Variable inicial sobre el final, para llevar la cuenta de los l�mites
		int[][] matriz=new int[tamanho][tamanho]; //Matriz cuadrada. 
		
		for (int j = 0; j <=tamanho/2; j++) { //Mientras el contador no sea igual al 
											//cuadrado del tama�o, repite el bucle
			
			
			for (int i = principio; i <= fin; i++) {	//El primer for, va de izda a dcha,
				matriz[principio][i]=contador++;		//en las filas superiores.
			}
			
			
			for (int i = principio+1; i <= fin; i++) { //El segundo for, de arriba a abajo, 
				matriz[i][fin]=contador++;			  //en las columnas a la derecha.
			}
			
			
			for (int i = fin-1; i >=principio; i--) { //El tercer for, de dcha a izda
				matriz[fin][i]=contador++;			 //en la filas inferiores.
			}
			
			
			for (int i = fin-1; i >=principio+1; i--) { //El �ltimo for, va de abajo a arriba
				matriz[i][principio]=contador++;	   //en las columnas de la izquierda
			}
			
			principio++; //Aumentamos el principio en uno, para comenzar uno despu�s
			fin--; //Reducimos el final para acabar uno antes
		}
		
		imprimeMatriz(matriz);
  }
  
  	/**
  	 * M�todo p�blico que haya los puntos de silla de una matriz (Los menores n�meros
  	 * en su fila, pero los mayores en su columna)
  	 * @param matriz Matriz de la cual queremos hallar los puntos de silla
  	 * */
	public void puntoDeSilla(int[][] matriz) {

		int aux; // Variable auxiliar
		// imprimeMatriz(matriz);

		// System.out.println(amadeus.menorEnFila(matriz, 0));

		// EL MAYOR VALOR DE UNA FILA Y UNA COLUMNA
		/*
		 * for (int i = 0; i < matriz.length; i++) { aux = amadeus.mayorEnFila(matriz,
		 * i); respuestas = amadeus.posicionesMayorEnFila(matriz, i); for (int j = 0; j
		 * < respuestas.length; j++) { if(aux==amadeus.mayorEnColumna(matriz,
		 * respuestas[j]))
		 * System.out.println(aux+", fila "+i+" y columna "+respuestas[j]
		 * +", es el mayor com�n"); } }
		 */

		// OTRA VERSI�N BUENA, PERO MENOS EFICIENTE
		/*
		 * for (int i = 0; i < matriz.length; i++) { for (int j = 0; j <
		 * matriz[i].length; j++) { if (amadeus.menorEnFila(matriz, i) ==
		 * amadeus.mayorEnColumna(matriz, j)) { System.out.println(matriz[i][j] +
		 * "(Posici�n:[" + i + "," + j + "]" + " es un punto de silla"); } } }
		 */

		// Para cada fila, buscamos el menor valor existente y guardamos ese valor en un
		// auxiliar.
		for (int i = 0; i < matriz.length; i++) {
			aux = menorEnFila(matriz, i);
			for (int j = 0; j < matriz[i].length; j++) {
				if (aux == matriz[i][j]) { // Ahora, si el valor coincide en la fila, bloqueamos la columna y
											// comprobamos
					if (aux == mayorEnColumna(matriz, j))
						System.out.println(matriz[i][j] + "(Posici�n:[" + i + "," + j + "]" + " es un punto de silla");
				}
			}
		}

	}
	
	/**
	 * M�todo p�blico que extrae un punto de silla de una matriz, junto con 
	 * sus coordenadas.
	 * @param matriz Matriz de la cual queremos extraer el punto de silla
	 * @return Array con la siguiente estructura [puntoDeSilla, coordenadaI, coordenadaJ, puntoDeSilla, coordenadaI, coordenadaJ,...]
	 * */
	public int[] extraerPuntoDeSilla(int[][] matriz) {
		int aux; // Variable auxiliar
		int cont = 0; // Variable para contar los puntos de silla
		int[] array; // Aqu� guardaremos los puntos de silla y sus posiciones

		for (int i = 0; i < matriz.length; i++) {
			aux = menorEnFila(matriz, i);
			for (int j = 0; j < matriz[i].length; j++) {
				if (aux == matriz[i][j]) { // Ahora, si el valor coincide en la fila, bloqueamos la columna y
											// comprobamos
					if (aux == mayorEnColumna(matriz, j)) {
						System.out.println(matriz[i][j] + "(Posici�n:[" + i + "," + j + "]" + " es un punto de silla");
						cont++;
					}
				}
			}
		}

		array = new int[cont * 3]; // Le damos tama�o al array
		cont = 0;

		for (int i = 0; i < matriz.length; i++) {
			aux = menorEnFila(matriz, i);
			for (int j = 0; j < matriz[i].length; j++) {
				if (aux == matriz[i][j]) { // Ahora, si el valor coincide en la fila, bloqueamos la columna y
											// comprobamos
					if (aux == mayorEnColumna(matriz, j)) {
						array[cont] = aux;
						cont++;
						array[cont] = i;
						cont++;
						array[cont] = j;
						cont++;
					}
				}
			}
		}

		return array;
	}
	
	/**
	 * @param frase Frase/Palabra a comprobar si es o no un pal�ndromo
	 * */
	public void Palindromo (String frase) {
		
		//Le pedimos al usuario que escriba una frase.
		frase=frase.toLowerCase(); //La pasamos a min�sculas.
		frase=frase.trim(); //Quitamos espacios iniciales o finales si los hubiese. 
		char[] original=new char[frase.length()];
		char[] comprobante=new char[frase.length()];
		original=frase.toCharArray(); //Y a caracteres
		
		//Ahora, simplemente pasamos todos esos caracteres a otra variable,
		//pero en orden inverso al original.
		for (int i = 0; i < comprobante.length; i++) {
			comprobante[i]=original[frase.length()-i-1];
		}
		
		//Formamos un String con ese array de caracteres invertido
		String palindromo=new String(comprobante);
		
		//Y comprobamos. Si el string original es igual a este nuevo string de caracteres
		//invertidos, entonces, es un pal�ndromo.
		if(palindromo.equals(frase))
			System.out.println("S� es un pal�ndromo");
		else
			System.out.println("No es un pal�ndromo");
	}
	
	/**
	 * M�todo que cuenta las vocales de una cadena de caracteres.
	 * @param sujeto Frase a comprobar el n�mero de vocales
	 * */
	public void CuentaVocales(String sujeto) {
		int cont=0; //Entero para contar vocales
		char[] cadena; //En esta variable guardaremos el texto que introduzcamos, pasado a caracteres
		char[] origen= {'a','e','i','o','u', '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'}; //Caracteres (vocales) con los cuales comparar los caracteres de 'cadena'
		
		//Le pedimos al usuario que introduzca el texto que desee
		
		//Lo pasamos a min�sculas, y lo convertimos en un array de caracteres
		sujeto=sujeto.toLowerCase();
		cadena=sujeto.toCharArray();
		
		//Con un For, comparamos cuantos caracteres coinciden con las vocales, 
		//a�adiendo 1 al contador por cada coincidencia
		for (int i = 0; i < cadena.length; i++) {
			for (int j = 0; j < origen.length; j++) {
				if(cadena[i]==origen[j])
					cont++;
			}
		}
		
		//Imprimimos nuestra soluci�n
		System.out.println("En ese texto hay "+cont+" vocales.");
	}
	
	/**
	 * M�todo que elimina los espacios en blanco de una frase
	 * @param frase Frase de la cual eliminar los espacios en blanco
	 * */
	public String eliminaEspaciosBlancos(String frase) {
		//En este sencillo ejemplo, almacenaremos una frase en el String 'frase'.
				
				//A continuaci�n, con 'replaceAll', cambiaremos todos los espacios (//s) por nada.
				frase=frase.replaceAll("\\s", "");
				
				/*Y ya hemos eliminado los espacios en blanco. Con 'trim' podemos eliminar los espacios
				en blanco que hay delante o detr�s de una cadena. En este caso, est� hecho para eliminar
				espacios intermedios.*/
				return frase;
	}
	
	/**
	 * M�todo que comprueba si un n�mero es o no capic�a
	 * @param origen N�mero a comprobar si es capic�a o no
	 * */
	public void Capicua(int origen) {
		//N�mero que usaremos para comprobar
		int numeroFinal=0;
		//Convertimos el n�mero a String, y a array de caracteres.
		char[] aux=Integer.toString(origen).toCharArray();
		//El comprobante, igual.
		char[] comprobante=Integer.toString(origen).toCharArray();
		boolean capicua=false;
		
		//Pasamos al comprobante el n�mero al rev�s
		for (int i = 0; i < comprobante.length; i++) {
			comprobante[i]=aux[aux.length-i-1];
		}
		
		//Juntamos el n�mero y lo pasamos a integer
		numeroFinal=Integer.parseInt(String.valueOf(comprobante));
		
		//Comprobamos si es o no capic�a
		if(numeroFinal==origen)
			System.out.println("El n�mero es capic�a");
		else
			System.out.println("No lo es");
	}
	
	
	/*/////////////////////////////////////////////////////////////////////*/
	/*/MANEJO//DE//FICHEROS////////////////////////////////////////////////*/
	/*/////////////////////////////////////////////////////////////////////*/
	
	public File crearArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("El archivo se ha creado correctamente\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return archivo;
	}
	
	public File abrirArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
			salida.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return archivo;
	}
	
	public File abrirArchivo(File archivo) {
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
			salida.close();
			System.out.println("El archivo se ha abierto correctamente\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return archivo;
	}
	
	public void escribirArchivo(File archivo, String contenido) {
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
			salida.println("\n"+contenido);
			salida.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void leerArchivo(File archivo) {
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String lectura;
			lectura = entrada.readLine();
			while (lectura != null) {
				System.out.println(lectura);
				lectura = entrada.readLine();
			}
			entrada.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void anexarArchivo(File archivo, String contenido) {
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
			salida.println(contenido);
			salida.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void cuentaPalabras(File file) throws IOException {
		Amadeus amadeus=new Amadeus();
		ArrayList<String> lineas=new ArrayList<String>();
		ArrayList<String> palabras=new ArrayList<String>();
		BufferedReader lector = new BufferedReader(new FileReader(file));
		String linea=lector.readLine();
		
		while (linea!=null) {
			lineas.add(linea);
			linea=lector.readLine();
		}
		lector.close();
		for (String s : lineas) {
			palabras.addAll(Arrays.asList(s.split("\\s")));
		}
		
		System.out.println(palabras.size());
	}
	
	
	public void cuentaPalabrasPorLinea(File file) throws IOException {
		Amadeus amadeus=new Amadeus();
		ArrayList<String> lineas=new ArrayList<String>();
		ArrayList<String> palabras=new ArrayList<String>();
		int contador=1;
		BufferedReader lector = new BufferedReader(new FileReader(file));
		String linea=lector.readLine();
		
		while (linea!=null) {
			lineas.add(linea);
			linea=lector.readLine();
		}
		lector.close();
		for (String s : lineas) {
			System.out.println("L�nea "+contador+" : "+s.split("\\s").length+" palabras");
			contador++;
		}

	}
	
	public void contieneCaracter(char c, File f) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(f));
		String linea=lector.readLine();
		
		while (linea!=null) {
			char[] aux=linea.toCharArray();
			boolean contiene=false;
			for (int i = 0; i < aux.length; i++) {
				if(linea.charAt(i)==c) {
					contiene=true;
					break;
				}
			}
			if(contiene) {
				System.out.println(linea);
				linea=lector.readLine();
				}
			else
				linea=lector.readLine();
		}
		lector.close();
	}
	
	public void leerCaracterPorCaracter(File f) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(f));
		char c=(char) lector.read();
		while(c!=(char)(-1)) {
			System.out.println(c);
			c=(char) lector.read();
		}
		lector.close();
	}
	
	public static void leerCaracterPorCaracterMayusculas(File f) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(f));
		char c=(char) lector.read();
		while(c!=(char)(-1)) {
			if (Character.isDigit(c))
				c=(char) lector.read();
			else {
				if(Character.isLowerCase(c))
					c=Character.toUpperCase(c);
			System.out.println(c);
			c=(char) lector.read();
			}
		}
		lector.close();
	}
	
	
	
	
}
	
