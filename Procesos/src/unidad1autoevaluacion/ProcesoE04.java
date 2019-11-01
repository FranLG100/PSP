package unidad1autoevaluacion;

public class ProcesoE04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int valor=0;
		boolean cadena=false;
		
		try {
			valor=Integer.parseInt(args[0]);
		}catch(Exception e){};
		
		for (char c : args[0].toCharArray()) {
			if(!Character.isDigit(c)) {
				cadena=true;
				break;
			}
		}
		
		if(args.length<1)
			System.exit(1);
		else if(valor<0)
			System.exit(3);
		else if(args[0].length()>0 && cadena)
			System.exit(2);
		else 
			System.exit(0);
	}

}
