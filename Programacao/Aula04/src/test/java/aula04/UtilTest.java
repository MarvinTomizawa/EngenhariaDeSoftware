package aula04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilTest {
	int[] idades = {};
	int[] notas = {};
	@Test
	private void retornaMaiorValor() {
		int maiorIdade = Util.recuperarMaiorValor(idades);
		int maiorNota = Util.recuperarMaiorValor(notas);
		
		assertEquals(100, maiorIdade);
		assertEquals(100, maiorNota);
	}
}
