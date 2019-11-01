package utilesFran;

import java.util.StringTokenizer;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Amadeus amadeus = new Amadeus();
		int[][] matriz=amadeus.creaMatriz(6, 6, 9);
		int[] array=amadeus.creaArrayLleno(4, 9);
		amadeus.imprimeMatriz(matriz);
		System.out.println();
		amadeus.imprimeArray(array);
		System.out.println();
		System.out.println();
		matriz=amadeus.insertaDiagonal(2, 3, array, matriz);
		amadeus.imprimeMatriz(matriz);
		
}
}
