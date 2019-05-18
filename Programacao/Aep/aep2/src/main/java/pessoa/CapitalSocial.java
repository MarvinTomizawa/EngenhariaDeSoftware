package pessoa;

public class CapitalSocial {
    private Double valor;

    public CapitalSocial(Double valor) {
        if (valor <= 0) {
            throw new RuntimeException("Valor não pode ser menor ou igual a zero.");
        }
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
}