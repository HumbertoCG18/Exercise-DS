public class MatriculaValidator implements Validator {
    private IntegerValidator integerValidator = new IntegerValidator();
    
    @Override
    public boolean validate(String value) {
        if (!integerValidator.validate(value)) {
            return false;
        } else {
            int sum = 0;
            for(int i=0; i<value.length()-1; i++) {
                sum += Character.getNumericValue(value.charAt(i));
            }
            int verificador = sum % 10;
            if (verificador == Character.getNumericValue(value.charAt(value.length()-1))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String getType() {
        return "MATRICULA";
    }
}