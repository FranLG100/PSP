package procesos;

public class LeerNombre {

	
	public static void main(String[] args) {
		//Le pasamos los argumentos al main dadole a run configuration, y poniedolos
		//alli.
		for (String argumento : args) {
			System.out.println(argumento);
			if(argumento.equalsIgnoreCase("Prueba"))
				System.exit(4); //Si encuentra un argumento que coincida con Prueba, sale con el codigo 4
		}
		System.exit(-8); //Si no lo encuentra, sale con el codigo -8
	}

}
