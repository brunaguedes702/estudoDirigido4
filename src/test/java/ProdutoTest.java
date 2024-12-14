import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void testCriacaoProduto() {
        Produto produto = new Produto(1, "Smartphone", 1500.0f);

        assertEquals(1, produto.getId());
        assertEquals("Smartphone", produto.getNome());
        assertEquals(1500.0f, produto.getPreco(), 0.01f);
    }
}

