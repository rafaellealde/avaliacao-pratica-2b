public class App {
    // Helper para construir a cadeia
    private static IValidator buildChain() {
        // 1. Instancia os handlers
        IValidator v1 = new SchemaValidator();
        IValidator v2 = new CertificateValidator();
        IValidator v3 = new FiscalRuleValidator();
        IValidator v4 = new DatabaseValidator();
        IValidator v5 = new SefazValidator();

        // 2. Monta a cadeia
        v1.setNext(v2);
        v2.setNext(v3);
        v3.setNext(v4);
        v4.setNext(v5);

        return v1; // Retorna o início da cadeia
    }

    public static void main(String[] args) {
        System.out.println("--- CENÁRIO 1: Falha na SEFAZ (Testando Rollback) ---");
        // Documento que falhará no validador 5 (SEFAZ)
        NFeDocument doc1 = new NFeDocument("<xml>force-sefaz-fail</xml>");
        runValidation(doc1);

        System.out.println("\n\n--- CENÁRIO 2: Falha no Schema (Testando Condicional) ---");
        // Documento que falhará no validador 1 (Schema)
        NFeDocument doc2 = new NFeDocument(null); // Provoca falha no Schema
        runValidation(doc2);
        
        System.out.println("\n\n--- CENÁRIO 3: Falha Múltipla (Testando Circuit Breaker) ---");
        // Documento que falha no DB (erro 1), SEFAZ (erro 2) e teria mais um (erro 3)
        // Vamos simular 3 falhas manualmente para o exemplo
        NFeDocument doc3 = new NFeDocument("<xml></xml>"); // Doc válido
        ValidationContext ctx3 = new ValidationContext(doc3);
        ctx3.addError("Falha manual 1");
        ctx3.addError("Falha manual 2");
        // A próxima falha (addError) irá estourar o breaker.
        // Vamos chamar a cadeia já com 2 erros:
        System.out.println("Iniciando com 2 falhas...");
        runValidation(doc3, ctx3); // Reutiliza o contexto
    }
    
    private static void runValidation(NFeDocument doc) {
        runValidation(doc, new ValidationContext(doc));
    }

    private static void runValidation(NFeDocument doc, ValidationContext context) {
        IValidator chain = buildChain();
        
        try {
            // 3. Executa a cadeia
            chain.validate(context);
        } catch (Exception e) {
            System.out.println("Erro inesperado na plataforma: " + e.getMessage());
        }

        // 4. Processa o resultado
        if (context.hasErrors()) {
            System.out.println("\nVALIDAÇÃO FALHOU:");
            context.getErrors().forEach(System.out::println);

            // REQUISITO 4: Lógica de Rollback
            // O cliente é responsável por disparar o rollback
            if (!context.getRollbackStack().isEmpty()) {
                System.out.println("Iniciando Rollback...");
                while (!context.getRollbackStack().isEmpty()) {
                    IReversibleValidator cmd = context.getRollbackStack().pop();
                    cmd.rollback(context);
                }
            }
        } else {
            System.out.println("\nVALIDAÇÃO CONCLUÍDA COM SUCESSO!");
        }
    }
}
