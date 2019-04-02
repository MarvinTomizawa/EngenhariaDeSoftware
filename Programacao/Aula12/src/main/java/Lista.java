public class Lista {

	private Object[] dados = new Object[0];

	public void adicionar(Object elemento) {
		final int tamanhoAntigo = this.dados.length;

		Object[] novosDados = new Object[this.obterTamanho() + 1];

		for (int indice = 0; indice < tamanhoAntigo; indice++) {
			novosDados[indice] = this.dados[indice];
		}

		novosDados[tamanhoAntigo] = elemento;

		this.dados = novosDados;
	}

	public void remover(int posicao) {
		final int tamanhaAtual = dados.length;

		if (posicao < 0) {
			throw new RuntimeException("Menor que zero");
		}

		if (posicao > tamanhaAtual - 1) {
			throw new RuntimeException("Maior do que o array");
		}

		for (int indice = posicao; indice < tamanhaAtual - 1; indice++) {
			dados[indice] = dados[indice + 1];
		}

		Object[] novoArray = new Object[tamanhaAtual - 1];

		for (int indice = 0; indice < tamanhaAtual - 1; indice++) {
			novoArray[indice] = dados[indice];
		}

		dados = novoArray;
	}

	public int obterTamanho() {
		return dados.length;
	}

	public void mover(int origem, int destino) {
		Object auxiliar = this.dados[origem];
		this.dados[origem] = this.dados[destino];
		this.dados[destino] = auxiliar;

	}

	public Object pegar(int posicao) {
		return this.dados[posicao];
	}

	public Boolean estaVazia() {
		if (this.dados.length == 0) {
			return true;
		}
		return false;
	}
}
