public class SchemaValidator extends BaseValidator {
    @Override
    protected void executeValidation(ValidationContext context) throws Exception {
        System.out.println("1. Validando Schema XML...");
        if (context.getDocument().getXmlContent() == null) {
            throw new Exception("XML está vazio."); // Simula falha
        }
        // ... lógica de validação XSD ...
    }
}