package ejerciciostema4;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.SocketException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Ejercicio4_03 extends JFrame{

	static JTextField cab= new JTextField();
	static JTextField cab2= new JTextField();
	static JTextField cab3= new JTextField();
	
	private static JTextField campo=new JTextField();
	private static JTextField campo2=new JTextField();
	
	JButton botonCargar=new JButton("Subir fichero");
	JButton botonDescargar=new JButton("Descargar fichero");
	JButton botonBorrar=new JButton("Eliminar fichero");
	JButton botonCreaDir=new JButton("Crear carpeta");
	JButton botonDelDir=new JButton("Eliminar carpeta");
	JButton botonSalir=new JButton("Salir");
	
	static JList listaDirec=new JList();
	
	private final Container c=getContentPane();
	
	static FTPClient cliente=new FTPClient();
	String servidor="localhost";
	String user="usuario";
	String pass="usuario";
	boolean login;
	
	static String direcInicial="/";
	static String direcSelec=direcInicial;
	static String ficheroSelec="";
	
	
	public Ejercicio4_03() throws SocketException, IOException {
		super("CLIENTE BASICO FTP");
		cliente.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		cliente.connect(servidor);
		cliente.enterLocalPassiveMode();
		login=cliente.login(user, pass);
		
		cliente.changeWorkingDirectory(direcInicial);
		
		FTPFile[] files=cliente.listFiles();
		
		llenarLista(files,direcInicial);
		
		campo.setText("<<ARBOL DE DIRECTORIOS CONSTRUIDO>>");
		cab.setText("Servidor FTP: "+servidor);
		cab2.setText("Usuario: "+user);
		cab3.setText("DIRECTORIO RAIZ: "+direcInicial);
		
		listaDirec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane barraDesplazamiento=new JScrollPane(listaDirec);
		barraDesplazamiento.setPreferredSize(new Dimension(335,420));
		barraDesplazamiento.setBounds(new Rectangle(5,65,335,420));
		c.add(barraDesplazamiento);
		c.setLayout(null);
		
		
		botonCargar.setBounds(370, 65, 150, 30);
		add(botonCargar);
		
		botonSalir.setBounds(370, 115, 150, 30);
		add(botonSalir);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(580,600);
		setVisible(true);
		
		
		
		listaDirec.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				// TODO Auto-generated method stub
				if(lse.getValueIsAdjusting()) {
					ficheroSelec="";
					
					String fic=listaDirec.getSelectedValue().toString();
					
					if(listaDirec.getSelectedIndex()==0) {
						if(!fic.equals(direcInicial)) {
							try {
								cliente.changeToParentDirectory();
								direcSelec=cliente.printWorkingDirectory();
								FTPFile[] ff2=null;
								
								cliente.changeWorkingDirectory(direcSelec);
								ff2=cliente.listFiles();
								campo.setText("");
								
								llenarLista(ff2,direcSelec);
							} catch (IOException e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
						}else {
							if(fic.substring(0,6).equals("(DIR) ")) {
								try {
									fic=fic.substring(6);
									String direcSelec2="";
									if(direcSelec.equals("/"))
										direcSelec2=direcSelec+fic;
									else
										direcSelec2=direcSelec+"/"+fic;
									
									
										cliente.changeWorkingDirectory(direcSelec2);
										FTPFile[] ff2=cliente.listFiles();
										campo.setText("DIRECTORIO: "+fic+", "+ff2.length+" elementos");
										direcSelec=direcSelec2;
										llenarLista(ff2,direcSelec);
								} catch (IOException e2) {
									// TODO Auto-generated catch block
										e2.printStackTrace();
								}
							}else {
								ficheroSelec=direcSelec;
								if(direcSelec.equals("/"))
									ficheroSelec+=fic;
								else
									ficheroSelec+="/"+fic;
							}
						}
						campo2.setText("DIRECTORIO ACTUAL: "+direcSelec);
					}
				}
		});
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					cliente.disconnect();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				System.exit(0);
				
			}
		});
		
		botonCreaDir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonDelDir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonCargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser f=new JFileChooser();
				
				f.setFileSelectionMode(JFileChooser.FILES_ONLY);
				f.setDialogTitle("Selecciona el Fichero a SUBIR AL SERVIDOR FTP");
				
				int returnVal=f.showDialog(f, "Cargar");
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					File file=f.getSelectedFile();
					String archivo=file.getAbsolutePath();
					String nombreArchivo=file.getName();
					try {
						SubirFichero(archivo,nombreArchivo);
					} catch (IOException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
		
		botonDescargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
	private static void llenarLista(FTPFile[] files,String direc2) {
		if(files==null) return;
		
		DefaultListModel modeloLista=new DefaultListModel();
		
		listaDirec.setForeground(Color.blue);
		Font fuente=new Font("Courier", Font.PLAIN, 12);
		listaDirec.setFont(fuente);
		
		listaDirec.removeAll();
		
		try {
			cliente.changeWorkingDirectory(direc2);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		direcSelec=direc2;
		
		modeloLista.addElement(direc2);
		
		for (int i = 0; i < files.length; i++) {
			if(!(files[i].getName()).equals(".") && !(files[i].getName()).equals("..")) {
				String f=files[i].getName();
				
				if(files[i].isDirectory()) f="(DIR) "+f;
				
				modeloLista.addElement(f);
			} 
		}
		
		try {
			listaDirec.setModel(modeloLista);
		} catch (NullPointerException n) {
			;
			// TODO: handle exception
		}
	}
	
	private boolean SubirFichero(String archivo, String soloNombre) throws IOException {
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		BufferedInputStream in=new BufferedInputStream(new FileInputStream(archivo));
		boolean ok=false;
		
		cliente.changeWorkingDirectory(direcSelec);
		
		if(cliente.storeFile(soloNombre, in)) {
			String s=" "+soloNombre+" => Subido correctamente";
			campo.setText(s);
			campo2.setText("Se va a actualizar el arbol de directorios");
			JOptionPane.showMessageDialog(null, s);
			
			FTPFile[] ff2=cliente.listFiles();
			llenarLista(ff2,direcSelec);
			ok=true;
		}else
			campo.setText("No se ha podido subir el archivo: "+soloNombre);
		return ok;
	}
	
	
	public static void main(String[] args) throws SocketException, IOException {
		// TODO Auto-generated method stub
		new Ejercicio4_03();
	}

}
