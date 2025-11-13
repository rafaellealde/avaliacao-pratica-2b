/**
 * Classe base abstrata para gerenciar a lógica da cadeia (next)
 * e a lógica do Circuit Breaker (REQUISITO 3).
 */
public abstract class BaseValidator implements IValidator {
    private IValidator next;

    @Override
    public void setNext(IValidator nextValidator) {
        this.next = nextValidator;
    }

    /**
     * O método principal que gerencia a cadeia.
     */
    @Override
    public void validate(ValidationContext context) {
        // REQUISITO 3: "circuit breaker"
        if (context.getFailureCount() >= 3) {
            System.out.println("CIRCUIT BREAKER: Cadeia interrompida. Pulando " + this.getClass().getSimpleName());
            // Não chama o próximo, efetivamente parando a cadeia.
            return;
        }

        // Tenta executar a validação específica
        try {
            // REQUISITO: Timeout individual (simplificado)
            // Uma implementação real usaria ExecutorService.submit()
            // e .get(timeout, TimeUnit.SECONDS)
            executeValidation(context);

        } catch (Exception e) {
            // Se falhar (ex: Timeout, Erro de Validação)
            context.addError(this.getClass().getSimpleName() + ": " + e.getMessage());
        }
        
        // Passa para o próximo da cadeia
        if (next != null) {
            next.validate(context);
        }
    }

    /**
     * Subclasses implementam sua lógica de validação aqui.
     */
    protected abstract void executeValidation(ValidationContext context) throws Exception;
}