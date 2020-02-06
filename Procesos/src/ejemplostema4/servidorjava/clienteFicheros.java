package ejemplostema4.servidorjava;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class clienteFicheros extends JFrame implements Runnable{

	static Socket socket;
	EstructuraFicheros nodo=null;
	ObjectInputStream inObjeto;
	ObjectOutputStream outObjeto;
	EstructuraFicheros Raiz;
	
	private final Container c=getContentPane();
	
	static JTextField cab= new JTextField();
	static JTextField cab2= new JTextField();
	static JTextField cab3= new JTextField();
	
	private static JTextField campo=new JTextField();
	private static JTextField campo2=new JTextField();
	
	JButton botonCargar=new JButton("Subir fichero");
	JButton botonDescargar=new JButton("Descargar fichero");
	JButton botonActualizar=new JButton("Actualizar");
	//JButton botonCreaDir=new JButton("Crear carpeta");
	//JButton botonDelDir=new JButton("Eliminar carpeta");
	JButton botonSalir=new JButton("Salir");
	static JList listaDirec=new JList();
	
	static String direcSelec="";
	static String ficheroSelec="";
	static String ficherocompleto="";
	
	public clienteFicheros(Socket s) {
		super("SERVIDOR DE FICHEROS BASICOS");
		socket =s;
		
		try {
			outObjeto=new ObjectOutputStream(socket.getOutputStream());
			inObjeto=new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(0);
		}
		
		listaDirec.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				// TODO Auto-generated method stub
				if(lse.getValueIsAdjusting()) {
					ficheroSelec="";
					ficherocompleto="";
					
					nodo=(EstructuraFicheros) listaDirec.getSelectedValue();
					if(nodo.isDir()) {
						campo.setText("FUNCION NO IMPLEMENTADA");
					}else {
						ficheroSelec=nodo.getName();
						ficherocompleto=nodo.getPath();
						campo.setText("FICHERO seleccionado: "+ficheroSelec);
						System.out.println("FICHERO seleccionado: "+ficheroSelec);
					}
				}
			}
		});
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					socket.close();
					System.exit(0);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		botonDescargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ficherocompleto.equals(""))
					return;
				PideFichero pido=new PideFichero(ficherocompleto);
				
				try {
					outObjeto.writeObject(pido);
					
					FileOutputStream fos=new FileOutputStream(ficheroSelec);
					
					Object obtengo=inObjeto.readObject();
					
					if(obtengo instanceof ObtieneFichero) {
						ObtieneFichero fic=(ObtieneFichero) obtengo;
						fos.write(fic.getContenidoFichero());
						fos.close();
						JOptionPane.showMessageDialog(null, "FICHERO DESCARGADO");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		botonActualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PideActualizacion pido=new PideActualizacion("Pruebas");
				
				try {
					outObjeto.writeObject(pido);
					
					nodo=(EstructuraFicheros) inObjeto.readObject();
					EstructuraFicheros[] lista=nodo.getLista();
					direcSelec=nodo.getPath();
					llenarLista(lista,nodo.getNumeFich());
					campo2.setText("Numero de ficheros en el directorio: "+lista.length);
					/*FileOutputStream fos=new FileOutputStream(ficheroSelec);
					
					Object obtengo=inObjeto.readObject();
					
					if(obtengo instanceof ObtieneFichero) {
						ObtieneFichero fic=(ObtieneFichero) obtengo;
						fos.write(fic.getContenidoFichero());
						fos.close();
						JOptionPane.showMessageDialog(null, "FICHERO DESCARGADO");
					}*/
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		botonCargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser f= new JFileChooser();
				f.setFileSelectionMode(JFileChooser.FILES_ONLY);
				f.setDialogTitle("Selecciona el Fichero a SUBIR AL SERVIDOR");
				int returnVal=f.showDialog(f, "Cargar");
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					File file=f.getSelectedFile();
					String archivo=file.getAbsolutePath();
					String nombreArchivo=file.getName();
					BufferedInputStream in;
					
					try {
						in=new BufferedInputStream(new FileInputStream(archivo));
						long bytes = file.length();
						byte[] buff=new byte[(int) bytes];
						int i,j=0;
						while((i=in.read())!=-1) {
							buff[j]=(byte)i;
							j++;
						}
						in.close();
						
						Object ff=new EnviaFichero(buff, nombreArchivo, direcSelec);
						
						outObjeto.writeObject(ff);
						JOptionPane.showMessageDialog(null, "FICHERO CARGADO");
						
						nodo=(EstructuraFicheros) inObjeto.readObject();
						EstructuraFicheros[] lista=nodo.getLista();
						direcSelec=nodo.getPath();
						llenarLista(lista,nodo.getNumeFich());
						campo2.setText("Numero de ficheros en el directorio: "+lista.length);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
		
		listaDirec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane barraDesplazamiento=new JScrollPane(listaDirec);
		barraDesplazamiento.setPreferredSize(new Dimension(335,420));
		barraDesplazamiento.setBounds(new Rectangle(5,65,335,420));
		c.add(barraDesplazamiento);
		c.setLayout(null);
		
		botonCargar.setBounds(370, 65, 150, 30);
		add(botonCargar);
		
		botonDescargar.setBounds(370, 115, 150, 30);
		add(botonDescargar);
		
		botonActualizar.setBounds(370, 165, 150, 30);
		add(botonActualizar);/*
		
		botonCreaDir.setBounds(370, 215, 150, 30);
		add(botonCreaDir);
		
		botonDelDir.setBounds(370, 265, 150, 30);
		add(botonDelDir);*/
		
		botonSalir.setBounds(370, 315, 150, 30);
		add(botonSalir);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(580,600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		int puerto=44441;
		
		Socket s=new Socket("localhost",puerto);
		clienteFicheros hiloC=new clienteFicheros(s);
		
		hiloC.setBounds(0,0,540,500);
		hiloC.setVisible(true);
		new Thread(hiloC).start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			cab.setText("Conectando con el servidor...");
			Raiz=(EstructuraFicheros) inObjeto.readObject();
			EstructuraFicheros[] nodos=Raiz.getLista();
			direcSelec=Raiz.getPath();
			llenarLista(nodos, Raiz.getNumeFich());
			cab3.setText("RAIZ: "+direcSelec);
			cab.setText("CONECTADO AL SERVIDOR DE FICHEROS");
			campo2.setText("Numero de ficheros en el directorio: "+Raiz.getNumeFich());
		} catch (IOException e1) {
			// TODO: handle exception
			e1.printStackTrace();
			System.exit(1);
		}catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
			System.exit(1);
		}
	}
	
	
	private static void llenarLista(EstructuraFicheros[] files,int numero) {
		if(numero==0) return;
		DefaultListModel modeloLista=new DefaultListModel();
		listaDirec.setForeground(Color.blue);
		Font fuente=new Font("Courier", Font.PLAIN,12);
		listaDirec.setFont(fuente);
		listaDirec.removeAll();
		
		for (int i = 0; i < files.length; i++) {
			modeloLista.addElement(files[i]);
			
			try {
				listaDirec.setModel(modeloLista);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
		}
	}

}
