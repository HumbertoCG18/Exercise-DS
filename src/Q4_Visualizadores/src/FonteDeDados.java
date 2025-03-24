import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FonteDeDados {
    private List<Integer> lst;
    private List<Observador> observadores;

    public FonteDeDados() {
        lst = new LinkedList<>();
        observadores = new ArrayList<>();
    }

    public void add(Integer value) {
        if (value < 0) throw new IllegalArgumentException("Valor invalido");
        lst.add(value);
        notificarObservadores();
    }

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            if (observador.estaLigado()) {
                observador.atualizar(this);
            }
        }
    }

    public int quantidade() {
        return lst.size();
    }

    public List<Integer> getValores() {
        return new ArrayList<>(lst);
    }
}