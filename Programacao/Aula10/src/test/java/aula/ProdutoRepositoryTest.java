package aula;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoRepositoryTest {
	private Produto produto1 = new Produto("Pokemon", "1");
	private Produto produto2 = new Produto("Digimon", "2");
	
	@Test
	public void deveAdicionarUmProduto() {
		ProdutoRepository produtoRepository = new ProdutoRepository();
		produtoRepository.add(produto1);
		produtoRepository.add(produto2);
		
		Assert.assertEquals(2,produtoRepository.getAll().size());
		
		ProdutoRepository produtoRepository2 = new ProdutoRepository();
		produtoRepository2.add(produto1);
		
		Assert.assertEquals(1,produtoRepository2.getAll().size());
	}
	
	@Test
	public void deveRemoverUmProduto() {
		ProdutoRepository produtoRepository = new ProdutoRepository();
		produtoRepository.add(produto1);
		produtoRepository.add(produto2);
		produtoRepository.remove(produto1);
		
		Assert.assertEquals(1,produtoRepository.getAll().size());
		Assert.assertEquals("2",produtoRepository.getAll().get(0).getCodigo());
		
		ProdutoRepository produtoRepository2 = new ProdutoRepository();
		produtoRepository2.add(produto1);
		produtoRepository2.remove(produto1);
		
		Assert.assertEquals(0,produtoRepository2.getAll().size());
	}
	
	@Test
	public void deveRetornarUmProdutoPorCodigo() {
		ProdutoRepository produtoRepository = new ProdutoRepository();
		produtoRepository.add(produto1);
		produtoRepository.add(produto2);
		
		Assert.assertEquals(produto1, produtoRepository.findByCodigo("1"));
		Assert.assertEquals(produto2, produtoRepository.findByCodigo("2"));
		
		ProdutoRepository produtoRepository2 = new ProdutoRepository();
		produtoRepository2.add(produto1);
		
		Assert.assertNull(produtoRepository.findByCodigo("3"));	
	}
	
	@Test
	public void deveRetornarTodosOsProdutos() {
		ProdutoRepository produtoRepository = new ProdutoRepository();
		produtoRepository.add(produto1);
		produtoRepository.add(produto2);
		
		Assert.assertEquals(2, produtoRepository.getAll().size());
		Assert.assertEquals(produto1, produtoRepository.getAll().get(0));
		Assert.assertEquals(produto2, produtoRepository.getAll().get(1));
		
		ProdutoRepository produtoRepository2 = new ProdutoRepository();
		produtoRepository2.add(produto1);
		
		Assert.assertEquals(1, produtoRepository2.getAll().size());
		Assert.assertEquals(produto1, produtoRepository2.getAll().get(0));
		
	}

}
