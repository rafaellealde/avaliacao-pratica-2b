public class EstadoAlertaAmarelo extends EstadoBase {
    @Override
    public void processarSensores(UsinaNuclear usina, DadosSensores dados) {
        // REGRA: ALERTA_AMARELO → ALERTA_VERMELHO: se temperatura > 400°C
        // (Simplificando a regra dos "30 segundos" para uma checagem imediata)
        if (dados.getTemperatura() > 400) {
            usina.setEstado(new EstadoAlertaVermelho());
        } else if (dados.getTemperatura() <= 300) {
            // Transição de volta (bidirecional)
            usina.setEstado(new EstadoOperacaoNormal());
        }
    }
    @Override
    public String getNomeEstado() { return "ALERTA_AMARELO"; }
}