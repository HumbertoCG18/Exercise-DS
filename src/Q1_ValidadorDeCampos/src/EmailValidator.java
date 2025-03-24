public class EmailValidator implements Validator {
    @Override
    public boolean validate(String value) {
        int posA = value.indexOf('@');
        int posPt = value.indexOf('.');
        if (posA <= 0 || posPt <= 0) return false;
        return true;
    }
    
    @Override
    public String getType() {
        return "EMAIL";
    }
}