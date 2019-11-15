package ejemplostema3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo1urlCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL url=null;
		URLConnection urlCon=null;
		try {
			url=new URL("https://www.marca.com");
			urlCon=url.openConnection();
			
			BufferedReader in;
			InputStream inputStream=urlCon.getInputStream();
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
