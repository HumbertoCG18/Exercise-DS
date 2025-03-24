package src.Q5_VendaKits.src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendasEmMemoria implements VendasFachada {
    private List<ProdutoComponent> produtos;
    
    public VendasEmMemoria() {
        produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Caneta", 1.55));
        produtos.add(new Produto(2, "Borracha", 1.15));
        produtos.add(new Produto(3, "Caderno", 32.99));
        
        // Criar um kit
        Kit kitEscolar = new Kit(4, "Kit Escolar");
        kitEscolar.adicionarProduto(produtos.get(0)); // Caneta
        kitEscolar.adicionarProduto(produtos.get(1)); // Borracha
        produtos.add(kitEscolar);
        
        // Criar outro kit com o primeiro kit e um caderno
        Kit kitCompleto = new Kit(5, "Kit Completo");
        kitCompleto.adicionarProduto(kitEscolar);
        kitCompleto.adicionarProduto(produtos.get(2)); // Caderno
        produtos.add(kitCompleto);
    }
    
    @Override
    public Venda iniciarVenda() {
        return new Venda(LocalDateTime.now());
    }

    @Override
    public void registrarVenda(Venda umaVenda, int codigoProduto, int quantidade) {
        ProdutoComponent prod = produtos.stream().filter(p -> p.getId() == codigoProduto).findFirst().get();
        umaVenda.registrarVenda(prod, quantidade);
    }

    @Override
    public String emitirComprovante(Venda umaVenda) {
        return umaVenda.emitirComprovante();
    }

    @Override
    public List<ProdutoComponent> buscarProdutos() {
        return Collections.unmodifiableList(produtos);
    }
}