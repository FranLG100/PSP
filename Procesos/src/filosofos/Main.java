package filosofos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Filosofo> filosofosL=new ArrayList<Filosofo>();
		Silla s=new Silla();
		Contador c;
		Tenedor[] tenedores=new Tenedor[5];
		for (int i = 0; i < tenedores.length; i++) {
			tenedores[i]=new Tenedor(i);
		}
		
		Filosofo[] filosofos=new Filosofo[5];
		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i]=new Filosofo(i, tenedores[i], tenedores[(i+1)%5],s);
			filosofosL.add(filosofos[i]);
		}
		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i].start();
		}
		c=new Contador(filosofosL);
		c.start();
	}

}
