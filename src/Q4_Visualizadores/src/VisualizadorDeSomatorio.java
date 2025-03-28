import java.util.List;

public class VisualizadorDeSomatorio implements Observador {
    private List<Integer> valores;
    private boolean ligado;

    public VisualizadorDeSomatorio() {
        this.ligado = false; // Começa desligado
    }

    @Override
    public void atualizar(FonteDeDados fonte) {
        this.valores = fonte.getValores();
        exibeSomatorio();
    }

    @Override
    public void ligar() {
        this.ligado = true;
    }

    @Override
    public void desligar() {
        this.ligado = false;
    }

    @Override
    public boolean estaLigado() {
        return ligado;
    }

    public void exibeSomatorio() {
        Integer soma = valores.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Somatorio: " + soma + ", quantidade de elementos analisados: " + valores.size());
    }
}