package aula;

public class Produto {
	private String descricao;
	private String codigo;
	
	public Produto(String descricao, String codigo){
		this.descricao = descricao;
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
}
