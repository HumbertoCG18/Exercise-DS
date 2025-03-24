public class IntegerValidator implements Validator {
    @Override
    public boolean validate(String value) {
        for(int i=0; i<value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String getType() {
        return "INTEIRO";
    }
}