// DTO para carregar os dados dos sensores
public class DadosSensores {
    private final double temperatura;
    private final boolean falhaResfriamento;
    // ... outros dados como pressão, radiação

    public DadosSensores(double temperatura, boolean falhaResfriamento) {
        this.temperatura = temperatura;
        this.falhaResfriamento = falhaResfriamento;
    }

    public double getTemperatura() { return temperatura; }
    public boolean isFalhaResfriamento() { return falhaResfriamento; }
}