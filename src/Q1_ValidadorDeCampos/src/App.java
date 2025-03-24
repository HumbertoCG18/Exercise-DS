public class App {
    public static void main(String[] args) throws Exception {
        String email = "bernardo.copstein@pucrs.br";
        String integer = "12345";
        String matricula = "12345678";
        String cpf = "123.456.789-09";
        String invalidEmail = "invalid-email";
        
        var validador = new Validador();
        
        // Using enum types (backward compatibility)
        System.out.println("=== Usando Enum Types ===");
        if (validador.valida(Validador.Tipo.EMAIL, email)) {
            System.out.println(email + " é um email válido!");
        } else {
            System.out.println(email + " não é um email válido!");
        }
        
        // Using string types (new approach)
        System.out.println("\n=== Usando String Types ===");
        if (validador.valida("EMAIL", email)) {
            System.out.println(email + " é um email válido!");
        } else {
            System.out.println(email + " não é um email válido!");
        }
        
        if (validador.valida("INTEIRO", integer)) {
            System.out.println(integer + " é um inteiro válido!");
        } else {
            System.out.println(integer + " não é um inteiro válido!");
        }
        
        if (validador.valida("MATRICULA", matricula)) {
            System.out.println(matricula + " é uma matrícula válida!");
        } else {
            System.out.println(matricula + " não é uma matrícula válida!");
        }
        
        // Using the new CPF validator
        if (validador.valida("CPF", cpf)) {
            System.out.println(cpf + " é um CPF válido!");
        } else {
            System.out.println(cpf + " não é um CPF válido!");
        }
        
        // Testing invalid values
        if (!validador.valida("EMAIL", invalidEmail)) {
            System.out.println(invalidEmail + " não é um email válido, como esperado!");
        }
        
        // Demonstrating direct use of the factory
        System.out.println("\n=== Usando Factory Diretamente ===");
        ValidatorFactory factory = ValidatorFactory.getInstance();
        
        System.out.println("Tipos de validadores suportados:");
        for (String type : factory.getSupportedTypes()) {
            System.out.println("- " + type);
        }
        
        // Creating a custom validator at runtime and registering it
        System.out.println("\n=== Adicionando Novo Validador em Runtime ===");
        
        // Create and register a new URL validator
        factory.registerValidator(new Validator() {
            @Override
            public boolean validate(String value) {
                return value.startsWith("http://") || value.startsWith("https://");
            }
            
            @Override
            public String getType() {
                return "URL";
            }
        });
        
        // Test the new validator
        String url = "https://www.pucrs.br";
        if (validador.valida("URL", url)) {
            System.out.println(url + " é uma URL válida!");
        } else {
            System.out.println(url + " não é uma URL válida!");
        }
    }
}