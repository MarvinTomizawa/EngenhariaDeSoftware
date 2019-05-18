package pessoa;

public class CNPJ {
    private String numero;

    public CNPJ(String numero) {
        if(isNotCNPJValido(numero)){
            throw new RuntimeException("CNPF Invalido.");
        }
        this.numero = numero;
    }

    private boolean isNotCNPJValido(String numero) {

        String cnpj = numero;
        if (!cnpj.isEmpty()) {
            throw new RuntimeException("Cnpj vazio.");
        }

        try {
            cnpj = cnpj.replace('.', ' ');
            cnpj = cnpj.replace('/', ' ');
            cnpj = cnpj.replace('-', ' ');
            cnpj = cnpj.replaceAll(" ", "");
            int soma = 0, digito;
            String numerosCnpj = cnpj.substring(0, 12);

            if (cnpj.length() != 14) {
                return true;
            }
            char[] caracterCnpj = cnpj.toCharArray();

            for (int x = 0; x < 4; x++) {
                if (caracterCnpj[x] - 48 >= 0 && caracterCnpj[x] - 48 <= 9) {
                    soma += (caracterCnpj[x] - 48) * (6 - (x + 1));
                }
            }
            for (int x = 0; x < 8; x++) {
                if (caracterCnpj[x + 4] - 48 >= 0 && caracterCnpj[x + 4] - 48 <= 9) {
                    soma += (caracterCnpj[x + 4] - 48) * (10 - (x + 1));
                }
            }
            digito = 11 - (soma % 11);
            numerosCnpj += (digito == 10 || digito == 11) ? "0" : Integer.toString(digito);

            soma = 0;
            for (int x = 0; x < 5; x++) {
                if (caracterCnpj[x] - 48 >= 0 && caracterCnpj[x] - 48 <= 9) {
                    soma += (caracterCnpj[x] - 48) * (7 - (x + 1));
                }
            }
            for (int x = 0; x < 8; x++) {
                if (caracterCnpj[x + 5] - 48 >= 0 && caracterCnpj[x + 5] - 48 <= 9) {
                    soma += (caracterCnpj[x + 5] - 48) * (10 - (x + 1));
                }
            }
            digito = 11 - (soma % 11);
            numerosCnpj += (digito == 10 || digito == 11) ? "0" : Integer.toString(digito);
            return !cnpj.equals(numerosCnpj);
        }
        catch (Exception e) {
            return true;
        }
    }

    public String getNumero() {
        return numero;
    }
}
