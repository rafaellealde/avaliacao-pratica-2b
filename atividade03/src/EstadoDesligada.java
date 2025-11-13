public class EstadoDesligada extends EstadoBase {
    @Override
    public void processarSensores(UsinaNuclear usina, DadosSensores dados) {
        // Lógica para ligar
        if (dados.getTemperatura() > 50) { // Exemplo de condição de "ligar"
             usina.setEstado(new EstadoOperacaoNormal());
        }
    }
    @Override
    public String getNomeEstado() { return "DESLIGADA"; }
}