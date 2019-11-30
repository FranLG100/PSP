package unidad3autoevaluacion.Actividad_02.modelo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import unidad3autoevaluacion.Actividad_02.vista.VistaCliente;
import unidad3autoevaluacion.Actividad_02.vista.VistaServidor;

public class Cliente {
	
	int puerto=55557;
	MulticastSocket ms;
	InetAddress grupo;
	boolean activo;
	
	
	public Cliente() throws IOException {
		ms=new MulticastSocket(puerto);
		grupo=InetAddress.getByName("230.0.0.1");
		ms.joinGroup(grupo);
		activo=true;
	}
	
	public void recibir(VistaCliente vista) throws IOException {
		while(activo) {
			String msg="";
			byte[] buf=new byte[1000];
				
			DatagramPacket paquete=new DatagramPacket(buf, buf.length);
			ms.receive(paquete);
				
			msg=new String(paquete.getData());
			System.out.println("Recibo: "+msg.trim());
			
			String area="";
			area=vista.campoRecibo.getText();
			vista.campoRecibo.setText(area+"\nRecibiendo>>> "+msg.trim());
		}
	}
	
	public void cerrar() throws IOException {
		activo=false;
		ms.leaveGroup(grupo);
		ms.close();
		System.out.println("Socket del cliente cerrado");
		System.exit(0);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		/*String msg="";
		byte[] buf=new byte[1000];
			
		DatagramPacket paquete=new DatagramPacket(buf, buf.length);
		ms.receive(paquete);
			
		msg=new String(paquete.getData());
		System.out.println("Recibo: "+msg.trim());*/
		
		
		//ms.leaveGroup(grupo);
		//ms.close();
		//System.out.println("Socket del cliente cerrado");
	}

}
