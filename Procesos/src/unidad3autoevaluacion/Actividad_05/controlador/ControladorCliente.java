package unidad3autoevaluacion.Actividad_05.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JOptionPane;

import ejerciciostema3parte2.ejercicio3_10.JugadorAdivina;
import ejerciciostema3parte2.ejercicio3_10.vista.Vista;
import unidad3autoevaluacion.Actividad_02.modelo.Servidor;
import unidad3autoevaluacion.Actividad_02.vista.VistaCliente;
import unidad3autoevaluacion.Actividad_02.vista.VistaServidor;
import unidad3autoevaluacion.Actividad_05.Cliente;
import unidad3autoevaluacion.Actividad_05.vista.VistaClienteEco;

public class ControladorCliente implements ActionListener, MouseListener {

	private VistaClienteEco vista;
	private Cliente cliente;
	
	public enum AccionMVC {
		__ENVIAR,__SALIR,__LIMPIAR}
	
	public ControladorCliente(VistaClienteEco vista, Cliente cliente) {
		this.vista = vista;
		this.cliente=cliente;
	}
	
	public void iniciar() throws UnknownHostException, ClassNotFoundException, IOException {
		// Skin tipo WINDOWS
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(vista);
			vista.setVisible(true);
		} catch (UnsupportedLookAndFeelException ex) {
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		}

		// declara una acción y añade un escucha al evento producido por el componente
	
		this.vista.btnEnviar.setActionCommand("__ENVIAR");
		this.vista.btnEnviar.addActionListener(this);
		
		this.vista.btnSalir.setActionCommand("__SALIR");
		this.vista.btnSalir.addActionListener(this);
		
		this.vista.btnLimpiar.setActionCommand("__LIMPIAR");
		this.vista.btnLimpiar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __ENVIAR:
			System.out.println(this.vista.campoEnvio.getText());
			try {
				this.cliente.enviar(this.vista.campoEnvio.getText());
				this.vista.campoRecibo.setText(this.cliente.recibir());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case __SALIR:
			try {
				this.cliente.cerrar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
			break;
		case __LIMPIAR:
			this.vista.campoEnvio.setText("");
			this.vista.campoRecibo.setText("");
			break;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
