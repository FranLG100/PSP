package ejemplostema3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Ejemplo2URL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL url=null;
		try {
			url=new URL("https://www.marca.com");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		BufferedReader in;
		
		try {
			InputStream inputStream=url.openStream();
			in=new BufferedReader(new InputStreamReader(inputStream));
			
			String inputLine;
			
			while((inputLine=in.readLine())!=null) {
				System.out.println(inputLine);
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
