package src.Q2_LogSimples.src;

public class LogSimples {
    private int contador = 0;
    
    // Static instance for Singleton pattern
    private static LogSimples instance;
    
    // Private constructor to prevent instantiation from outside
    private LogSimples() {}
    
    // Thread-safe singleton implementation using double-checked locking
    public static LogSimples getInstance() {
        if (instance == null) {
            synchronized (LogSimples.class) {
                if (instance == null) {
                    instance = new LogSimples();
                }
            }
        }
        return instance;
    }
    
    public void log(String mensagem) {
        System.out.println("[LOG] " + contador + " - " + mensagem);
        contador++;
    }
}