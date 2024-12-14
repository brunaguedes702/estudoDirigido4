import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PedidoIntegrationTest {

    private Catalogo catalogo;
    private Pedido pedido;

    @Before
    public void setUp() {
        catalogo = new Catalogo();
        pedido = new Pedido("Cliente Teste");
    }

    @Test
    public void testFluxoCompletoDePedido() {
        // 1️⃣ Criar produtos simulados
        Produto produto1 = new Produto(1, "Teclado", 50.0f);
        Produto produto2 = new Produto(2, "Mouse", 60.0f);
        Produto produto3 = new Produto(3, "Monitor", 200.0f);

        // 2️⃣ Adicionar produtos ao catálogo
        catalogo.adicionarProduto(produto1);
        catalogo.adicionarProduto(produto2);
        catalogo.adicionarProduto(produto3);


        System.out.println("Produtos adicionados ao catálogo!");

        // 3️⃣ Verificar se os produtos foram adicionados corretamente
        List<Produto> produtosDoCatalogo = catalogo.listarProdutos();
        assertEquals(3, produtosDoCatalogo.size());

        // 4️⃣ Simular busca de produto por ID
        Produto produtoEncontrado = catalogo.buscarProdutoPorId(2);
        assertNotNull(produtoEncontrado);
        assertEquals("Mouse", produtoEncontrado.getNome());

        // 5️⃣ Criar um pedido e adicionar produtos
        pedido.adicionarProduto(produto1); // 50.0
        pedido.adicionarProduto(produto2); // 60.0
        pedido.adicionarProduto(produto3); // 200.0

        // 6️⃣ Verificar se os produtos foram adicionados ao pedido
        assertEquals(3, pedido.getProdutos().size());

        // 7️⃣ Calcular o total do pedido (aplicando o desconto)
        float totalEsperado = (50.0f + 60.0f + 200.0f) * 0.9f; // Desconto de 10%
        float totalCalculado = pedido.calcularTotal();
        assertEquals(totalEsperado, totalCalculado, 0.01f);
    }

    @Test
    public void testVerificarInteracoesComMockito() {
        // 1️⃣ Criar mock do catálogo
        Catalogo mockCatalogo = mock(Catalogo.class);

        // 2️⃣ Configurar o comportamento do mock
        Produto produtoSimulado = new Produto(4, "Webcam", 80.0f);
        when(mockCatalogo.buscarProdutoPorId(4)).thenReturn(produtoSimulado);

        // 3️⃣ Buscar o produto
        Produto produtoEncontrado = mockCatalogo.buscarProdutoPorId(4);

        // 4️⃣ Verificar interações
        assertNotNull(produtoEncontrado);
        assertEquals("Webcam", produtoEncontrado.getNome());
        assertEquals(80.0f, produtoEncontrado.getPreco(), 0.01f);

        // 5️⃣ Verificar se o metodo foi chamado certo
        verify(mockCatalogo, times(1)).buscarProdutoPorId(4);
    }
}

