/**
 * DESIGN PATTERN: Strategy (Contexto)
 *
 * JUSTIFICATIVA: Esta classe é o ponto de entrada para o cliente.
 * 1. Ela "esconde" do cliente os detalhes de implementação dos algoritmos.
 * 2. Ela mantém uma referência à estratégia atual (strategy).
 * 3. Ela permite "trocar de algoritmo" dinamicamente (setStrategy).
 *
 * SOLID (O): Esta classe está fechada para modificação. Para adicionar
 * um novo algoritmo, não precisamos alterar este código, apenas
 * criar uma nova classe que implemente RiskCalculationStrategy.
 */
public class RiskAnalysisContext {
    private RiskCalculationStrategy strategy;

    /**
     * REQUISITO: "Deve ser possível trocar de algoritmo"
     * Este método permite ao cliente injetar ou alterar a estratégia
     * em tempo de execução.
     */
    public void setStrategy(RiskCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Executa a análise de risco usando a estratégia atualmente configurada.
     */
    public String performAnalysis(FinancialContext data) {
        if (strategy == null) {
            throw new IllegalStateException("Nenhuma estratégia de cálculo de risco foi definida.");
        }
        // Delega a chamada para o objeto da estratégia atual
        return strategy.calculateRisk(data);
    }
}