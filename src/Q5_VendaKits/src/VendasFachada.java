package src.Q5_VendaKits.src;

import java.util.List;

public interface VendasFachada {
    Venda iniciarVenda();
    void registrarVenda(Venda umaVenda, int codigoProduto, int quantidade);
    String emitirComprovante(Venda umaVenda);
    List<ProdutoComponent> buscarProdutos();
}