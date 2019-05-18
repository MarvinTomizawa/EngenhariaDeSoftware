package pessoa;

public class PercentualDeParticipacao {
    private Double valor;

    public PercentualDeParticipacao(Double valor) {
        if(valor <= 0){
            throw new RuntimeException("O valor não pode ser menor ou igual a zero.");
        }
        if(valor > 1){
            throw new RuntimeException("O valor não pode ser maior que 1");
        }
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }
}
