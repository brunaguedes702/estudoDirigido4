import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Pedido {
    private static final Logger logger = Logger.getLogger(Pedido.class.getName());
    private List<Produto> produtos = new ArrayList<>();
    private String cliente;

    public Pedido(String cliente) {
        this.cliente = cliente;
        logger.info("Pedido criado para o cliente: " + cliente);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        logger.info("Produto adicionado ao pedido: " + produto.getNome());
    }

    public float calcularTotal() {
        float total = 0;

        // Soma o preço de todos os produtos no pedido
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }

        logger.info("Total antes do desconto: R$ " + total);

        // Aplica desconto de 10% se o total for maior que R$ 100,00
        if (total > 100) {
            float desconto = total * 0.10f;
            total -= desconto;
            logger.info("Desconto de 10% aplicado. Valor do desconto: R$ " + desconto);
        }

        logger.info("Total final do pedido: R$ " + total);
        return total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getCliente() {
        return cliente;
    }
}
