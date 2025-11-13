import adapter.LegacyAdapter;
import adapter.ProcessadorTransacoes;
import adapter.RespostaAutorizacao;
import legacy.SistemaBancarioLegado;

public class App {
    public static void main(String[] args) {
        // 1. O sistema legado existe, escondido
        SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegado();

        // 2. Criamos nosso Adapter e o injetamos.
        // O cliente só conhece a interface ProcessadorTransacoes.
        // SOLID (D): Dependemos da abstração.
        ProcessadorTransacoes processador = new LegacyAdapter(sistemaLegado);

        // --- O CLIENTE FAZ UMA CHAMADA "MODERNA" ---
        System.out.println("Cliente: Autorizando R$ 1.500,00 BRL...");
        RespostaAutorizacao resp1 = processador.autorizar("1234-5678-9012-3456", 1500.00, "BRL");
        System.out.println("Cliente: Resposta recebida -> " + resp1);

        System.out.println("\n----------------------------------\n");

        // --- O CLIENTE FAZ OUTRA CHAMADA "MODERNA" ---
        System.out.println("Cliente: Autorizando R$ 10.000,00 USD...");
        RespostaAutorizacao resp2 = processador.autorizar("9876-5432-1098-7654", 10000.00, "USD");
        System.out.println("Cliente: Resposta recebida -> " + resp2);
    }
}
