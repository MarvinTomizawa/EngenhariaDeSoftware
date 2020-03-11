import java.util.stream.Stream;

public enum ECarro {
	Kwid("Renault", new Kwid()),
	Uno("Fiat", new Uno()),
	Up("Volxvagen", new Up()),
	Ka("Ford", new Ka());
	
	private ECarro(String marca, Carro carro){
		this.marca = marca;
		this.carro = carro;
	}
	
	private String marca;
	private Carro carro;
	
	public static Carro getCarro(String marca) {
		return Stream.of(values())
		.filter(x -> x.marca == marca)
		.findFirst().map(x -> x.carro).get();
	}
}
