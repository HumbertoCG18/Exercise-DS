package src.Q6_JogoDeAzar.src;

import java.util.ArrayList;

public class DadoHistorico implements DadoInterface {
    private DadoInterface dado;
    private ArrayList<Integer> historico;

    public DadoHistorico(DadoInterface dado) {
        this.dado = dado;
        this.historico = new ArrayList<Integer>();
    }

    public void rolar() {
        dado.rolar();
        historico.add(getValor());
    }

    public int getValor() {
        return dado.getValor(); // Retorna o valor do dado real
    }

    public ArrayList<Integer> getHistorico() {
        return historico;
    }
}
