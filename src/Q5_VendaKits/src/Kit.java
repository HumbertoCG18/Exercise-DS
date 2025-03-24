package src.Q5_VendaKits.src;

import java.util.ArrayList;
import java.util.List;

public class Kit implements ProdutoComponent {
    private int id;
    private String nome;
    private List<ProdutoComponent> produtos;
    private static final double DESCONTO = 0.10;

    public Kit(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(ProdutoComponent produto) {
        produtos.add(produto);
    }

    public void removerProduto(ProdutoComponent produto) {
        produtos.remove(produto);
    }

    public List<ProdutoComponent> getProdutos() {
        return produtos;
    }

    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public double getPreco() {
        double precoTotal = 0.0;
        for (ProdutoComponent produto : produtos) {
            precoTotal += produto.getPreco();
        }
        return precoTotal * (1 - DESCONTO);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kit: ").append(nome).append(" (").append(id).append(")\n");
        for (ProdutoComponent produto : produtos) {
            sb.append("  - ").append(produto.getNome()).append(" (").append(produto.getPreco()).append(")\n");
        }
        sb.append("Preço com desconto: ").append(String.format("%.2f", getPreco()));
        return sb.toString();
    }
}