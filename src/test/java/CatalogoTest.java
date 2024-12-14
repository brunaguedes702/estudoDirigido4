import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CatalogoTest {

    private Catalogo catalogo;

    @Before
    public void setUp() {
        catalogo = new Catalogo();
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto(1, "Notebook", 3000.0f);
        catalogo.adicionarProduto(produto);

        List<Produto> produtos = catalogo.listarProdutos();
        assertEquals(1, produtos.size());
        assertEquals("Notebook", produtos.get(0).getNome());
    }

    @Test
    public void testListarProdutos() {
        Produto produto1 = new Produto(1, "Tablet", 2000.0f);
        Produto produto2 = new Produto(2, "Teclado", 150.0f);

        catalogo.adicionarProduto(produto1);
        catalogo.adicionarProduto(produto2);

        List<Produto> produtos = catalogo.listarProdutos();
        assertEquals(2, produtos.size());
    }

    @Test
    public void testBuscarProdutoPorId() {
        Produto produto1 = new Produto(1, "Monitor", 800.0f);
        Produto produto2 = new Produto(2, "Mouse", 50.0f);

        catalogo.adicionarProduto(produto1);
        catalogo.adicionarProduto(produto2);

        Produto produtoBuscado = catalogo.buscarProdutoPorId(2);
        assertNotNull(produtoBuscado);
        assertEquals("Mouse", produtoBuscado.getNome());
    }

    @Test
    public void testBuscarProdutoPorIdNaoExistente() {
        Produto produto1 = new Produto(1, "Fone de Ouvido", 250.0f);
        catalogo.adicionarProduto(produto1);

        Produto produtoBuscado = catalogo.buscarProdutoPorId(99);
        assertNull(produtoBuscado); // O ID 99 não foi adicionado
    }
}

