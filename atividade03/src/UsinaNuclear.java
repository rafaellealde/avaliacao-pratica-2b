/**
 * DESIGN PATTERN: State (Context)
 *
 * A classe UsinaNuclear delega todo o comportamento sensível ao estado
 * para o objeto de estado atual (estadoAtual).
 */
public class UsinaNuclear {
    private EstadoUsina estadoAtual;

    public UsinaNuclear() {
        // Estado inicial
        this.estadoAtual = new EstadoDesligada();
    }

    // O contexto expõe um setter para que os estados possam
    // transicioná-lo para um novo estado.
    public void setEstado(EstadoUsina novoEstado) {
        System.out.println(">>> TRANSIÇÃO: " + estadoAtual.getNomeEstado() + " -> " + novoEstado.getNomeEstado());
        this.estadoAtual = novoEstado;
    }

    // --- Métodos de delegação ---

    public void verificarSistema(DadosSensores dados) {
        System.out.println("Verificando sensores no estado: " + estadoAtual.getNomeEstado());
        this.estadoAtual.processarSensores(this, dados);
    }

    public void iniciarManutencao() {
        System.out.println("Tentando entrar em manutenção...");
        this.estadoAtual.entrarManutencao(this);
    }

    public void pararManutencao() {
        System.out.println("Tentando sair da manutenção...");
        this.estadoAtual.sairManutencao(this);
    }
}