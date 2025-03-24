package src.Q6_JogoDeAzar.src;

import java.util.Random;

public class Dado {
    private int lados;
    private int valorJogada;
    private final Random random;

    public Dado(int lados) {
        this.lados = lados;
        this.random = new Random();
    }

    public void rolar() {
        valorJogada = random.nextInt(lados) + 1;
    }

    public int getValor() {
        return valorJogada;
    }
}
