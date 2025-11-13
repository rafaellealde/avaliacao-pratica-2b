package adapter;

/**
 * Esta é a interface "alvo" que o nosso sistema cliente
 * conhece e utiliza.
 */
public interface ProcessadorTransacoes {
    RespostaAutorizacao autorizar(String cartao, double valor, String moeda);
}
