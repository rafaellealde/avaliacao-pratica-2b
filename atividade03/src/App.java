public class App {
    public static void main(String[] args) {
        UsinaNuclear usina = new UsinaNuclear();

        // Simulando a subida da temperatura
        usina.verificarSistema(new DadosSensores(80, false));
        usina.verificarSistema(new DadosSensores(310, false)); // Deve ir para Amarelo
        usina.verificarSistema(new DadosSensores(410, false)); // Deve ir para Vermelho
        
        System.out.println("\n--- Entrando em Manutenção ---");
        usina.iniciarManutencao(); // Deve ir para Manutenção
        // Durante a manutenção, os sensores são ignorados
        usina.verificarSistema(new DadosSensores(1000, true)); // Ignorado
        usina.pararManutencao(); // Deve voltar para Vermelho

        System.out.println("\n--- Simulando Emergência ---");
        // REQUISITO 4: Só pode ir para Emergência de Alerta Vermelho
        usina.verificarSistema(new DadosSensores(410, true)); // Deve ir para Emergência
        
        // REQUISITO 3: Prevenção de transições perigosas
        usina.verificarSistema(new DadosSensores(20, false)); // Ignorado, sistema travado
    }
}
