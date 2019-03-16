package br.com.unicesumar.aula03.br.com.unicesumar.aula03;

import java.util.Scanner;

public class Aula03Application {

	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {	
		boolean ganhabem = 5000.33 < obterSalario(40);
		System.out.println(ganhabem);
		System.out.println(obterSalario(40));
	}
	
	public static double obterSalario(int idade) {
		double salario = 1000;
		idade = idade - 18;
		
		if(idade < 18) {
			return 0;
		}
		
		return (salario * idade) < 10000 ? (salario * idade) : 10000; 
	}

}
