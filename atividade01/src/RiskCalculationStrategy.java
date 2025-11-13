/**
 * DESIGN PATTERN: Strategy (Interface da Estratégia)
 *
 * JUSTIFICATIVA: Define o contrato comum para todos os algoritmos de
 * cálculo de risco. Isso permite que o cliente (RiskAnalysisContext)
 * trate todos os algoritmos de forma uniforme, sem conhecer seus detalhes.
 *
 * SOLID (D): Representa a abstração da qual o RiskAnalysisContext
 * (alto nível) irá depender, em vez das implementações concretas
 * (baixo nível).
 */
public interface RiskCalculationStrategy {
    /**
     * Executa o cálculo de risco com base no contexto financeiro fornecido.
     * @param context O "contexto complexo" com os parâmetros.
     * @return Uma string representando o resultado do cálculo (dummy).
     */
    String calculateRisk(FinancialContext context);
}