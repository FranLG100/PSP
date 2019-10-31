package ejemplostema2parte2;

public class BloqueoHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//DE ESTA FORMA, NO SE SINCRONIZAN
		//SUELE SALIR AAAAAAAAABBBBBBBBB
		//PERO QUEREMOS QUE SALGA ABABABABAB
		ObjetoCompartido com=new ObjetoCompartido();
		HiloCadena a=new HiloCadena(com, " A ");
		HiloCadena b=new HiloCadena(com, " B ");
		
		//De esta forma, al lanzar wait y notify, SI se van alternando
		HiloCadenaNotify an=new HiloCadenaNotify(com, " A ");
		HiloCadenaNotify bn=new HiloCadenaNotify(com, " B ");
		
		//a.start();
		//b.start();
		
		an.start();
		bn.start();
	}

}
