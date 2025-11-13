/**
 * REQUISITO: "capazes de compartilhar um contexto complexo"
 *
 * Esta classe (POJO) encapsula todos os parâmetros financeiros necessários
 * para qualquer um dos algoritmos de risco. Ela será passada para
 * a estratégia no momento da execução.
 */
public class FinancialContext {
    private double portfolioValue;
    private double marketVolatility;
    private int timeHorizonDays;
    // ... outros parâmetros complexos

    // Construtor, Getters e Setters
    public FinancialContext(double portfolioValue, double marketVolatility, int timeHorizonDays) {
        this.portfolioValue = portfolioValue;
        this.marketVolatility = marketVolatility;
        this.timeHorizonDays = timeHorizonDays;
    }

    public double getPortfolioValue() {
        return portfolioValue;
    }

    public double getMarketVolatility() {
        return marketVolatility;
    }

    public int getTimeHorizonDays() {
        return timeHorizonDays;
    }
}