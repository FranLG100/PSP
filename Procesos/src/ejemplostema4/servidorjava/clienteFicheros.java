package ejemplostema4.servidorjava;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
	JButton botonBorrar=new JButton("Eliminar fichero");
	JButton botonCreaDir=new JButton("Crear carpeta");
	JButton botonDelDir=new JButton("Eliminar carpeta");
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
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonDescargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonCargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
		
		/*botonBorrar.setBounds(370, 165, 150, 30);
		add(botonBorrar);
		
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
