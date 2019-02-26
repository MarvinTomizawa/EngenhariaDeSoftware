package aula04;

public class Pessoa {

	public static Pessoa of(String nome, int idade) {
		Pessoa pessoa = new Pessoa();
		pessoa.nome = nome;
		pessoa.idade = idade;
		return pessoa;
	}
	
	private int idade;
	private String nome;
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
