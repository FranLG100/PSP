package procesos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
* Clase auxiliar que contiene el main y permite arrancar la aplicación
*/
public class Thread2 {
public static void main (String[] args){
JFrame frame = new BounceFrame();
frame.show();
}
}
/**
* JFrame sobre el cual dibujaremos
* */
class BounceFrame extends JFrame{
public BounceFrame(){
setSize(500,400);
//Gestión de los eventos de ventana
addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
System.exit(0);
}
});
Container contentPane = getContentPane();
panelDibujar = new JPanel();
contentPane.add(panelDibujar,BorderLayout.CENTER);
JPanel panelSur = new JPanel();
JButton botonAnimar = new JButton("Animar");
panelSur.add(botonAnimar);
botonAnimar.addActionListener(new ActionListener(){
//dibujamos la pelotita y la hacemos rebotar
public void actionPerformed(ActionEvent evt){
Pelotita b = new Pelotita(panelDibujar,Color.black);
//(Thread)la hacemos rebotar

b.start();
}
});
JButton botonDetener = new JButton("Detener");
panelSur.add(botonDetener);
botonDetener.addActionListener(new ActionListener(){
//Al pulsar este botón detenemos la animación y terminamos la máquina Virtual.
//Como sólo empleamos un thread comprobamos que el botón no responde hasta que la pelotita
//para de moverse.
public void actionPerformed (ActionEvent evt){
panelDibujar.setVisible(false);
System.exit(0);
}
});
contentPane.add(panelSur,"South");
}
private JPanel panelDibujar;
}

class Pelotita extends Thread{
public Pelotita (JPanel b,Color c){
panel = b;
color = c;

}
//Dibuja la pelotita la primera vez
public void dibujarPelotita () {
Graphics g = panel.getGraphics();
g.setColor(color);
g.fillOval(posicionX,posicionY,tamanoXPelotita, tamanoYPelotita);
g.dispose();
}
public void mover(){
Graphics g = panel.getGraphics();
g.setXORMode(panel.getBackground());
g.setColor(color);
//Pintamos en las anitiguas coordenadas, borrando de ese modo la pelotita
g.fillOval(posicionX, posicionY, tamanoXPelotita, tamanoYPelotita);
//Calculamos las nuevas coordenadas posicionX += incrementoX;
posicionY +=incrementoY;
Dimension d = panel.getSize();
//Si la coordenada x es menor que 0 invertimos el incremento en la coordenada x
if (posicionX<0){
posicionX = 0;
incrementoX = -incrementoX;
}
//Si la pelotita se sale del panel por la derecha hacemos que "rebote" hacia la izquierda
if (posicionX+tamanoXPelotita>= d.width){
posicionX = d.width-tamanoXPelotita;
incrementoX = - incrementoX;
}
//Si la coordenada y es menor que 0 invertimos el incremento en la coordenada y
if(posicionY<0){
posicionY=0;
incrementoY = -incrementoY;
}
//Si la pelotita se sale del panel por abajo hacemos que "rebote" hacia arriba
if (posicionY+ tamanoYPelotita >= d.height){
posicionY = d.height-tamanoYPelotita;
incrementoY = -incrementoY;
}
g.fillOval (posicionX, posicionY, tamanoXPelotita, tamanoYPelotita);
g.dispose();
}
public void rebotar (){
dibujarPelotita();
//La pelotita se moverá 1000 veces
for (int i = 1; i<= 1000; i++){
mover();
try {
//Duerme durante 5 milisegundos el thread
//Evitando que la pelotita se mueva demasiado rápido
Thread.currentThread().sleep(5);
}
catch (InterruptedException ex) {
ex.printStackTrace();
}
}
}
//Cuerpo del Thread. No hay ningún problema por invocar a otros métodos desde el
public void run (){
//Dibujamos la pelotita
dibujarPelotita();
//La movemos 10000 veces
for (int i = 1; i<= 10000; i++){
mover();
//Entre movimiento y movimiento detenemos el Thread 1 milisegundo,
//así la pelotita no se moverá tan rápido. Para ello empleamos el
//método slep de la clase Thread, que puede lanzar una excepción,
//por lo que hemos de invocar este método dentro de un try catch.
try {
sleep(1);
}
catch (InterruptedException ex) {
}
}
}
private JPanel panel;
private static final int tamanoXPelotita = 10;
private static final int tamanoYPelotita = 10;
private int posicionX = 0;
private int posicionY = 0;
private int incrementoX = 2;
private int incrementoY = 2;
private Color color;
}