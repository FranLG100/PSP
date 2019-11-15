package ejemplostema3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo2urlCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			URL url=new URL("http://localhost/2018/vernombre.php");
			URLConnection conexion=url.openConnection();
			conexion.setDoOutput(true);
			
			String cadena="nombre=Fran&apellidos=Lorente";
			
			PrintWriter output=new PrintWriter(conexion.getOutputStream());
			output.write(cadena);
			output.close();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			
			while((linea=reader.readLine())!=null) {
				System.out.println(linea);
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
