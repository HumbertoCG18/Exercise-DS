public class CodificadorInverso implements CodificadorStrategy {

    @Override
    public String codificar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }

    @Override
    public String decodificar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }

    @Override
    public String getNome() {
        return "Codificador Inverso";
    }
}