package procesos;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.*;

class BounceFrame extends JFrame {
	public BounceFrame() {
		setSize(500, 400);
//Gestión de los eventos de ventana
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container contentPane = getContentPane();
		panelDibujar = new JPanel();
		contentPane.add(panelDibujar, BorderLayout.CENTER);
		JPanel panelSur = new JPanel();
		JButton botonAnimar = new JButton("Animar");
		panelSur.add(botonAnimar);
		botonAnimar.addActionListener(new ActionListener() {
//Dibujamos la pelotita y la hacemos rebotar
			public void actionPerformed(ActionEvent evt) {
				Pelotita b = new Pelotita(panelDibujar, Color.black);
				b.rebotar();
			}
		});
		JButton botonDetener = new JButton("Detener");
		panelSur.add(botonDetener);
		botonDetener.addActionListener(new ActionListener() {

//Al pulsar este botón detenemos la animación y terminamos la máquina Virtual.
//Como sólo empleamos un thread comprobaremos que el botón no responde hasta que la pelotita
//para de moverse.
			public void actionPerformed(ActionEvent evt) {
				panelDibujar.setVisible(false);
				System.exit(0);
			}
		});
		contentPane.add(panelSur, "South");
	}

	private JPanel panelDibujar;
}
