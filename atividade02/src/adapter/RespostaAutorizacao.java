package adapter;

/**
 * REQUISITO: "converter respostas do legado para o formato atualizado"
 *
 * Este DTO (Data Transfer Object) representa a resposta limpa e moderna
 * que o nosso cliente espera receber.
 */
public class RespostaAutorizacao {
    private final boolean aprovado;
    private final String codigoAutorizacao;
    private final String mensagem;

    public RespostaAutorizacao(boolean aprovado, String codigoAutorizacao, String mensagem) {
        this.aprovado = aprovado;
        this.codigoAutorizacao = codigoAutorizacao;
        this.mensagem = mensagem;
    }

    // Getters
    public boolean isAprovado() {
        return aprovado;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "RespostaAutorizacao{" +
                "aprovado=" + aprovado +
                ", codigoAutorizacao='" + codigoAutorizacao + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
