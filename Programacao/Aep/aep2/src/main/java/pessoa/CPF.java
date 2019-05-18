package pessoa;

public class CPF {
    private String numeros;

    public CPF(String numeros) {
        if(isNotCpfValid(numeros)){
            throw new RuntimeException("Cpf invalido");
        }
        this.numeros = numeros;
    }

    private boolean isNotCpfValid(String numeros) {
        if(numeros.isEmpty()) {
            throw new RuntimeException("CPF vazio.");
        }
        String cpf = numeros;
        cpf = cpf.replace('.', ' ');
        cpf = cpf.replace('/', ' ');
        cpf = cpf.replace('-', ' ');
        cpf = cpf.replaceAll(" ", "");


        try {
            if(cpf.length() != 12){
                throw new RuntimeException();
            }
            int soma = 0;
            int peso = 10;
            for (int x=0; x<9; x++) {
                int numero = (int)(cpf.charAt(x) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            int digito10;
            int resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11))
                digito10 = '0';
            else digito10 = (char)(resultado + 48);

            soma = 0;
            peso = 11;
            for(int x=0; x<10; x++) {
                int num = (int)(cpf.charAt(x) - 48);
                soma = soma + (num * peso);
                peso = peso - 1;
            }

            int digito11;
            resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11))
                digito11 = '0';
            else digito11 = (char)(resultado + 48);

            if ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10)))
                return false;
            else return true;
        } catch (Exception e) {
            return true;
        }
    }

    public String getNumeros() {
        return numeros;
    }
}
