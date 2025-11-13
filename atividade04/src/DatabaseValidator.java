/**
 * Este validador implementa a interface de Rollback (Command).
 */
public class DatabaseValidator extends BaseValidator implements IReversibleValidator {
    private boolean inserido = false;

    @Override
    protected void executeValidation(ValidationContext context) throws Exception {
        System.out.println("4. Validando Duplicidade no Banco de Dados...");
        // RESTRIÇÃO 2: "fazer rollback da inserção"
        // Simulando a inserção para reserva de número
        System.out.println("   [DB] INSERT INTO NFE (numero, status) VALUES (..., 'PENDING')");
        this.inserido = true;
        
        // Adiciona a si mesmo na pilha de rollback
        context.addRollbackStep(this);

        // Simulando uma falha *após* a inserção (para testar o rollback)
        if (context.getDocument().getXmlContent().contains("sefaz-fail")) {
             throw new Exception("Falha simulada no DB (ex: duplicidade encontrada)");
        }
    }

    @Override
    public void rollback(ValidationContext context) {
        if (this.inserido) {
            // REQUISITO 4: "capacidade de rollback"
            System.out.println("   [DB] ROLLBACK: DELETE FROM NFE WHERE status='PENDING'");
            this.inserido = false;
        }
    }
}