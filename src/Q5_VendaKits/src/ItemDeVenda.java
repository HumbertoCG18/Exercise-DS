package src.Q5_VendaKits.src;

public class ItemDeVenda {
    private ProdutoComponent produto;
    private int quantidade;

    public ItemDeVenda(ProdutoComponent produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoComponent getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubTotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d x %.2f = %.2f%n", produto.getId(), produto.getNome(), quantidade, produto.getPreco(), getSubTotal());
    }
}