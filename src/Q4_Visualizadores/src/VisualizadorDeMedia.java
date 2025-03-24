import java.util.List;

public class VisualizadorDeMedia implements Observador {
    private List<Integer> valores;
    private boolean ligado;

    public VisualizadorDeMedia() {
        this.ligado = false; // Começa desligado
    }

    @Override
    public void atualizar(FonteDeDados fonte) {
        this.valores = fonte.getValores();
        exibeMedia();
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

    public void exibeMedia() {
        double media = valores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Media: " + media + ", quantidade de elementos analisados: " + valores.size());
    }
}