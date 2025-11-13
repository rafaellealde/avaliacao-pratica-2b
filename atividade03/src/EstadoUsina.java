/**
 * DESIGN PATTERN: State (Interface)
 *
 * Define o contrato para todos os estados. Cada estado saberá como
 * processar os dados dos sensores e como (ou se) deve transicionar.
 */
public interface EstadoUsina {
    /**
     * Processa os dados atuais dos sensores e aplica a lógica de
     * transição de estado.
     * @param usina O objeto de contexto (a Usina) para poder mudar seu estado.
     * @param dados Os dados atuais dos sensores.
     */
    void processarSensores(UsinaNuclear usina, DadosSensores dados);

    /**
     * Tenta entrar no modo de manutenção.
     */
    void entrarManutencao(UsinaNuclear usina);

    /**
     * Método que só existe no estado de Manutenção, para sair dele.
     * Outros estados o ignoram.
     */
    void sairManutencao(UsinaNuclear usina);
    
    String getNomeEstado();
}