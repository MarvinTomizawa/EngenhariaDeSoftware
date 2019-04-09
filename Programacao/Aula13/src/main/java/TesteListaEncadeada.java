import org.junit.Assert;
import org.junit.Test;

public class TesteListaEncadeada {
	@Test
	public void deveAdicionar() {
		ListaEncadeada<String> lista = new ListaEncadeada<String>();
		lista.adicionar(new String("Oi"));
		Assert.assertEquals(1, lista.obterTamanho());
		Assert.assertEquals("Oi", lista.pegar(0));
		
		lista.adicionar(new String("TCHAU"));
		Assert.assertEquals(2, lista.obterTamanho());
		Assert.assertEquals("TCHAU", lista.pegar(1));
	}
	
	@Test
	public void deveObterTamanho() {
		ListaEncadeada<String> lista = new ListaEncadeada<String>();
		Assert.assertEquals(0, lista.obterTamanho());
		
		lista.adicionar(new String("Oi"));
		lista.adicionar(new String("Oi"));
		Assert.assertEquals(2, lista.obterTamanho());
		
		lista.adicionar(new String("Oi"));
		Assert.assertEquals(3, lista.obterTamanho());
	}
	
	@Test
	public void devePegar() {
		ListaEncadeada<String> lista = new ListaEncadeada<String>();
		lista.adicionar(new String("Oi"));
		lista.adicionar(new String("TCHAU"));
		Assert.assertEquals("Oi", lista.pegar(0));
		Assert.assertEquals("TCHAU", lista.pegar(1));
		
		lista.adicionar(new String("HEHEHE"));
		Assert.assertEquals("HEHEHE", lista.pegar(2));
	}
}
