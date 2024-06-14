import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorDoacoes {
    private List<Doacao> doacoes;

    public GerenciadorDoacoes() {
        this.doacoes = new ArrayList<>();
    }

    public void adicionarDoacao(String tipo, double quantidade, Date data) {
        Doacao novaDoacao = new Doacao(tipo, quantidade, data);
        doacoes.add(novaDoacao);
    }

    public double calcularTotalDoacoes() {
        double totalAlimento = 0;
        double totalMedicamento = 0;
        double totalAgua = 0;
        double totalRacao = 0;
        double totalRoupa = 0;
        double totalDinheiro = 0;

        for (Doacao doacao : this.doacoes) {
            switch (doacao.getTipo()) {
                case "Alimentos":
                    totalAlimento += doacao.getQuantidade();
                    break;
                case "Medicamentos":
                    totalMedicamento += doacao.getQuantidade();
                    break;
                case "Água":
                    totalAgua += doacao.getQuantidade();
                    break;
                case "Ração":
                    totalRacao += doacao.getQuantidade();
                    break;
                case "Roupas":
                    totalRoupa += doacao.getQuantidade();
                    break;
                case "Dinheiro":
                    totalDinheiro += doacao.getQuantidade();
                    break;
            }
        }

        double total = totalAlimento + totalMedicamento + totalAgua + totalRacao + totalRoupa + totalDinheiro;
        return total;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }
}
