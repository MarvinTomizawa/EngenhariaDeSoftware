package aula;
import org.junit.Assert;
import org.junit.Test;

public class PedidoTest {
    private final Produto produto1 = new Produto("Pokemon","1");
    private final Produto produto2 = new Produto("Digimon","2");
    @Test
    public void deveCriarUmPedido(){
        Pedido pedido1 = new Pedido(1);
        pedido1.adicionarItem(produto1,2,2.00,0);
        pedido1.adicionarItem(produto2,3,5.00,0);

        Assert.assertEquals(1,pedido1.getNumero());
        Assert.assertEquals(2,pedido1.getItens().size());

        Pedido pedido2 = new Pedido(2);
        pedido2.adicionarItem(produto1,2,2.00,0);

        Assert.assertEquals(2,pedido2.getNumero());
        Assert.assertEquals(1,pedido2.getItens().size());
    }

    @Test
    public void deveSomarTodosValores(){
        Pedido pedido1 = new Pedido(1);
        pedido1.adicionarItem(produto1,2,2.00,0);
        pedido1.adicionarItem(produto2,3,5.00,0);

        Assert.assertEquals(19,pedido1.getValorTotal(),0.001);

        Pedido pedido2 = new Pedido(2);
        pedido2.adicionarItem(produto1,2,5.00,1);

        Assert.assertEquals(9.9,pedido2.getValorTotal(),0.01);

    }
}
