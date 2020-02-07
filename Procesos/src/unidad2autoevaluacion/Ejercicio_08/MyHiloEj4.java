package unidad2autoevaluacion.Ejercicio_08;

public class MyHiloEj4 extends Thread {

	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}

	private SolicitaSuspender suspender=new SolicitaSuspender();
	public boolean parar=false;
	public int contador=0;
	public void Suspende() { suspender.set(true);}
	public void Reanuda() { suspender.set(false);}
	public void Finaliza() { this.parar=true;}
	
	public void run() {
		
			try {
				while(!parar) {
					contador++;
					sleep(1000);
					System.out.println(contador);
					suspender.esperandoParaReanudar();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("HILO FINALIZADO");
	}
	
}
