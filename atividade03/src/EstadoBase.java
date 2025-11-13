/**
 * Classe base abstrata para compartilhar comportamento padrão
 * e evitar que todos os estados tenham que implementar
 * métodos que não lhes dizem respeito (ex: sairManutencao).
 */
public abstract class EstadoBase implements EstadoUsina {
    // Por padrão, a maioria dos estados ignora isso
    @Override
    public void sairManutencao(UsinaNuclear usina) {
        System.out.println("Comando ignorado: usina não está em manutenção.");
    }
    
    // Por padrão, qualquer estado pode entrar em manutenção
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        // REQUISITO: O modo manutenção se "lembra" do estado anterior
        usina.setEstado(new EstadoManutencao(this));
    }
}