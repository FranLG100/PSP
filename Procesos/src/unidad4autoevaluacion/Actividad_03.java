package unidad4autoevaluacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.SocketException;
import java.util.jar.JarInputStream;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Actividad_03 extends JFrame{

	//Toda la parte visual
	//para el login, es usuario, usuario pass y user.
	//Pero vamos, que no va a funcionar fuera de mi local
	static JTextField server= new JTextField();
	static JTextField username= new JTextField();
	static JTextField password= new JTextField();
	static JTextField puerto= new JTextField();
	static JTextField remitente= new JTextField();
	static JTextField destino1= new JTextField();
	static JTextField asunto= new JTextField();
	static JTextArea mensaje= new JTextArea();
	static JCheckBox negociacion=new JCheckBox();
	
	POP3SClient popTrue=new POP3SClient(true);
	POP3SClient popFalse=new POP3SClient();
	
	private static JTextField campo=new JTextField();
	private static JTextField campo2=new JTextField();
	
	JButton btnConectar=new JButton("Conectar");
	JButton btnEnviar=new JButton("Enviar");
	JButton botonBorrar=new JButton("Eliminar fichero");
	JButton botonCreaDir=new JButton("Crear carpeta");
	JButton botonDelDir=new JButton("Eliminar carpeta");
	JButton botonSalir=new JButton("Salir");
	
	JLabel lblServer=new JLabel("ServidorSMTP");
	JLabel lblPuerto=new JLabel("Puerto");
	JLabel lblNeg=new JLabel("M Implicito");
	JLabel lblUsuario=new JLabel("Usuario");
	JLabel lblClave=new JLabel("Clave");
	JLabel lblMensaje=new JLabel("Mensaje");
	
	static JList listaMensajes=new JList();
	
	private final Container c=getContentPane();
	
	
	public Actividad_03() throws SocketException, IOException {
		
		c.setLayout(null);
		
		
		
		Dimension size=lblServer.getPreferredSize();
		lblServer.setBounds(30, 50,size.width, size.height);
		lblServer.setVisible(true);
		add(lblServer);
		
		server.setBounds(120,50,180,20);
		server.setVisible(true);
		add(server);
		
		lblPuerto.setBounds(320, 50,size.width, size.height);
		lblPuerto.setVisible(true);
		add(lblPuerto);
		
		puerto.setBounds(370,50,80,20);
		puerto.setVisible(true);
		add(puerto);
		
		lblNeg.setBounds(470, 50,size.width, size.height);
		lblNeg.setVisible(true);
		add(lblNeg);
		
		negociacion.setBounds(530, 50,size.width, size.height);
		negociacion.setVisible(true);
		add(negociacion);
		
		lblUsuario.setBounds(30, 90,size.width, size.height);
		lblUsuario.setVisible(true);
		add(lblUsuario);
		
		username.setBounds(120,90,180,20);
		username.setVisible(true);
		add(username);
		
		lblClave.setBounds(320, 90,size.width, size.height);
		lblClave.setVisible(true);
		add(lblClave);
		
		password.setBounds(370,90,180,20);
		password.setVisible(true);
		add(password);
		
		listaMensajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane barraDesplazamiento=new JScrollPane(listaMensajes);
		barraDesplazamiento.setPreferredSize(new Dimension(335,420));
		barraDesplazamiento.setBounds(new Rectangle(30,140,635,120));
		c.add(barraDesplazamiento);
		c.setLayout(null);
		
		lblMensaje.setBounds(30, 300,size.width, size.height);
		lblMensaje.setVisible(true);
		add(lblMensaje);
		
		JScrollPane barraDesplazamientoMen=new JScrollPane(mensaje);
		barraDesplazamientoMen.setPreferredSize(new Dimension(335,420));
		barraDesplazamientoMen.setBounds(new Rectangle(30,330,635,200));
		//mensaje.setBounds(30,330,635,200);
		//mensaje.setVisible(true);
		//add(mensaje);
		c.add(barraDesplazamientoMen);
		c.setLayout(null);
		
		
		
		
		
		btnConectar.setBounds(570, 90, 150, 30);
		add(btnConectar);
		
		/*btnEnviar.setBounds(370, 515, 150, 30);
		add(btnEnviar);*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(880,600);
		setVisible(true);
		final AuthenticatingSMTPClient client=new AuthenticatingSMTPClient();;
			//Metodo para salir de la aplicacion
		
		listaMensajes.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				POP3SClient pop3;
				if(negociacion.isSelected())
					pop3=popTrue;
				else
					pop3=popFalse;
				// TODO Auto-generated method stub
				if(lse.getValueIsAdjusting()) {
					POP3MessageInfo[] men;
					try {
						men = pop3.listMessages();
						RecuperarMensaje(men, pop3, lse.getFirstIndex());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//System.out.println("OLE OLE LO CARACOLE "+lse.getFirstIndex());
				}
					
				}
		});
		
		
			btnConectar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					POP3SClient pop3;
					/*String server="pop.gmail.com";
					String username="fralg100@gmail.com";
					String password="canoncien100";
					int puerto = 995;*/
					
					//Ese true es para comenzar la negociacion ssl tls justo despues de establecer
					//la conexion
					if(negociacion.isSelected())
						pop3=popTrue;
					else
						pop3=popFalse;
					try {
						//nos conectamos
						pop3.connect(server.getText(),Integer.parseInt(puerto.getText()));
						System.out.println("Conexion realizada  al servidor POP3 "+server);
						
						//comprobamos si nos logamos o no
						if(!pop3.login(username.getText(), password.getText()))
							System.err.println("Error al hacer login");
						else {
							POP3MessageInfo[] men=pop3.listMessages();
							
							//si hay mensajes
							if(men==null)
								System.out.println("Imposible recuperar mensajes");
							else
								System.out.println("N de mensajes: "+men.length);
							
							//Recuperamos el mensaje, cabeceras y cuerpo
							//System.out.println(pop3.getReplyString());
							//RecuperarCabeceras(men, pop3);
							
							DefaultListModel modeloLista=new DefaultListModel();
							for (int i = 0; i < men.length; i++) {
								System.out.println("Hemos llegado");
								modeloLista.addElement("Mensaje n:"+i);
							}
							listaMensajes.setModel(modeloLista);
							//RecuperarMensaje(men, pop3);
							//pop3.logout();
						}
						//pop3.disconnect();
						//Salimos
					} catch (IOException e1) {
						// TODO: handle exception
						System.err.println(e1.getMessage());
						e1.printStackTrace();
						System.exit(1);
					}
					//System.exit(0);
				}
			});
			
	}
	
	
	public static void main(String[] args) throws SocketException, IOException {
		// TODO Auto-generated method stub
		new Actividad_03();
	}
	
	private static void RecuperarCabeceras(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: "+(i+1));
			POP3MessageInfo msginfo=men[i];
			
			System.out.println("Cabecera del mensaje: ");
			BufferedReader reader=(BufferedReader) pop3.retrieveMessageTop(msginfo.number,0);
			String linea;
			while((linea=reader.readLine())!=null)
				System.out.println(linea.toString());
			reader.close();
		}
	}
	
	//Metodo para recuperar el mensaje al completo, cabecera y texto
	private static void RecuperarMensaje(POP3MessageInfo[] men, POP3SClient pop3, int index) throws IOException {
		//for (int i = 0; i < men.length; i++) {
			//System.out.println("Mensaje: "+(i+1));
			mensaje.setText("");
			POP3MessageInfo msginfo=men[index];
			
			System.out.println("Mensaje: ");
			BufferedReader reader=(BufferedReader) pop3.retrieveMessage(msginfo.number);
			String linea;
			while((linea=reader.readLine())!=null)
				mensaje.append(linea.toString()+"\n");
			reader.close();
		//}
	}

}
