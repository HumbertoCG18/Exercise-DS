public class App {
    public static void main(String[] args) throws Exception {
        Factory factory = Factory.getInstance();
        Codificador cod = factory.getCodificador(2); // Requesting a codificador with security level 2

        System.out.println("Codificador: " + cod.getNome());
        System.out.println("Versao: " + cod.getDataCriacao());
        System.out.println("Nivel de segurança: " + cod.getNivelSeguranca());
        
        String texto = "Este e o string a ser codificado";
        String codificado = cod.codifica(texto);
        String decodificado = cod.decodifica(codificado);

        System.out.println("Texto original: " + texto);
        System.out.println("Texto codificado: " + codificado);
        System.out.println("Texto decodificado: " + decodificado);
    }
}