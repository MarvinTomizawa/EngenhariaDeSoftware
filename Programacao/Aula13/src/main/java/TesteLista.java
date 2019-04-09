import static org.junit.Assert.*;

import org.junit.Test;

public class TesteLista {
	@Test
	public void deveAdicionar() {
		Lista lista = new Lista();
		lista.adicionar(new Integer(2));
		
		assertEquals(1, lista.obterTamanho());
		
		Lista lista2 = new Lista();
		lista2.adicionar(new Integer(2));
		lista2.adicionar(new Integer(3));
		
		assertEquals(2, lista2.obterTamanho());
		assertNotEquals(3, lista2.obterTamanho());
	}
	
	@Test
	public void deveRemover() {
		Lista lista = new Lista();
		lista.adicionar(new Integer(2));
		lista.adicionar(new Integer(3));
		lista.remover(0);
		
		assertEquals(1, lista.obterTamanho());
		assertEquals(3, lista.pegar(0));
		assertNotEquals(2, lista.obterTamanho());
		
		lista.remover(0);
		assertEquals(0, lista.obterTamanho());
		
	}
	
	@Test
	public void deveObterTamanho() {
		Lista lista = new Lista();
		lista.adicionar(new Integer(2));
		lista.adicionar(new Integer(3));
		
		assertEquals(2, lista.obterTamanho());
		assertNotEquals(1, lista.obterTamanho());
		
		lista.adicionar(new Integer(4));
		lista.adicionar(new Integer(5));
		lista.remover(0);
		assertEquals(3, lista.obterTamanho());
		
	}

	@Test
	public void deveMover() {
		Lista lista = new Lista();
		lista.adicionar(new Integer(2));
		lista.adicionar(new Integer(3));
		lista.adicionar(new Integer(4));
		lista.adicionar(new Integer(5));
		lista.adicionar(new Integer(6));
		lista.mover(0, 4);
		
		assertEquals(6, lista.pegar(0));
		assertEquals(2, lista.pegar(4));
		
		lista.mover(0, 2);
		
		assertEquals(6, lista.pegar(2));
		assertEquals(4, lista.pegar(0));	
	}
	
	@Test
	public void devePegar() {
		Lista lista = new Lista();
		lista.adicionar(new Integer(5));
		lista.adicionar(new Integer(6));
		
		assertEquals(5, lista.pegar(0));	
		assertEquals(6, lista.pegar(1));	
		
		lista.adicionar(new Integer(8));
		assertEquals(8, lista.pegar(2));
	}
	
	@Test
	public void deveEstarVazia() {
		Lista lista = new Lista();
		assertTrue(lista.estaVazia());
				
		lista.adicionar(new Integer(5));
		assertFalse(lista.estaVazia());
		
		lista.remover(0);
		assertTrue(lista.estaVazia());	
		
	}
	
	
}

