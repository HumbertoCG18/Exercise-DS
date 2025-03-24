public interface CodificadorStrategy {
    String codificar(String texto);
    String decodificar(String texto);
    String getNome();
}