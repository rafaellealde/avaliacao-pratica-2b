/**
 * REQUISITO: "sobreescreva temporariamente os estados normais"
 * Este estado "congela" a lógica normal e se lembra
 * do estado anterior para poder voltar a ele.
 */
public class EstadoManutencao implements EstadoUsina {
    // Salva o estado de onde viemos
    private final EstadoUsina estadoAnterior;

    public EstadoManutencao(EstadoUsina estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    @Override
    public void processarSensores(UsinaNuclear usina, DadosSensores dados) {
        // Lógica de manutenção...
        System.out.println("...sistema em manutenção, sensores ignorados...");
    }

    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Comando ignorado: Usina já está em manutenção.");
    }

    @Override
    public void sairManutencao(UsinaNuclear usina) {
        // Restaura o estado salvo
        usina.setEstado(this.estadoAnterior);
    }
    
    @Override
    public String getNomeEstado() { return "MANUTENCAO"; }
}