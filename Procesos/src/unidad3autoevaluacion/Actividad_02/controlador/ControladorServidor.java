package unidad3autoevaluacion.Actividad_02.controlador;

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
import unidad3autoevaluacion.Actividad_02.vista.VistaServidor;

public class ControladorServidor implements ActionListener, MouseListener {

	private VistaServidor vista;
	private Servidor servidor;
	
	public enum AccionMVC {
		__ENVIAR,__SALIR}
	
	public ControladorServidor(VistaServidor vista, Servidor servidor) {
		this.vista = vista;
		this.servidor=servidor;
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __ENVIAR:
			try {
				this.servidor.enviarMsg(this.vista.campoEnviar.getText());
				String area="";
				area=this.vista.campoEnvios.getText()+"\nEnviando>>> "+this.vista.campoEnviar.getText();
				this.vista.campoEnvios.setText(area);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case __SALIR:
			this.servidor.cerrar();
			System.exit(0);
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
