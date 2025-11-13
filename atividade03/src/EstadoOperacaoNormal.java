public class EstadoOperacaoNormal extends EstadoBase {
    @Override
    public void processarSensores(UsinaNuclear usina, DadosSensores dados) {
        // REGRA: OPERACAO_NORMAL → ALERTA_AMARELO: se temperatura > 300°C
        if (dados.getTemperatura() > 300) {
            usina.setEstado(new EstadoAlertaAmarelo());
        }
        // ...outras lógicas...
    }
    @Override
    public String getNomeEstado() { return "OPERACAO_NORMAL"; }
}