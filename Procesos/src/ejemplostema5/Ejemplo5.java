package ejemplostema5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ejemplo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileOutputStream fileout=new FileOutputStream("DATOS.DAT");
			ObjectOutputStream dataOS= new ObjectOutputStream(fileout);
			
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			String datos="En un lugar de la Mancha de cuyo nombre no quiero acordarme"+
			",no ha mucho tiempo que vivia un hidalgo de los de lanza en astillero"+
					",adarga antigua, rocin flaco y galgo corredor";
			
			byte[] dataBytes=datos.getBytes();
			
			md.update(dataBytes);
			byte resumen[]=md.digest();
			dataOS.writeObject(datos);
			dataOS.writeObject(resumen);
			
			dataOS.close();
			fileout.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
