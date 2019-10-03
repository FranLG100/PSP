package procesos;

import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Al ejecutarlo, lanza el Bloc de Notas de Windows
		Process pb=new ProcessBuilder("NOTEPAD").start();
		
	}

}
