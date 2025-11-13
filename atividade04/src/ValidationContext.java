import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * REQUISITO: Objeto de contexto que é passado pela cadeia.
 * Ele carrega os erros e o estado do Circuit Breaker.
 * Também carrega a pilha de rollback (Command).
 */
public class ValidationContext {
    private final NFeDocument document;
    private final List<String> errors = new ArrayList<>();
    private final Stack<IReversibleValidator> rollbackStack = new Stack<>();
    private int failureCount = 0;

    public ValidationContext(NFeDocument document) { this.document = document; }
    
    public NFeDocument getDocument() { return document; }
    
    public void addError(String error) {
        this.errors.add(error);
        this.failureCount++;
    }
    
    public int getFailureCount() { return failureCount; }
    public boolean hasErrors() { return failureCount > 0; }
    public List<String> getErrors() { return errors; }

    // Métodos para o padrão Command (Rollback)
    public void addRollbackStep(IReversibleValidator validator) {
        this.rollbackStack.push(validator);
    }
    
    public Stack<IReversibleValidator> getRollbackStack() {
        return rollbackStack;
    }
}