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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Actividad_02 extends JFrame{

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
	static JTextField mensaje= new JTextField();
	static JCheckBox negociacion=new JCheckBox();
	
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
	JLabel lblNeg=new JLabel("Con TLS");
	JLabel lblUsuario=new JLabel("Usuario");
	JLabel lblClave=new JLabel("Clave");
	JLabel lblRemitente=new JLabel("Remitente");
	JLabel lblDestinatario=new JLabel("Destino");
	JLabel lblAsunto=new JLabel("Asunto");
	JLabel lblMensaje=new JLabel("Mensaje");
	
	private final Container c=getContentPane();
	
	
	public Actividad_02() throws SocketException, IOException {
		
		
		
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
		
		negociacion.setBounds(520, 50,size.width, size.height);
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
		
		
		
		lblRemitente.setBounds(30, 130,size.width, size.height);
		lblRemitente.setVisible(true);
		add(lblRemitente);
		
		remitente.setBounds(120,130,180,20);
		remitente.setVisible(true);
		add(remitente);
		
		lblDestinatario.setBounds(320, 130,size.width, size.height);
		lblDestinatario.setVisible(true);
		add(lblDestinatario);
		
		destino1.setBounds(370,130,180,20);
		destino1.setVisible(true);
		add(destino1);
		
		
		lblAsunto.setBounds(30, 170,size.width, size.height);
		lblAsunto.setVisible(true);
		add(lblAsunto);
		
		asunto.setBounds(120,170,180,20);
		asunto.setVisible(true);
		add(asunto);
		
		
		
		lblMensaje.setBounds(30, 210,size.width, size.height);
		lblMensaje.setVisible(true);
		add(lblMensaje);
		
		mensaje.setBounds(120,210,180,20);
		mensaje.setVisible(true);
		add(mensaje);
		
		
		
		
		
		btnConectar.setBounds(570, 90, 150, 30);
		add(btnConectar);
		
		btnEnviar.setBounds(370, 515, 150, 30);
		add(btnEnviar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(880,600);
		setVisible(true);
		final AuthenticatingSMTPClient client=new AuthenticatingSMTPClient();;
			//Metodo para salir de la aplicacion
			btnConectar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					try {
						int respuesta;
						KeyManagerFactory kmf=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
						kmf.init(null,null);
						KeyManager km=kmf.getKeyManagers()[0];
						
						client.connect(server.getText(),Integer.parseInt(puerto.getText()));
						System.out.println("1 - "+client.getReplyString());
						client.setKeyManager(km);
						
						respuesta=client.getReplyCode();
						if(!SMTPReply.isPositiveCompletion(respuesta)) {
							client.disconnect();
							System.err.println("Conexion rechazada");
							System.exit(1);
						}
							
							client.ehlo(server.getText());
							System.out.println("2 - "+client.getReplyString());
							/*
							if(negociacion) {
								if(client.execTLS()) {
									System.out.println("3 - "+client.getReplyString());
									
									if(client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username, password)) {
										System.out.println("4 - "+client.getReplyString());
										
										SimpleSMTPHeader cabecera=new SimpleSMTPHeader(remitente,destino1,asunto);
										
										client.setSender(remitente);
										client.addRecipient(destino1);
										System.out.println("5 - "+client.getReplyString());
										
										Writer writer=client.sendMessageData();
										
										if(writer==null) {
											System.out.println("FALLO AL ENVIAR DATA");
											System.exit(1);
										}
										
										writer.write(cabecera.toString());
										writer.write(mensaje);
										writer.close();
										System.out.println("6 - "+client.getReplyString());
										
										boolean exito=client.completePendingCommand();
										System.out.println("7 - "+client.getReplyString());
										
										if(!exito) {
											System.out.println("FALLO AL FINALIZAR TRANSACCION");
											System.exit(1);
										}else
											System.out.println("Mensaje enviado con EXITO");
									}else
											System.out.println("USUARIO NO AUTENTICADO");
							}else
								System.out.println("FALLO AL EJECUTAR STARTLLS");
						}else {
							if(client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username, password)) {
								System.out.println("4 - "+client.getReplyString());
								
								SimpleSMTPHeader cabecera=new SimpleSMTPHeader(remitente,destino1,asunto);
								
								client.setSender(remitente);
								client.addRecipient(destino1);
								System.out.println("5 - "+client.getReplyString());
								
								Writer writer=client.sendMessageData();
								
								if(writer==null) {
									System.out.println("FALLO AL ENVIAR DATA");
									System.exit(1);
								}
								
								writer.write(cabecera.toString());
								writer.write(mensaje);
								writer.close();
								System.out.println("6 - "+client.getReplyString());
								
								boolean exito=client.completePendingCommand();
								System.out.println("7 - "+client.getReplyString());
								
								if(!exito) {
									System.out.println("FALLO AL FINALIZAR TRANSACCION");
									System.exit(1);
								}else
									System.out.println("Mensaje enviado con EXITO");
							}else
									System.out.println("USUARIO NO AUTENTICADO");
						}
					}*/} catch (Exception e1) {
						// TODO: handle exception
						System.err.println("Could not connect to server");
						e1.printStackTrace();
						System.exit(1);
					}/*
					try {
						client.disconnect();
					} catch (IOException f) {
						// TODO: handle exception
						f.printStackTrace();
					}
					
					System.out.println("Fin de envio");*/
					
				}
			});
			
			
			btnEnviar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					
					try {
							if(negociacion.isSelected()) {
								if(client.execTLS()) {
									System.out.println("3 - "+client.getReplyString());
									
									if(client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username.getText(), password.getText())) {
										System.out.println("4 - "+client.getReplyString());
										
										SimpleSMTPHeader cabecera=new SimpleSMTPHeader(remitente.getText(),destino1.getText(),asunto.getText());
										
										client.setSender(remitente.getText());
										client.addRecipient(destino1.getText());
										System.out.println("5 - "+client.getReplyString());
										
										Writer writer=client.sendMessageData();
										
										if(writer==null) {
											System.out.println("FALLO AL ENVIAR DATA");
											System.exit(1);
										}
										
										writer.write(cabecera.toString());
										writer.write(mensaje.getText());
										writer.close();
										System.out.println("6 - "+client.getReplyString());
										
										boolean exito=client.completePendingCommand();
										System.out.println("7 - "+client.getReplyString());
										
										if(!exito) {
											System.out.println("FALLO AL FINALIZAR TRANSACCION");
											System.exit(1);
										}else
											System.out.println("Mensaje enviado con EXITO");
									}else
											System.out.println("USUARIO NO AUTENTICADO");
							}else
								System.out.println("FALLO AL EJECUTAR STARTLLS");
						}else {
							if(client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username.getText(), password.getText())) {
								System.out.println("4 - "+client.getReplyString());
								
								SimpleSMTPHeader cabecera=new SimpleSMTPHeader(remitente.getText(),destino1.getText(),asunto.getText());
								
								client.setSender(remitente.getText());
								client.addRecipient(destino1.getText());
								System.out.println("5 - "+client.getReplyString());
								
								Writer writer=client.sendMessageData();
								
								if(writer==null) {
									System.out.println("FALLO AL ENVIAR DATA");
									System.exit(1);
								}
								
								writer.write(cabecera.toString());
								writer.write(mensaje.getText());
								writer.close();
								System.out.println("6 - "+client.getReplyString());
								
								boolean exito=client.completePendingCommand();
								System.out.println("7 - "+client.getReplyString());
								
								if(!exito) {
									System.out.println("FALLO AL FINALIZAR TRANSACCION");
									System.exit(1);
								}else
									System.out.println("Mensaje enviado con EXITO");
							}else
									System.out.println("USUARIO NO AUTENTICADO");
						}
					} catch (Exception e1) {
						// TODO: handle exception
						System.err.println("Could not connect to server");
						e1.printStackTrace();
						System.exit(1);
					}
					/*try {
						client.disconnect();
					} catch (IOException f) {
						// TODO: handle exception
						f.printStackTrace();
					}*/
					
					System.out.println("Fin de envio");
					
				}
			});
			
			
		
	}
	
	
	public static void main(String[] args) throws SocketException, IOException {
		// TODO Auto-generated method stub
		new Actividad_02();
	}

}
