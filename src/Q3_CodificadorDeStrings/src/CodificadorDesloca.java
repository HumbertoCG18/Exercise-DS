public class CodificadorDesloca implements CodificadorStrategy {

    @Override
    public String codificar(String texto) {
        char[] aux = texto.toCharArray();
        char[] resp = new char[texto.length()];
        for (int i = 0; i < aux.length; i++) {
            resp[i] = (char) (Character.valueOf(aux[i]) + 1);
        }
        return (new String(resp));
    }

    @Override
    public String decodificar(String texto) {
        char[] aux = texto.toCharArray();
        char[] resp = new char[texto.length()];
        for (int i = 0; i < aux.length; i++) {
            resp[i] = (char) (Character.valueOf(aux[i]) - 1);
        }
        return (new String(resp));
    }

    @Override
    public String getNome() {
        return "Codificador Desloca";
    }
}