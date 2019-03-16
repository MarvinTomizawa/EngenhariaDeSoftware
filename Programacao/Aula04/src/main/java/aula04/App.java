package aula04;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Integer[] idades = {10,20,30};
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(Pessoa.of("Ana", 10));
		pessoas.add(Pessoa.of("Bianca", 20));
		pessoas.add(Pessoa.of("Carlos", 30));
		pessoas.add(Pessoa.of("Luiz", 40));
		
		for(Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome());
		}
		System.out.println("Soma das idades: " + somaIdades(idades));
		System.out.println("Maior idade ="+ retornaMaiorIdade(idades));
	}
	
	public static Integer somaIdades(Integer[] idades) {
		int soma = 0;

		for(int x=0; x < idades.length; x++) {
			soma += idades[x];
		}
		return soma;
	}

	public static Integer retornaMaiorIdade(Integer[] idades) {
		int maior = -200000000;

		if(idades.length == 0) {
			return 0;
		}
		
		for(int x=0; x < idades.length; x++) {
			if(idades[x] > maior) {
				maior = idades[x];
			}
		}
		return maior;
	}
}