package aula05;

public class Util {
	
	public static int somar(int v1, int v2) {
		return v1+v2;
	}
	
	public static double triplo(double v1) {
		return v1 *3;
	}

	public static int contarPares(int[] array) {
		int quantidadePar = 0;
		for(int item : array) {
			if(item%2 == 0) {
				quantidadePar++;
			}
		}
		return quantidadePar;
	}
}
