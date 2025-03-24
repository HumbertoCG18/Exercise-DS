public class Validador {
    public enum Tipo { EMAIL, INTEIRO, MATRICULA, CPF }
    
    private ValidatorFactory factory;
    
    public Validador() {
        factory = ValidatorFactory.getInstance();
    }
    
    public boolean valida(Tipo tipo, String valor) {
        Validator validator = factory.getValidator(tipo.name());
        return validator.validate(valor);
    }
    
    // For backward compatibility
    public boolean valida(String tipo, String valor) {
        if (factory.isTypeSupported(tipo)) {
            Validator validator = factory.getValidator(tipo);
            return validator.validate(valor);
        }
        return false;
    }
}