public class Codificador {
    private CodificadorStrategy strategy;

    public Codificador() {
        // Default strategy
        this.strategy = new CodificadorSimples();
    }

    public Codificador(CodificadorStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CodificadorStrategy strategy) {
        this.strategy = strategy;
    }

    public CodificadorStrategy getStrategy() {
        return strategy;
    }

    public String codifica(String str) {
        return strategy.codificar(str);
    }

    public String deCodifica(String str) {
        return strategy.decodificar(str);
    }
}