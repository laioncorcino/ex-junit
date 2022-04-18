import carrinho.Carrinho;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {

    @Test
    @DisplayName("Deve criar carrinho vazio")
    public void deveCriarUmCarrinhoVazio() {
        Carrinho carrinho = new Carrinho();
        assertTrue(carrinho.getItems().isEmpty());
    }

    @Test
    @DisplayName("Deve adicionar itens no carrinho")
    public void deveAdicionarItensNoCarrinho() {
        Carrinho carrinho = new Carrinho();
        carrinho.addItem(new Produto("TV Samsung", 1700.0));

        assertFalse(carrinho.getItems().isEmpty());
        assertEquals(carrinho.getQtdeItems(), 1);
    }

    @Test
    @DisplayName("Deve remover itens no carrinho")
    public void deveRemoverItensNoCarrinho() throws ProdutoNaoEncontradoException {
        Carrinho carrinho = new Carrinho();
        Produto tv_samsung = new Produto("TV Samsung", 1700.0);
        Produto geladeira_consul = new Produto("Geladeira Consul", 2300.0);
        carrinho.addItem(tv_samsung);
        carrinho.addItem(geladeira_consul);

        assertFalse(carrinho.getItems().isEmpty());
        assertEquals(carrinho.getQtdeItems(), 2);

        carrinho.removeItem(tv_samsung);

        assertFalse(carrinho.getItems().isEmpty());
        assertEquals(carrinho.getQtdeItems(), 1);
    }

    @Test
    @DisplayName("Deve lancar exception ao tentar remover produto que nao existe")
    public void deveLancarExceptionAoRemoverProdutoInexistenteCarrinho() {
        Carrinho carrinho = new Carrinho();

        Produto tv_samsung = new Produto("TV Samsung", 1700.0);
        Produto geladeira_consul = new Produto("Geladeira Consul", 2300.0);

        carrinho.addItem(tv_samsung);
        carrinho.addItem(geladeira_consul);

        assertFalse(carrinho.getItems().isEmpty());
        assertEquals(carrinho.getQtdeItems(), 2);

        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(new Produto("Fogão 4 bocas", 870.0)));
    }

    @Test
    @DisplayName("Deve esvaziar itens do carrinho")
    public void deveEsvaziarIntensDoCarrinho() {
        Carrinho carrinho = new Carrinho();

        Produto tv_samsung = new Produto("TV Samsung", 1700.0);
        Produto geladeira_consul = new Produto("Geladeira Consul", 2300.0);

        carrinho.addItem(tv_samsung);
        carrinho.addItem(geladeira_consul);

        assertFalse(carrinho.getItems().isEmpty());
        assertEquals(carrinho.getQtdeItems(), 2);

        carrinho.esvazia();

        assertTrue(carrinho.getItems().isEmpty());
    }

    @Test
    @DisplayName("Deve calcular total do carrinho")
    public void deveCalcularTotalDoCarrinho() {
        Carrinho carrinho = new Carrinho();

        carrinho.addItem(new Produto("TV Samsung", 1700.0));
        carrinho.addItem(new Produto("Geladeira Consul", 2300.0));

        assertFalse(carrinho.getItems().isEmpty());
        assertEquals(carrinho.getQtdeItems(), 2);
        assertEquals(carrinho.getValorTotal(), 4000.0);
    }

}
