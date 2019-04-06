import java.util.Optional;

public class ListaEncadeada<TIPO> {
	
	ItemLista primeiro;
	
	public void adicionarNaLista(TIPO item) {
		if(Optional.ofNullable(item).isPresent()) {
			this.primeiro.adicinarNaLista(item);
		}else {
			this.primeiro = new ItemLista<TIPO>();
		}
		
	}
	
	private class ItemLista<TIPO>{
		public ItemLista() {
		}
		
		TIPO item;
		ItemLista<TIPO> proximo = new ItemLista<TIPO>();
		public void adicinarNaLista(TIPO item) {
			if(Optional.ofNullable(this.item).isPresent()) {
				this.proximo.adicinarNaLista(item);
			}else {
				this.item = item;
			}
		}
	}
}
