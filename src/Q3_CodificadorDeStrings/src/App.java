public class App {
    public static void main(String[] args) throws Exception {
        // Criar instâncias das estratégias
        CodificadorStrategy estrategiaSimples = new CodificadorSimples();
        CodificadorStrategy estrategiaDesloca = new CodificadorDesloca();
        CodificadorStrategy estrategiaInverso = new CodificadorInverso();

        // Criar o codificador com a estratégia padrão (Simples)
        Codificador cod = new Codificador();

        String texto = "Desafio Padrões de Projeto";
        System.out.println("Texto original: " + texto);

        // Usando a estratégia padrão (Simples)
        cod.setStrategy(estrategiaSimples);
        System.out.println("\nUsando " + cod.getStrategy().getNome() + ":");
        String codificado = cod.codifica(texto);
        System.out.println("Codificado: " + codificado);
        System.out.println("Decodificado: " + cod.deCodifica(codificado));

        // Mudando para a estratégia Desloca
        cod.setStrategy(estrategiaDesloca);
        System.out.println("\nUsando " + cod.getStrategy().getNome() + ":");
        codificado = cod.codifica(texto);
        System.out.println("Codificado: " + codificado);
        System.out.println("Decodificado: " + cod.deCodifica(codificado));

        // Mudando para a estratégia Inverso (nova)
        cod.setStrategy(estrategiaInverso);
        System.out.println("\nUsando " + cod.getStrategy().getNome() + ":");
        codificado = cod.codifica(texto);
        System.out.println("Codificado: " + codificado);
        System.out.println("Decodificado: " + cod.deCodifica(codificado));

        // Demonstrando a criação de um codificador com uma estratégia específica
        Codificador codDesloca = new Codificador(estrategiaDesloca);
        System.out.println("\nCodificador criado com " + codDesloca.getStrategy().getNome() + ":");
        codificado = codDesloca.codifica(texto);
        System.out.println("Codificado: " + codificado);
        System.out.println("Decodificado: " + codDesloca.deCodifica(codificado));
    }
}