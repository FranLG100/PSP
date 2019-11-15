package ejemplostema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Ejemplo3urlCon {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String cadena;
		URL url=new URL("http://localhost/2018/vernombre.html");
		URLConnection conexion=url.openConnection();
		
		System.out.println("Direccion [getUrl()]: "+conexion.getURL());
		
		Date fecha=new Date(conexion.getLastModified());
		System.out.println("Fecha ultima modificacion [getLastModified()]: "+fecha);
		System.out.println("Tipo de contenido [getContentType]: "+conexion.getContentType());
		
		System.out.println("================================");
		
		System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
		
		Map camposCabecera=conexion.getHeaderFields();
		Iterator it=camposCabecera.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry map=(Map.Entry) it.next();
			System.out.println(map.getKey() +" : "+map.getValue());
		}
		
		System.out.println("===================================");
		System.out.println("CAMPOS 1 Y 4 DE CABECERA: ");
		System.out.println("getHeaderField(1)=> "+conexion.getHeaderField(1));
		System.out.println("getHeaderField(4)=> "+conexion.getHeaderField(4));
		System.out.println("===================================");
		
		System.out.println("CONTENIDO DE [url.getFile()]: "+url.getFile());
		BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));
		
		while((cadena=pagina.readLine())!=null)
			System.out.println(cadena);
	}

}
