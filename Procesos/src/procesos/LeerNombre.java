package procesos;

public class LeerNombre {

	
	public static void main(String[] args) {
		//Le pasamos los argumentos al main dándole a run configuration, y poniéndolos
		//allí.
		for (String argumento : args) {
			System.out.println(argumento);
			if(argumento.equalsIgnoreCase("Prueba"))
				System.exit(4);
		}
		System.exit(-8);
	}

}
