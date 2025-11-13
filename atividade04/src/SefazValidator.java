public class SefazValidator extends BaseValidator {
    @Override
    protected void executeValidation(ValidationContext context) throws Exception {
        // RESTRIÇÃO 1:
        if (context.hasErrors()) {
            System.out.println("5. Pulando Consulta SEFAZ (erros anteriores).");
            return;
        }
        System.out.println("5. Consultando Serviço SEFAZ...");
        
        if (context.getDocument().getXmlContent().contains("force-sefaz-fail")) {
            throw new Exception("SEFAZ retornou erro: Lote em processamento.");
        }
    }
}