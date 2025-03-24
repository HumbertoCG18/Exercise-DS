import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var dados = new FonteDeDados();
        
        // Criar visualizadores
        var visSomatorio = new VisualizadorDeSomatorio();
        var visMedia = new VisualizadorDeMedia();
        var visMaximo = new VisualizadorDeMaximo();
        
        // Registrar visualizadores (todos começam desligados)
        dados.adicionarObservador(visSomatorio);
        dados.adicionarObservador(visMedia);
        dados.adicionarObservador(visMaximo);
        
        Scanner s = new Scanner(System.in);
        int valor = 0;
        
        System.out.println("Digite valores inteiros positivos (ou -1 para ligar/desligar o visualizador de somatório, -2 para média, -3 para máximo, 0 para sair):");
        
        while (true) {
            System.out.println("\nEntre um valor positivo maior que zero, ou:");
            System.out.println("-1 = ligar/desligar visualizador de somatório");
            System.out.println("-2 = ligar/desligar visualizador de média");
            System.out.println("-3 = ligar/desligar visualizador de máximo");
            System.out.println("0 = sair");
            
            valor = Integer.parseInt(s.nextLine());
            
            if (valor == 0) {
                break;
            } else if (valor == -1) {
                if (visSomatorio.estaLigado()) {
                    visSomatorio.desligar();
                    System.out.println("Visualizador de Somatório DESLIGADO");
                } else {
                    visSomatorio.ligar();
                    System.out.println("Visualizador de Somatório LIGADO");
                    // Atualiza imediatamente para mostrar o estado atual
                    if (!dados.getValores().isEmpty()) {
                        visSomatorio.atualizar(dados);
                    }
                }
            } else if (valor == -2) {
                if (visMedia.estaLigado()) {
                    visMedia.desligar();
                    System.out.println("Visualizador de Média DESLIGADO");
                } else {
                    visMedia.ligar();
                    System.out.println("Visualizador de Média LIGADO");
                    // Atualiza imediatamente para mostrar o estado atual
                    if (!dados.getValores().isEmpty()) {
                        visMedia.atualizar(dados);
                    }
                }
            } else if (valor == -3) {
                if (visMaximo.estaLigado()) {
                    visMaximo.desligar();
                    System.out.println("Visualizador de Máximo DESLIGADO");
                } else {
                    visMaximo.ligar();
                    System.out.println("Visualizador de Máximo LIGADO");
                    // Atualiza imediatamente para mostrar o estado atual
                    if (!dados.getValores().isEmpty()) {
                        visMaximo.atualizar(dados);
                    }
                }
            } else if (valor > 0) {
                try {
                    dados.add(valor);
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else {
                System.out.println("Valor inválido. Por favor, tente novamente.");
            }
        }
        
        System.out.println("Fim");
        s.close();
    }
}