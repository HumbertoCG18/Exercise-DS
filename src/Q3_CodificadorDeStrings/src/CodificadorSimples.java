import java.util.HashMap;
import java.util.Map;

public class CodificadorSimples implements CodificadorStrategy {
    private Map<Character, Character> tabCod;
    private Map<Character, Character> tabDeCod;

    public CodificadorSimples() {
        tabCod = new HashMap<>();
        tabCod.put('a', '@');
        tabCod.put('e', '#');
        tabCod.put('i', '!');
        tabCod.put('o', '$');
        tabCod.put('u', '%');
        
        tabDeCod = new HashMap<>();
        tabDeCod.put('@', 'a');
        tabDeCod.put('#', 'e');
        tabDeCod.put('!', 'i');
        tabDeCod.put('$', 'o');
        tabDeCod.put('%', 'u');
    }

    @Override
    public String codificar(String texto) {
        char[] aux = texto.toCharArray();
        char[] resp = new char[texto.length()];
        for (int i = 0; i < aux.length; i++) {
            if (tabCod.containsKey(aux[i])) {
                resp[i] = tabCod.get(aux[i]);
            } else {
                resp[i] = aux[i];
            }
        }
        return (new String(resp));
    }

    @Override
    public String decodificar(String texto) {
        char[] aux = texto.toCharArray();
        char[] resp = new char[texto.length()];
        for (int i = 0; i < aux.length; i++) {
            if (tabDeCod.containsKey(aux[i])) {
                resp[i] = tabDeCod.get(aux[i]);
            } else {
                resp[i] = aux[i];
            }
        }
        return (new String(resp));
    }

    @Override
    public String getNome() {
        return "Codificador Simples";
    }
}