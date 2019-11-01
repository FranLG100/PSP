package unidad1autoevaluacion;

public class ProcesoE05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length>0)
			for (int i = 0; i < 5; i++) {
				System.out.println(args[0]);
			}
		else {
			System.out.println("No hay ninguna cadena");
			System.exit(1);
	}

}
}
