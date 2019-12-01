package unidad3autoevaluacion.Actividad_07.controlador;

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

import ejerciciostema3parte2.ejercicio3_10.vista.Vista;
import unidad3autoevaluacion.Actividad_06.vista.VistaPremios;
import unidad3autoevaluacion.Actividad_07.JugadorAdivina;
import unidad3autoevaluacion.Actividad_07.vista.VistaMastermind;

public class Controlador implements ActionListener, MouseListener {

	private VistaMastermind vista;
	private JugadorAdivina jugador;
	private boolean primeraVez=false;
	
	public enum AccionMVC {
		__PRUEBA, __SALIR}
	
	public Controlador(VistaMastermind vista, JugadorAdivina jugador) {
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
		
		this.vista.btnSalir.setActionCommand("__SALIR");
		this.vista.btnSalir.addActionListener(this);
		
		jugador.Conectar();
		this.vista.campoID.setText(Integer.toString(jugador.getIdentificador()));
		this.vista.campoIntentos.setText("0");
		//System.out.println(jugador.getDatos());
		this.vista.campoResultado.setText("Adivina nuestro numero");
		if(!jugador.isJuega()) {
			this.vista.btnAdivinar.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __PRUEBA:
			if(primeraVez && jugador.getDatos().getIntentos()>9) {
				JOptionPane.showMessageDialog(null, "Ha alcanzado el maximo numero de intentos");
			}else {
				try {
					jugador.EnviarNumero(this.vista.campoAdivinar1.getText(),this.vista.campoAdivinar2.getText(),this.vista.campoAdivinar3.getText(),this.vista.campoAdivinar4.getText());
					primeraVez=true;
					String cadena=this.vista.campoResultado.getText();
					String cadena2=this.vista.campoResultado2.getText();
					this.vista.campoResultado.setText(cadena+"\n"+jugador.getCadena()[0]);
					this.vista.campoResultado2.setText(cadena2+"\n"+jugador.getCadena()[1]);
					this.vista.campoIntentos.setText(Integer.toString(jugador.getDatos().getIntentos()));
					if(!jugador.getDatos().isJuega()) {
						this.vista.btnAdivinar.setEnabled(false);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break;
		case __SALIR:
			try {
				jugador.Cerrar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
