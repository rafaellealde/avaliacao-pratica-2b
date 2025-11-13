public class FiscalRuleValidator extends BaseValidator {
    @Override
    protected void executeValidation(ValidationContext context) throws Exception {
        // RESTRIÇÃO 1: "executados apenas se os anteriores passarem"
        if (context.hasErrors()) {
            System.out.println("3. Pulando Validador Fiscal (erros anteriores).");
            return; // Pula a execução
        }
        
        System.out.println("3. Validando Regras Fiscais (Impostos)...");
        // ... lógica de cálculo de impostos ...
    }
}