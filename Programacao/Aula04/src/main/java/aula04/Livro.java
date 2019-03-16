package aula04;

public class Livro {

	private int quantidadeDePaginas;
	private String nomeDoAutor;
	private String titulo;
	
	public Livro(int quantidadeDePaginas, String nomeDoAutor,String titulo) {
		this.setQuantidadeDePaginas(quantidadeDePaginas);
		this.setNomeDoAutor(nomeDoAutor);
		this.setTitulo(titulo);
	}

	public int getQuantidadeDePaginas() {
		return quantidadeDePaginas;
	}

	public void setQuantidadeDePaginas(int quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public String getNomeDoAutor() {
		return nomeDoAutor;
	}

	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
