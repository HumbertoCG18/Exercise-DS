public interface Observador{
    void atualizar(FonteDeDados fonte);
    void ligar();
    void desligar();
    boolean estaLigado();    
}