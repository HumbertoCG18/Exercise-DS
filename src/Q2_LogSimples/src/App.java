package src.Q2_LogSimples.src;

public class App {
    public static void main(String[] args) throws Exception {
        LogSimples log = new LogSimples();
        log.log("Mensagem de alerta 1");
        log.log("Mensagem de alarme 23");
        log.log("Mensagem de PANICO!!");

        for(String m:log){
            System.out.println(m);
        }
    }
}
