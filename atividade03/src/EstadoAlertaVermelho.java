public class EstadoAlertaVermelho extends EstadoBase {
    @Override
    public void processarSensores(UsinaNuclear usina, DadosSensores dados) {
        // REGRA: ALERTA_VERMELHO → EMERGENCIA: se sistema de resfriamento falhar
        if (dados.isFalhaResfriamento()) {
            usina.setEstado(new EstadoEmergencia());
        }
        // REQUISITO: Prevenção de loops. Daqui não volta para Amarelo
        // facilmente, apenas se a condição for ativamente revertida.
    }
    @Override
    public String getNomeEstado() { return "ALERTA_VERMELHO"; }
}