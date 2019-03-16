package aula;

public class Livro {
	private String nome;
	private int quantidadeDePaginas;
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantidadeDePaginas() {
		return quantidadeDePaginas;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof Livro)) {
			return false;
		}
		
		Livro livro = (Livro) obj;
		
		return livro.getNome() == this.nome && livro.getQuantidadeDePaginas() == this.quantidadeDePaginas;
	}
}
