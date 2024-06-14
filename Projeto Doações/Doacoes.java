import java.util.Date;

public class Doacao {
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
