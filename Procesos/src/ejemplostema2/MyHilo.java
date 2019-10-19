package ejemplostema2;

public class MyHilo extends Thread {

	private SolicitaSuspender suspender=new SolicitaSuspender();
	
	public void Suspende() { suspender.set(true);}
	public void Reanuda() { suspender.set(false);}
	
	public void run() {
		
			try {
				while(true) {
					suspender.esperandoParaReanudar();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
