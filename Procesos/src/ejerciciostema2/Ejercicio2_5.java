package ejerciciostema2;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2_5 extends Applet implements ActionListener {
	
	class HiloContador extends Thread {
		
		boolean parar;
		long CONTADOR;
		
		public HiloContador(long cont) {
			this.CONTADOR=cont;
		}
		
		public void run() {
			// TODO Auto-generated method stub
			parar=false;
			while(!parar) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("INTERRUPCION");
				}
				repaint();
				CONTADOR++;
			}
			System.out.println("HILO FINALIZADO");
		}
		
		public long getContador() {
			return CONTADOR;
		}
		
		public void setParar() {
			this.parar=true;
		}
		
		public void interrumpir() {
			this.interrupt();
		}
	}

	private HiloContador h1=new HiloContador(100);
	private HiloContador h2=new HiloContador(28);
	private Font fuente;
	private Button b1,b2;
	
	public void start() {
		h1.start();
		h2.start();
	};

	public void init() {
		this.setSize(600, 200);
		setBackground(Color.yellow);
		add(b1=new Button("Finalizar hilo 1"));
		b1.addActionListener(this);
		add(b2=new Button("Finalizar hilo 2"));
		b2.addActionListener(this);
		fuente=new Font("Verdana",Font.BOLD,26);
	}


	public void paint(Graphics g) {
		g.clearRect(0, 0,400,400);
		g.setFont(fuente);
		g.drawString("Hilo 1: "+Long.toString((long)h1.getContador()),80,100);
		g.drawString("Hilo 2: "+Long.toString((long)h2.getContador()),80,150);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			b1.setLabel("Hilo 1 Finalizado");
			//h1.interrumpir();
			h1.setParar();
		}else {
			b2.setLabel("Hilo 2 Finalizado");
			h2.setParar();
			//h2.interrumpir();		
			}
	}
	
	public void stop() {
		h1=null;
		h2=null;
	}
}
