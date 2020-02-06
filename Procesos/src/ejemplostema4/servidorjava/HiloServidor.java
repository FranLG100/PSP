package ejemplostema4.servidorjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread{

	Socket socket;
	ObjectOutputStream outObjeto;
	ObjectInputStream inObjeto;
	EstructuraFicheros NF;
	
	public HiloServidor(Socket s, EstructuraFicheros nF) throws IOException {
		socket=s;
		NF=nF;
		inObjeto=new ObjectInputStream(socket.getInputStream());
		outObjeto=new ObjectOutputStream(socket.getOutputStream());
	}
	
	public void run() {
		try {
			outObjeto.writeObject(NF);
			
			while(true) {
				Object peticion=inObjeto.readObject();
				
				if(peticion instanceof PideFichero) {
					PideFichero fichero=(PideFichero) peticion;
					EnviarFichero(fichero);
				}
				
				if(peticion instanceof PideActualizacion) {
					System.out.println("Que nos piden que actualicemos");
					PideActualizacion pa=(PideActualizacion) peticion;
					EstructuraFicheros n=new EstructuraFicheros(this.NF.getPath());
					System.out.println(this.NF.getPath());
					outObjeto.writeObject(n);
				}
				
				if(peticion instanceof PidePath) {
					System.out.println("Que nos piden que cambiemos el directorio");
					PidePath pp=(PidePath) peticion;
					EstructuraFicheros n=new EstructuraFicheros(pp.getPathDirectorio());
					System.out.println(pp.getPathDirectorio());
					NF.setPath(pp.getPathDirectorio());
					outObjeto.writeObject(n);
				}
				
				if(peticion instanceof EnviaFichero) {
					EnviaFichero fic=(EnviaFichero) peticion;
					File d=new File(fic.getDirectorio());
					File f1=new File(d,fic.getNombre());
					
					FileOutputStream fos=new FileOutputStream(f1);
					fos.write(fic.getContenidoFichero());
					fos.close();
					
					EstructuraFicheros n=new EstructuraFicheros(fic.getDirectorio());
					
					outObjeto.writeObject(n);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				inObjeto.close();
				outObjeto.close();
				socket.close();
				System.out.println("Cerrando cliente");
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} 
		}
	}
	
	
	private void EnviarFichero(PideFichero fich) {
		File fichero=new File(fich.getNombreFichero());
		FileInputStream filein=null;
		
		try {
			filein=new FileInputStream(fichero);
			long bytes=fichero.length();
			byte[] buff=new byte[(int) bytes];
			int i,j=0;
			
			while ((i=filein.read())!=-1) {
				buff[j]=(byte)i;
				j++;
			}
			filein.close();
			Object ff=new ObtieneFichero(buff);
			
			outObjeto.writeObject(ff);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
