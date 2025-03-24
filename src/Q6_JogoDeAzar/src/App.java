package src.Q6_JogoDeAzar.src;

public class App {
    public static void main(String[] args) {
        Dado d6 = new Dado(6);
        DadoHistorico d20 = new DadoHistorico(new Dado(20));
        d6.rolar();
        //rolar o dado 10 vezes
        for(int i = 0; i < 10; i++) {
            d20.rolar();
        }
        System.out.println("D6: " + d6.getValor());
        System.out.println("D20: " + d20.getValor());
        System.out.println("D20 depois de 10 roles: " + d20.getHistorico());
    }
}
