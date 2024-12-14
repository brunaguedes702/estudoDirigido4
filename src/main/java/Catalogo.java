import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Catalogo {
    static final Logger logger = Logger.getLogger(Catalogo.class.getName());
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        logger.info("Produto adicionado ao catálogo: " + produto.getNome());
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                logger.info("Produto encontrado: " + produto.getNome());
                return produto;
            }
        }
        logger.warning("Produto com ID " + id + " não encontrado no catálogo.");
        return null;
    }
}

