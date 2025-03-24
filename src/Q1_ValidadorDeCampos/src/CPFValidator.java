public class CPFValidator implements Validator {
    @Override
    public boolean validate(String value) {
        // Simplified CPF validation for demonstration purposes
        // Remove non-numeric characters
        value = value.replaceAll("[^0-9]", "");
        
        // Check if it has 11 digits
        if (value.length() != 11) {
            return false;
        }
        
        // Check if all digits are the same (invalid CPF)
        boolean allDigitsSame = true;
        for (int i = 1; i < value.length(); i++) {
            if (value.charAt(i) != value.charAt(0)) {
                allDigitsSame = false;
                break;
            }
        }
        if (allDigitsSame) {
            return false;
        }
        
        // In a real implementation, we would check the verification digits
        // This is simplified for demonstration
        return true;
    }
    
    @Override
    public String getType() {
        return "CPF";
    }
}