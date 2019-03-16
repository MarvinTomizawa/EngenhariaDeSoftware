package aula;

public class ItemPedido {
	private Produto produto;
	private double preco;
	private double quantidade;
	private double descontoPercentual;
	
	public ItemPedido(Produto produto,double preco,double quantidade,double descontoPercentual) {
		this.produto = produto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descontoPercentual = descontoPercentual;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public double getDescontoPercentual() {
		return descontoPercentual;
	}
	
}
