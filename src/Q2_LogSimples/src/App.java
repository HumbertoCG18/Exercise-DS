package src.Q2_LogSimples.src;

public class App {
    public static void main(String[] args) throws Exception {
        // Get the singleton instance
        LogSimples log = LogSimples.getInstance();
        log.log("Mensagem de teste");

        // Both threads now use the same log instance
        new Thread(() -> {
            LogSimples log2 = LogSimples.getInstance();
            for(int i=0;i<10;i++){
                log2.log("mensagem em thread 1 - "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            LogSimples log2 = LogSimples.getInstance();
            for(int i=0;i<10;i++){
                log2.log("mensagem em thread 2 - "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        // Add another separate part of the code getting the same instance
        Thread.sleep(2000);
        LogSimples logAnotherInstance = LogSimples.getInstance();
        logAnotherInstance.log("Esta mensagem vem de outra parte da aplicação");
        
        // Demonstrate that any attempt to create new instances actually returns the singleton
        LogSimples log3 = LogSimples.getInstance();
        LogSimples log4 = LogSimples.getInstance();
        log3.log("Usando log3");
        log4.log("Usando log4 - observe o valor sequencial do contador");
    }
}