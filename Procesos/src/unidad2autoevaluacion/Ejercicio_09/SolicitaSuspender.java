package unidad2autoevaluacion.Ejercicio_09;

public class SolicitaSuspender {

	private boolean suspender;
	
	public synchronized void set(boolean b) {
		suspender = b;
		notifyAll();
	}
	
	public synchronized void esperandoParaReanudar(int tiempo) throws InterruptedException {
		while(suspender) {
			wait(tiempo);
			suspender=false;
		}
	}
}
