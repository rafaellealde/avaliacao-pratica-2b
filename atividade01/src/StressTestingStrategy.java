/**
 * DESIGN PATTERN: Strategy (Estratégia Concreta 3)
 *
 * JUSTIFICATIVA: Encapsula o algoritmo específico para Stress Testing.
 */
public class StressTestingStrategy implements RiskCalculationStrategy {
    @Override
    public String calculateRisk(FinancialContext context) {
        // Lógica de cálculo dummy
        return "CÁLCULO DUMMY [Stress Test]: Teste de estresse aplicado com volatilidade de " +
               context.getMarketVolatility();
    }
}