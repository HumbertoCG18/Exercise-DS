import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {
    private static ValidatorFactory instance;
    private Map<String, Validator> validators;
    
    private ValidatorFactory() {
        validators = new HashMap<>();
        // Register default validators
        registerValidator(new EmailValidator());
        registerValidator(new IntegerValidator());
        registerValidator(new MatriculaValidator());
        registerValidator(new CPFValidator());
    }
    
    public static ValidatorFactory getInstance() {
        if (instance == null) {
            instance = new ValidatorFactory();
        }
        return instance;
    }
    
    public void registerValidator(Validator validator) {
        validators.put(validator.getType(), validator);
    }
    
    public Validator getValidator(String type) {
        Validator validator = validators.get(type);
        if (validator == null) {
            throw new IllegalArgumentException("Validator type not supported: " + type);
        }
        return validator;
    }
    
    public boolean isTypeSupported(String type) {
        return validators.containsKey(type);
    }
    
    public String[] getSupportedTypes() {
        return validators.keySet().toArray(new String[0]);
    }
}