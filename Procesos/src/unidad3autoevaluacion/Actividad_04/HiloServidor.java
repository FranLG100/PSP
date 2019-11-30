package unidad3autoevaluacion.Actividad_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

import ejemplostema3parte2.Persona;

public class HiloServidor extends Thread{
	
	int identificador=1;
	Socket socket=null;
	String codigo="";
	ObjectOutputStream outObjeto;
	BufferedReader fentrada;
	
	public HiloServidor(Socket s, int identificador) throws IOException {
		this.socket = s;
		this.identificador=identificador;
		//fsalida= new PrintWriter(socket.getOutputStream(),true);
		//this.fentrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//this.outObjeto=new ObjectOutputStream(socket.getOutputStream());
		
		}
	
	public void run() {
		Asignatura a1=new Asignatura(1, "Matematicas");
		Asignatura a2=new Asignatura(2, "Lenguaje");
		Asignatura a3=new Asignatura(3, "Sociales");
		Asignatura a4=new Asignatura(4, "Arte");
		Asignatura a5=new Asignatura(5, "Deportes");
		
		Especialidad e1=new Especialidad(1, "Geometria");
		Especialidad e2=new Especialidad(2, "Literatura Hispanica");
		Especialidad e3=new Especialidad(3, "Geografia");
		
		Profesor p1=new Profesor(1, "Juan", new Asignatura[]{a1,a4,a3}, e1);
		Profesor p2=new Profesor(2, "Lina Gavira", new Asignatura[]{a5,a4,a2}, e3);
		Profesor p3=new Profesor(3, "Pedro Perez", new Asignatura[]{a2,a4,a3}, e2);
		
		HashMap<Integer,Profesor> profesor=new HashMap<Integer,Profesor>();
		profesor.put(p1.getIdProfesor(), p1);
		profesor.put(p2.getIdProfesor(), p2);
		profesor.put(p3.getIdProfesor(), p3);
		
		Profesor p;
		
		String cadena="";
		System.out.println("COMUNICO CON: "+identificador);
		
		while(!codigo.trim().equals("*")) {
			try {
				fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				codigo=fentrada.readLine();
				System.out.println(identificador+" PIDE AL PROFESOR ID: "+codigo);
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			
			try {
				outObjeto = new ObjectOutputStream(socket.getOutputStream());
				if(codigo.trim().equals("*"))
					p=new Profesor("FALLO");
				else
					p=profesor.get(Integer.parseInt(codigo));
				outObjeto.writeObject(p);
				System.out.println("Envio: "+p.getNombre()+" * "+p.getIdProfesor());
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
		}
		
		System.out.println("FIN CON: "+identificador);
		
		try {
			outObjeto.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
