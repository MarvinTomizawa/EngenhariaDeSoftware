
public class AppCarros {

	public static void main(String[] args) {
		CarroFactory factory = new CarroFactory();
//		Carro carro1 = factory.criaModeloCompacto("Ford");
		Carro carro1 = ECarro.getCarro("Ford");
		System.out.println(carro1.getClass());
		
//		Carro carro2 = factory.criaModeloCompacto("Fiat");
		Carro carro2 = ECarro.getCarro("Fiat");
		System.out.println(carro2.getClass());
		
//		Carro carro3 = factory.criaModeloCompacto("Renault");
		Carro carro3 = ECarro.getCarro("Renault");
		System.out.println(carro3.getClass());
		
//		Carro carro4 = factory.criaModeloCompacto("Volxvagen");
		Carro carro4 = ECarro.getCarro("Volxvagen");
		System.out.println(carro4.getClass());
		
	}

}
