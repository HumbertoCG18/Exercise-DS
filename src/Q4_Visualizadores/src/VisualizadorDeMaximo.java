import java.util.List;
import java.util.OptionalInt;

public class VisualizadorDeMaximo implements Observador {
    private List<Integer> valores;
    private boolean ligado;

    public VisualizadorDeMaximo() {
        this.ligado = false; // Começa desligado
    }

    @Override
    public void atualizar(FonteDeDados fonte) {
        this.valores = fonte.getValores();
        exibeMaximo();
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

    public void exibeMaximo() {
        if (valores.isEmpty()) {
            System.out.println("Máximo: N/A (sem valores)");
            return;
        }
        
        OptionalInt maximo = valores.stream()
                .mapToInt(Integer::intValue)
                .max();
        
        System.out.println("Máximo: " + maximo.getAsInt() + ", quantidade de elementos analisados: " + valores.size());
    }
}