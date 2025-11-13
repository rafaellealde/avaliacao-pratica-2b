package adapter;

import java.util.HashMap;

import legacy.SistemaBancarioLegado;

/**
 * DESIGN PATTERN: Adapter
 *
 * JUSTIFICATIVA: Esta classe é o Adaptador.
 * 1. Ela implementa a interface moderna (ProcessadorTransacoes).
 * 2. Ela "contém" (Wrapper) uma instância do sistema legado.
 * 3. Ela traduz a chamada moderna para a legada e a resposta
 * legada de volta para a moderna.
 */
public class LegacyAdapter implements ProcessadorTransacoes {

    // O Adaptador "contém" a classe que ele está adaptando
    private final SistemaBancarioLegado legado;

    public LegacyAdapter(SistemaBancarioLegado legado) {
        this.legado = legado;
    }

    @Override
    public RespostaAutorizacao autorizar(String cartao, double valor, String moeda) {
        // --- ETAPA 1: Traduzir Request (Moderno -> Legado) ---
        HashMap<String, Object> parametrosLegado = converterRequestParaLegado(cartao, valor, moeda);

        // --- ETAPA 2: Chamar o sistema legado ---
        HashMap<String, Object> respostaLegada = legado.processarTransacao(parametrosLegado);

        // --- ETAPA 3: Traduzir Response (Legado -> Moderno) ---
        // REQUISITO: "Implemente de forma que o funcionamento seja bidirecional"
        return converterResponseParaModerno(respostaLegada);
    }

    /**
     * Método privado que encapsula a lógica de tradução do request.
     */
    private HashMap<String, Object> converterRequestParaLegado(String cartao, double valor, String moeda) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("CARTAO_NUM", cartao);
        parametros.put("VALOR_TOTAL", valor);

        // RESTRIÇÃO: "O legado exige codificação específica para moedas"
        parametros.put("MOEDA_COD", converterMoedaParaCodigo(moeda));

        // REQUISITO: "campos obrigatórios do legado que não existem na interface moderna"
        // O Adapter adiciona o dado faltante que o legado espera.
        parametros.put("ID_TERMINAL", "ADAPTER_TERMINAL_01");

        return parametros;
    }

    /**
     * Método privado que encapsula a lógica de tradução da resposta.
     */
    private RespostaAutorizacao converterResponseParaModerno(HashMap<String, Object> respostaLegada) {
        // O casting (Object) -> (String/Boolean) é parte da "sujeira"
        // que o Adapter esconde do resto do sistema.
        String status = (String) respostaLegada.get("STATUS");
        boolean aprovado = "APROVADO".equals(status);
        String codigo = (String) respostaLegada.get("COD_AUT");
        String mensagem = (String) respostaLegada.get("MSG");

        return new RespostaAutorizacao(aprovado, codigo, mensagem);
    }

    /**
     * RESTRIÇÃO: "O legado exige codificação específica para moedas"
     */
    private int converterMoedaParaCodigo(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD": return 1;
            case "EUR": return 2;
            case "BRL": return 3;
            default:
                // É uma boa prática o Adapter também lidar com erros de tradução
                return 0; // Código para "desconhecido"
        }
    }
}
