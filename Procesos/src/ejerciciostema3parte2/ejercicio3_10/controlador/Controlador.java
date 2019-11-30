package ejerciciostema3parte2.ejercicio3_10.controlador;

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

public class Controlador implements ActionListener, MouseListener {

	private Vista vista;
	private JugadorAdivina jugador;
	private boolean primeraVez=false;
	
	public enum AccionMVC {
		__PRUEBA}
	
	public Controlador(Vista vista, JugadorAdivina jugador) {
		this.vista = vista;
		this.jugador=jugador;
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
		this.vista.btnAdivinar.setActionCommand("__PRUEBA");
		this.vista.btnAdivinar.addActionListener(this);
		
		jugador.Conectar();
		this.vista.campoID.setText(Integer.toString(jugador.getIdentificador()));
		this.vista.campoIntentos.setText("0");
		this.vista.campoResultado.setText("Adivina un numero entre 1 y 25");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __PRUEBA:
			if(primeraVez && jugador.getDatos().getIntentos()>4) {
				JOptionPane.showMessageDialog(null, "Ha alcanzado el maximo numero de intentos");
			}else {
				try {
					jugador.EnviarNumero(this.vista.campoAdivinar.getText());
					primeraVez=true;
					this.vista.campoResultado.setText(jugador.getCadena());
					this.vista.campoIntentos.setText(Integer.toString(jugador.getDatos().getIntentos()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
