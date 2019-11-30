package unidad3autoevaluacion.Actividad_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import ejemplostema3parte2.Persona;

public class MuletaServidor {

	public static void main(String[] args) throws IOException,ClassNotFoundException {
		// TODO Auto-generated method stub

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
		
		int numeroPuerto=6000;
		ServerSocket servidor=new ServerSocket(numeroPuerto);
		
		
		System.out.println("Esperando al cliente...");
		Socket cliente=servidor.accept();
		
		BufferedReader fentrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		String codigo=fentrada.readLine();
		System.out.println("RECIBO "+codigo);
		
		ObjectOutputStream outObjeto=new ObjectOutputStream(cliente.getOutputStream());
		Profesor p=profesor.get(Integer.parseInt(codigo));
		outObjeto.writeObject(p);
		System.out.println("Envio: "+p.getNombre()+" * "+p.getIdProfesor());
		
		
		
		outObjeto.close();
		cliente.close();
		servidor.close();
	}

}
