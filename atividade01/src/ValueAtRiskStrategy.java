/**
 * DESIGN PATTERN: Strategy (Estratégia Concreta 1)
 *
 * JUSTIFICATIVA: Encapsula o algoritmo específico para Value at Risk (VaR).
 *
 * SOLID (S): Esta classe tem uma única responsabilidade: calcular o VaR.
 */
public class ValueAtRiskStrategy implements RiskCalculationStrategy {
    @Override
    public String calculateRisk(FinancialContext context) {
        // Lógica de cálculo dummy
        String result = String.format(
            "CÁLCULO DUMMY [VaR]: Risco calculado para portfólio de R$ %.2f",
            context.getPortfolioValue()
        );
        return result;
    }
}