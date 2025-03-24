package src.Q5_VendaKits.src;

import java.util.List;

public class App {
    public static void main(String[] args) {
        VendasFachada proc = new VendasEmMemoria();
        List<ProdutoComponent> produtos = proc.buscarProdutos();
        
        // Exibir todos os produtos e kits disponíveis
        System.out.println("Produtos disponíveis:");
        for (ProdutoComponent produto : produtos) {
            System.out.println(produto.getId() + " - " + produto.getNome() + " - R$ " + String.format("%.2f", produto.getPreco()));
        }
        System.out.println();
        
        // Criar uma venda com produtos individuais
        Venda vendaIndividual = proc.iniciarVenda();
        proc.registrarVenda(vendaIndividual, 1, 1); // 1 Caneta
        proc.registrarVenda(vendaIndividual, 2, 2); // 2 Borrachas
        System.out.println("VENDA DE PRODUTOS INDIVIDUAIS:");
        System.out.println(proc.emitirComprovante(vendaIndividual));
        System.out.println();
        
        // Criar uma venda com um kit
        Venda vendaKit = proc.iniciarVenda();
        proc.registrarVenda(vendaKit, 4, 1); // 1 Kit Escolar
        System.out.println("VENDA DE KIT ESCOLAR:");
        System.out.println(proc.emitirComprovante(vendaKit));
        System.out.println();
        
        // Criar uma venda com um kit aninhado
        Venda vendaKitCompleto = proc.iniciarVenda();
        proc.registrarVenda(vendaKitCompleto, 5, 1); // 1 Kit Completo
        System.out.println("VENDA DE KIT COMPLETO (COM KIT ANINHADO):");
        System.out.println(proc.emitirComprovante(vendaKitCompleto));
    }
}