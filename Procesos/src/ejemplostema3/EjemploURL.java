package ejemplostema3;

import java.net.*;

public class EjemploURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL url;
		try {
			System.out.println("Constructor simple para una URL: ");
			url = new URL("http://docs.oracle.com");
			Visualizar(url);
			
			System.out.println("Otro constructor simple para una URL: ");
			url = new URL("http://localhost");
			Visualizar(url);
			
			System.out.println("Cons. para protocolo +URL +directorio: ");
			url = new URL("http","docs.oracle.com","/javase/10");
			Visualizar(url);
			
			System.out.println("Const. +URL +puerto +directorio: ");
			url = new URL("http","localhost",8080,"/WebApp/Controlador?accion=modificar");
			Visualizar(url);
			
			System.out.println("Constructor para un objeto URL en un contexto: ");
			URL urlBase = new URL("http://docs.oracle.com");
			url=new URL(urlBase,"/javase/10/docs/api/java/net/URL.html");
			Visualizar(url);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void Visualizar(URL url) {
		System.out.println("\tURL Completa: "+url.toString());
		System.out.println("\tget Protocol: "+url.getProtocol());
		System.out.println("\tgetHost(): "+url.getHost());
		System.out.println("\tgetPort(): "+url.getPort());
		System.out.println("\tgetFile(): "+url.getFile());
		System.out.println("\tgetUserInfo(): "+url.getUserInfo());
		System.out.println("\tgetPath(): "+url.getPath());
		System.out.println("\tgetAuthority(): "+url.getAuthority());
		System.out.println("\tgetQuery(): "+url.getQuery());
		System.out.println("\tgetDefaultPort(): "+url.getDefaultPort());		
	
	}

}
