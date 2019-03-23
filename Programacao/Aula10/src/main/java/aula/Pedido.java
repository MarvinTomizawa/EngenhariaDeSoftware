package aula;

import java.util.*;

public class Pedido {
	public Pedido(int numero){
		this.numero = numero;
	}
	
	private final int numero;
	private Set<ItemPedido> itens = new HashSet<ItemPedido>();
	
	public List<ItemPedido> getItens(){
		return Collections.unmodifiableList(new ArrayList<ItemPedido>(this.itens));
	}

	public int getNumero() {
		return numero;
	}

	public double getValorTotal(){
		double somaTodosItens = 0;
		for (ItemPedido itemPedido: this.itens) {
			double precoTotal = itemPedido.getPreco() * itemPedido.getQuantidade();
			somaTodosItens +=  precoTotal - precoTotal * (itemPedido.getDescontoPercentual()/100);
		}
		return somaTodosItens;
	}

	public ItemPedido adicionarItem(Produto produto, double quantidade , double preco, double descontoPercentual) {
		ItemPedido itemPedido = new ItemPedido(produto, preco, quantidade, descontoPercentual);
		this.itens.add(itemPedido);
		return itemPedido;
	}
	
}
