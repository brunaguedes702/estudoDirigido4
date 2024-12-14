import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {
    // Logger para registrar eventos importantes
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            // Configurando o Logger para gravar em um arquivo de log
            FileHandler fileHandler = new FileHandler("app.log", true); // O 'true' permite adicionar ao arquivo existente
            fileHandler.setFormatter(new SimpleFormatter()); // Formato de log simples
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.severe("Não foi possível criar o arquivo de log: " + e.getMessage());
        }

        logger.info("Aplicação iniciada");

        // 1️⃣ **Adicionar produtos ao catálogo**
        Catalogo catalogo = new Catalogo();
        Produto p1 = new Produto(1, "Teclado", 50.0f);
        Produto p2 = new Produto(2, "Mouse", 60.0f);
        Produto p3 = new Produto(3, "Monitor", 500.0f);

        catalogo.adicionarProduto(p1);
        logger.info("Produto adicionado ao catálogo: " + p1.getNome());

        catalogo.adicionarProduto(p2);
        logger.info("Produto adicionado ao catálogo: " + p2.getNome());

        catalogo.adicionarProduto(p3);
        logger.info("Produto adicionado ao catálogo: " + p3.getNome());

        // 2️⃣ **Listar produtos disponíveis no catálogo**
        System.out.println("Produtos no Catálogo:");
        catalogo.listarProdutos().forEach(produto ->
                System.out.println(produto.getId() + " - " + produto.getNome() + " - R$ " + produto.getPreco())
        );

        // 3️⃣ **Criar um pedido e adicionar produtos**
        Pedido pedido = new Pedido("Cliente1");
        logger.info("Pedido criado para o cliente: " + pedido.getCliente());

        pedido.adicionarProduto(p1);
        logger.info("Produto adicionado ao pedido: " + p1.getNome());

        pedido.adicionarProduto(p2);
        logger.info("Produto adicionado ao pedido: " + p2.getNome());

        pedido.adicionarProduto(p3);
        logger.info("Produto adicionado ao pedido: " + p3.getNome());

        // 4️⃣ **Calcular o total do pedido**
        float total = pedido.calcularTotal();
        logger.info("Total final do pedido (após desconto, se aplicável): R$ " + total);

        // 5️⃣ **Exibir o total do pedido no console**
        System.out.println("\nTotal final do pedido para " + pedido.getCliente() + ": R$ " + total);
    }
}
