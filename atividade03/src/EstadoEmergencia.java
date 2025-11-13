/**
 * Um estado "terminal" (ou quase).
 */
public class EstadoEmergencia extends EstadoBase {
    @Override
    public void processarSensores(UsinaNuclear usina, DadosSensores dados) {
        // REQUISITO: Prevenção de loops
        // Uma vez em emergência, a lógica normal de sensores para.
        // A usina fica "travada" aqui até uma intervenção manual.
        System.out.println("!!! EMERGÊNCIA ATIVA. SISTEMA TRAVADO !!!");
    }
    
    // Sobrescreve: Não pode entrar em manutenção durante uma emergência
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Comando ignorado: Impossível entrar em manutenção durante EMERGÊNCIA.");
    }

    @Override
    public String getNomeEstado() { return "EMERGENCIA"; }
}