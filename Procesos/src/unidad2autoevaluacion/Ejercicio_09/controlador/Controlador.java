package unidad2autoevaluacion.Ejercicio_09.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import unidad2autoevaluacion.Ejercicio_09.Ejercicio2_4;
import unidad2autoevaluacion.Ejercicio_09.vista.Vista;

import javax.swing.JOptionPane;


public class Controlador implements ActionListener, MouseListener {

	private Vista vista;
	private Ejercicio2_4 ej;
	private Ejercicio2_4 ej2;
	private boolean primeraVez=false;
	
	public enum AccionMVC {
		__COMENZAR, __SUSPENDER,__SUSPENDER2, __REANUDAR,__REANUDAR2, __FIN}
	
	public Controlador(Vista vista, Ejercicio2_4 ej,Ejercicio2_4 ej2) {
		this.vista = vista;
		this.ej=ej;
		this.ej2=ej2;
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
		this.vista.btnComenzar.setActionCommand("__COMENZAR");
		this.vista.btnComenzar.addActionListener(this);
		
		this.vista.btnSuspender.setActionCommand("__SUSPENDER");
		this.vista.btnSuspender.addActionListener(this);
		
		this.vista.btnSuspender1.setActionCommand("__SUSPENDER2");
		this.vista.btnSuspender1.addActionListener(this);
		
		this.vista.btnReanudar.setActionCommand("__REANUDAR");
		this.vista.btnReanudar.addActionListener(this);
		
		this.vista.btnReanudar1.setActionCommand("__REANUDAR2");
		this.vista.btnReanudar1.addActionListener(this);
		
		this.vista.btnFin.setActionCommand("__FIN");
		this.vista.btnFin.addActionListener(this);
		
		this.vista.btnReanudar1.setVisible(false);
		this.vista.btnReanudar.setVisible(false);
		
		while(true) {
			this.vista.campoHilo1.setText(Integer.toString(this.ej.getValor()));
			this.vista.campoHilo2.setText(Integer.toString(this.ej2.getValor()));
		}
		/*this.vista.campoID.setText(Integer.toString(jugador.getIdentificador()));
		this.vista.campoIntentos.setText("0");
		//System.out.println(jugador.getDatos());
		this.vista.campoResultado.setText("Prueba suerte en nuestro tablero de la fortuna");
		this.vista.campoPremios.setText(Integer.toString(jugador.getPremios()));
		if(jugador.getPremios()==0) {
			this.vista.campoResultado.setText("Todos los premios han sido repartidos");
			this.vista.btnAdivinar.setEnabled(false);
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __COMENZAR:
			ej.Iniciar();
			ej2.Iniciar();
			this.vista.btnComenzar.setEnabled(false);
			break;
		case __SUSPENDER:
			try {
				ej.suspender();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case __SUSPENDER2:
			try {
				ej2.suspender();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case __REANUDAR:
			ej.reiniciar();
			break;
		case __REANUDAR2:
			ej2.reiniciar();
			break;
		case __FIN:
			ej.finalizar();
			ej2.finalizar();
			this.vista.btnReanudar.setEnabled(false);
			this.vista.btnReanudar1.setEnabled(false);
			this.vista.btnSuspender.setEnabled(false);
			this.vista.btnSuspender1.setEnabled(false);
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
