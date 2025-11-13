package legacy;

import java.util.HashMap;

/**
 * Esta classe representa o sistema legado.
 * Não podemos alterá-la. Note a interface incompatível
 * que usa HashMap para tudo.
 */
public class SistemaBancarioLegado {

    // REQUISITO: "O sistema legado usa: processarTransacao(HashMap<String, Object> parametros)"
    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("[LEGADO] Recebendo parâmetros: " + parametros);

        // REQUISITO: "tratamento para campos obrigatórios do legado"
        if (!parametros.containsKey("ID_TERMINAL")) {
            throw new IllegalArgumentException("ERRO LEGADO: ID_TERMINAL é obrigatório!");
        }

        // Simulação de lógica
        double valor = (Double) parametros.get("VALOR_TOTAL");
        HashMap<String, Object> resposta = new HashMap<>();

        if (valor > 5000) {
            resposta.put("STATUS", "RECUSADO");
            resposta.put("MSG", "Limite excedido");
            resposta.put("COD_AUT", "N/A");
        } else {
            resposta.put("STATUS", "APROVADO");
            resposta.put("MSG", "Transação OK");
            resposta.put("COD_AUT", "LEGADO_" + System.currentTimeMillis());
        }

        return resposta;
    }
}
