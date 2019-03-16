package aula02;

import java.util.Scanner;

public class App {

	private static int quantidade = 10;
	
	public static void main(String[] args) {
		int input = 1;
		
		Scanner scanner = new Scanner(System.in);
		while(input % 2 != 0) {
			System.out.println("Informe um numero par:");
			input = scanner.nextInt();
		}
		System.out.println("Fim do programa1");
		
		
		System.out.println("Informe um numero par:");
		input = scanner.nextInt();
		
		if(input % 2 == 0) {
			System.out.println("Numero par");
		}else {
			System.out.println("Numero impar");
		}
		
		
		
	}

	public static int getQuantidade() {
		return quantidade;
	}
	
	public static void setQuantidade() {
		System.out.println("Digite um inteiro:");
		Scanner scanner = new Scanner(System.in);
		
		quantidade = scanner.nextInt();
		scanner.close();
	}
	
	public static void contarAte10() {
		setQuantidade();
		
		for(int x = 1; x <= getQuantidade(); x++) {
			System.out.println("Numero =" + x);
		}
		System.out.println("");
		
		int x = 0;
		
		while(x < getQuantidade()) {
			x++;
			System.out.println("Numero =" + x);
		}
		
		System.out.println("");
		
		x = 0;
		do{
			x++;
			System.out.println("Numero =" + x);
		}while(x < getQuantidade());
	}
}
