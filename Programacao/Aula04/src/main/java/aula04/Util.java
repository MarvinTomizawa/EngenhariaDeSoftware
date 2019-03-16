package aula04;

public class Util {
	public static Integer recuperarMaiorValor(int[] valores){
		int maiorValor = -200000;
		
		for(int x =0; x<valores.length; x++ ) {
			if(valores[x] > maiorValor) {
				maiorValor = valores[x];
			}
		}
		
		return maiorValor;
	}
}
