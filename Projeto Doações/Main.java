import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Doacao {
    private String tipo;
    private double quantidade;
    private Date data;

    public Doacao(String tipo, double quantidade, Date data) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public Date getData() {
        return data;
    }
}

class GerenciadorDoacoes {
    private List<Doacao> doacoes;

    public GerenciadorDoacoes() {
        this.doacoes = new ArrayList<>();
    }

    public void adicionarDoacao(String tipo, double quantidade, Date data) {
        Doacao doacao = new Doacao(tipo, quantidade, data);
        doacoes.add(doacao);
    }

    public double calcularTotalDoacoes() {
        double total = 0;
        for (Doacao doacao : doacoes) {
            total += doacao.getQuantidade();
        }
        return total;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }
}

public class Main {
    public static void main(String[] args) {
        GerenciadorDoacoes gerenciador = new GerenciadorDoacoes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Fazer Doação");
            System.out.println("2. Total de Doações");
            System.out.println("3. Listar Doações");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o tipo de doação:");
                    System.out.println("1. Alimentos");
                    System.out.println("2. Medicamentos");
                    System.out.println("3. Água");
                    System.out.println("4. Ração");
                    System.out.println("5. Roupas");
                    System.out.println("6. Dinheiro");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    String tipoStr = "";
                    switch (tipo) {
                        case 1:
                            System.out.println("Digite o tipo de alimento e a pesagem de cada embalagem: ");
                            tipoStr = "Alimentos";
                            scanner.nextLine(); //descrição do alimento
                            break;
                        case 2:
                            System.out.println("Digite o tipo de medicamento: ");
                            tipoStr = "Medicamentos";
                            scanner.nextLine(); //descrição medicamento
                            break;
                        case 3:
                            System.out.println("As garrafas devem ser apenas de um tipo de litragem.                                                     Digite o tipo de garrafa a ser doada: ");
                            tipoStr = "Água";
                            scanner.nextLine(); //descrição da água
                            break;
                        case 4:
                            System.out.println("Digite o tipo de ração: ");
                            tipoStr = "Ração";
                            scanner.nextLine(); //descrição da ração
                            break;
                        case 5:
                            System.out.println("Digite o gênero e os tipos de roupa: ");
                            tipoStr = "Roupas";
                            scanner.nextLine(); //descrição das roupas
                            break;
                        case 6:
                            tipoStr = "Dinheiro";
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                            continue;
                    }

                    System.out.print("Digite a quantidade que deseja doar: ");
                    double quantidade = scanner.nextDouble();
                    scanner.nextLine(); 

                    Date data = new Date();
                    gerenciador.adicionarDoacao(tipoStr, quantidade, data);
                    System.out.println("Doação registrada com sucesso!");
                    break;

                case 2:
                    System.out.println("Total de doações recebidas: ");
                    double totalAlimento = 0;
                    double totalMedicamento = 0;
                    double totalAgua = 0;
                    double totalRacao = 0;
                    double totalRoupa = 0;
                    double totalDinheiro = 0;

                    for (Doacao doacao : gerenciador.getDoacoes()) {
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
                    System.out.println("1. Alimentos: " + totalAlimento);
                    System.out.println("2. Medicamentos: " + totalMedicamento);
                    System.out.println("3. Água: " + totalAgua + " Litros");
                    System.out.println("4. Ração: " + totalRacao);
                    System.out.println("5. Roupas: " + totalRoupa);
                    System.out.println("6. Dinheiro: R$" + totalDinheiro);
                    break;

                case 3:
                    List<Doacao> doacoes = gerenciador.getDoacoes();
                    System.out.println("\n===== Lista de Doações =====");
                    for (Doacao doacao : doacoes) {
                        System.out.println("Tipo: " + doacao.getTipo());
                        System.out.println("Quantidade: " + doacao.getQuantidade());
                        System.out.println("Data: " + doacao.getData());
                        System.out.println("---------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Até a próxima!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
