
public class CarroFactory {
	public Carro criaModeloCompacto(String marca) {
		switch(marca) {
			case "Volxvagen":
				return new Up();
			case "Fiat":
				return new Uno();
			case "Ford":
				return new Ka();
			case "Renault":
				return new Kwid();
			default:
				return null;
		}
	}
}
