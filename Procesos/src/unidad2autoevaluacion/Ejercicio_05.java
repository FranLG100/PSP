package unidad2autoevaluacion;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;

public class Ejercicio_05 extends Applet implements ActionListener {

	private Graphics letra;
	private Font fuente;
	private Button b1;
	private Thread h;
	
	class MueveLetra implements Runnable {
		private Graphics g;
		private int x=1,y=100;
		private int ancho=0;
		private boolean va=true;
		private boolean moverse=true;
		
		public MueveLetra(int ancho) {
			this.ancho=ancho;
		}
		
		public void run() {
			moverse=true;
			while(moverse) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(va && moverse) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x++;
					if(x>ancho) {
						va=false;
					}
					repaint();
				}
				while(!va && moverse) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x--;
					if(x<0) {
						va=true;
					}
					repaint();
				}
				System.out.println(x);
				
			}
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public void Parar() {
			moverse=false;
		}
		
		public boolean enMovimiento() {
			return moverse;
		}
	}
	
	MueveLetra h1=new MueveLetra(599);
	
	public void start() {
		new Thread(h1).start();
	}
	//Iniciamos el applet, poniendo el tamanho de ventana, color de fondo,
		//fuente, etc.
		public void init() {
			this.setSize(600, 200);
			setBackground(Color.yellow);
			add(b1=new Button("Finalizar hilo 1"));
			b1.addActionListener(this);
			fuente=new Font("Verdana",Font.BOLD,26);
		}


		//Pintamos los datos.
		public void paint(Graphics g) {
			g.clearRect(0, 0,400,400);
			g.setFont(fuente);
			g.drawString("O", h1.getX(), h1.getY());
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				if(h1.enMovimiento())
					h1.Parar();
				else {
					h=new Thread(h1);
					h.start();
				}
		}
		
		
		public void stop() {
			h1=null;
		}
}
