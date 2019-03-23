package aula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoRepository {
	Set<Produto> produtos = new HashSet<Produto>();

	public void add(Produto produto) {
		this.produtos.add(produto);
	}

	public void remove(Produto produto) {
		this.produtos.remove(produto);
	}

	public List<Produto> getAll() {
		return Collections.unmodifiableList(new ArrayList<Produto>(this.produtos));

	}

	public Produto findByCodigo(String codigo) {
		for (Produto produto : produtos) {
			if (produto.getCodigo().equals(codigo)) {
				return produto;
			}
		}
		return null;
	}
}
