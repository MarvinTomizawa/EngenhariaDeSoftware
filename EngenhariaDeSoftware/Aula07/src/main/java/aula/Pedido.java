package aula;

import java.util.HashSet;
import java.util.Set;

public class Pedido {
	public Pedido(int numero){
		this.numero = numero;
	}
	
	private final int numero;
	private Set<ItemPedido> itens = new HashSet<ItemPedido>();
	
	public Set<ItemPedido> getItens(){
		return this.itens;
	}

	public ItemPedido adicionarItem(Produto produto, double quantidade , double preco, double descontoPercentual) {
		ItemPedido itemPedido = new ItemPedido(produto, preco, quantidade, descontoPercentual);
		this.itens.add(itemPedido);
		return itemPedido;
	}
	
}
