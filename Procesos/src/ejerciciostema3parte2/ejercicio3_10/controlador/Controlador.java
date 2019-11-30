package ejerciciostema3parte2.ejercicio3_10.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ejerciciostema3parte2.ejercicio3_10.vista.Vista;

public class Controlador implements ActionListener, MouseListener {

	private Vista vista;
	
	public enum AccionMVC {
		__LOGIN, __MENU_GESTION_CENTROS, __MENU_GESTION_SECCIONES, __MENU_GESTION_PROFESORES, __MENU_GESTION_GRADOS,
		__MENU_GESTION_ALUMNOS, __MENU_GESTION_ASIGNATURAS, __MENU_PRINCIPAL
		}
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}
	
	public void iniciar() {
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
		//this.vista.btnLogin.setActionCommand("__LOGIN");
		//this.vista.btnLogin.addActionListener(this);

	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __LOGIN:
			break;
		}
	}*/
	
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
