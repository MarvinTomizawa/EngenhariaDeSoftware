package pessoa;

public class RG {
    private String numeros;

    public RG(String numeros) {
        if(isNotRgValid(numeros)){
            throw new RuntimeException("Rg invalido.");
        }
        this.numeros = numeros;
    }

    private boolean isNotRgValid(String numeros) {
        String rg = numeros;

        if(rg.isEmpty()) {
            throw new RuntimeException("Rg vazio.");
        }
        try{
            rg = rg.replace('.', ' ');
            rg = rg.replace('/', ' ');
            rg = rg.replace('-', ' ');
            rg = rg.replaceAll(" ", "");
            int soma = 0;

            for(int x=0; x<8; x++){
                int numero = (int) rg.charAt(x);
                soma += numero * x-9;
            }

            soma = soma % 11;
            if (soma == (int) rg.charAt(8) || (soma == 10 && rg.charAt(8) == 'X')) {
                return false;
            }
        }catch (Exception e){
            return true;
        }

        return true;
    }

    public String getNumeros() {
        return numeros;
    }
}
