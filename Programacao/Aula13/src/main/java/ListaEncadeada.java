import java.util.Optional;

public class ListaEncadeada<TIPO_DO_ELEMENTO> {
	private ItemLista primeiro;
	
	public void adicionar(TIPO_DO_ELEMENTO item) {
		if(Optional.ofNullable(primeiro).isPresent()) {
			this.primeiro.adicinarNaLista(item);
		}else {
			this.primeiro = new ItemLista<TIPO_DO_ELEMENTO>(item);
		}	
	}

	public int obterTamanho() {
		if(Optional.ofNullable(primeiro).isPresent()) {
			return this.primeiro.obterTamanho();
		}
		
		return 0;
	}
	

	public TIPO_DO_ELEMENTO pegar(int posicao) {
		if(posicao -1 > obterTamanho()) {
			throw new RuntimeException("Tamanho maior que o que existe");
		}
		return (TIPO_DO_ELEMENTO) this.primeiro.pegar(posicao);
		
	}
	
	private class ItemLista<TIPO>{
		private TIPO item;
		private ItemLista<TIPO> proximo;
	
		public ItemLista(TIPO item) {
			this.item = item;
		}
		
		public void adicinarNaLista(TIPO item) {
			if(Optional.ofNullable(this.proximo).isPresent()) {
				this.proximo.adicinarNaLista(item);
			}else {
				this.proximo = new ItemLista<TIPO>(item);
			}
		}
		
		public int obterTamanho() {
			if(Optional.ofNullable(this.proximo).isPresent()) {
				return proximo.obterTamanho() + 1;
			}
			return 1;
		}
		
		public TIPO pegar(int posicao) {
			if(posicao == 0) {
				return this.item;
			}
			
			return this.proximo.pegar(posicao -1);
		}
	}
}
