public class App {
    public static void main(String[] args) {
        // 1. Criar o "contexto complexo"
        FinancialContext data = new FinancialContext(1000000.0, 0.15, 30);

        // 2. Criar as instâncias das estratégias disponíveis
        RiskCalculationStrategy varStrategy = new ValueAtRiskStrategy();
        RiskCalculationStrategy esStrategy = new ExpectedShortfallStrategy();
        RiskCalculationStrategy stressStrategy = new StressTestingStrategy();

        // 3. Criar o Contexto de Análise
        RiskAnalysisContext analysisContext = new RiskAnalysisContext();

        // --- Início da Execução ---

        System.out.println("NECESSIDADE DE NEGÓCIO: Calcular VaR");
        // REQUISITO: "trocar de algoritmo de acordo com a necessidade"
        analysisContext.setStrategy(varStrategy);
        System.out.println("Resultado: " + analysisContext.performAnalysis(data));

        System.out.println("\nNECESSIDADE DE NEGÓCIO: Fazer Stress Test");
        // REQUISITO: "intercambiável em tempo de execução"
        analysisContext.setStrategy(stressStrategy);
        System.out.println("Resultado: " + analysisContext.performAnalysis(data));

        System.out.println("\nNECESSIDADE DE NEGÓCIO: Calcular Expected Shortfall");
        // RESTRIÇÃO: "O cliente deve poder mudar de algoritmo sem conhecer
        // os detalhes de implementação"
        analysisContext.setStrategy(esStrategy);
        System.out.println("Resultado: " + analysisContext.performAnalysis(data));
    }
}
