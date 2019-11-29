package ejemplostema3parte2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MCcliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int puerto=55557;
		MulticastSocket ms=new MulticastSocket(puerto);
		
		InetAddress grupo=InetAddress.getByName("230.0.0.1");
		
		ms.joinGroup(grupo);
		
		String msg="";
		
		while(!msg.trim().equals("*")) {
			byte[] buf=new byte[1000];
			
			DatagramPacket paquete=new DatagramPacket(buf, buf.length);
			ms.receive(paquete);
			
			msg=new String(paquete.getData());
			System.out.println("Recibo: "+msg.trim());
		}
		
		ms.leaveGroup(grupo);
		ms.close();
		System.out.println("Socket del cliente cerrado");
	}

}
