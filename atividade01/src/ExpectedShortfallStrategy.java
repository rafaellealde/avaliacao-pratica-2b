/**
 * DESIGN PATTERN: Strategy (Estratégia Concreta 2)
 *
 * JUSTIFICATIVA: Encapsula o algoritmo específico para Expected Shortfall (ES).
 */
public class ExpectedShortfallStrategy implements RiskCalculationStrategy {
    @Override
    public String calculateRisk(FinancialContext context) {
        // Lógica de cálculo dummy
        return "CÁLCULO DUMMY [ES]: Perda esperada (Expected Shortfall) processada.";
    }
}