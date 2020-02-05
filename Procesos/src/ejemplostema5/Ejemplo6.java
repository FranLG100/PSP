package ejemplostema5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.MessageDigest;

public class Ejemplo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fileout =new FileInputStream("DATOS.dat");
			ObjectInputStream dataOS=new ObjectInputStream(fileout);
			Object o=dataOS.readObject();
			
			String datos=(String) o;
			System.out.println("Datos: "+datos);
			
			o=dataOS.readObject();
			byte resumenOriginal[]=(byte[]) o;
			
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			
			md.update(datos.getBytes());
			byte resumenActual[]=md.digest();
			
			if(MessageDigest.isEqual(resumenActual, resumenOriginal))
				System.out.println("DATOS VALIDOS");
			else
				System.out.println("DATOS NO VALIDOS");
			
			dataOS.close();
			fileout.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
