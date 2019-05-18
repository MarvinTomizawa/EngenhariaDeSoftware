package pessoa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Juridica extends Pessoa {
    private CNPJ cnpj;
    private CapitalSocial capitalSocial;
    private Set<CotaSociedade> cotasSociedade = new HashSet<>();

    public Juridica(UUID id, String nome, CNPJ cnpj, CapitalSocial capitalSocial) {
        super(id, nome);
        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public Juridica(String nome, CNPJ cnpj, CapitalSocial capitalSocial) {
        super(nome);
        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public void adicionarSocio(Pessoa socio, PercentualDeParticipacao percentualDeParticipacao){
        if(socio.equals(this)){
            throw new RuntimeException("Não pode se inserir na lista.");
        }
        cotasSociedade.add(new CotaSociedade(percentualDeParticipacao,socio));
    }

    public void removerSocio(Pessoa socio){
        cotasSociedade.removeIf(cota ->cota.socio.equals(socio));
    }

    public CNPJ getCnpj() {
        return cnpj;
    }

    public CapitalSocial getCapitalSocial() {
        return capitalSocial;
    }

    private class CotaSociedade {
        private final PercentualDeParticipacao percentualDeParticipacao;
        private final Pessoa socio;

        public CotaSociedade(PercentualDeParticipacao percentualDeParticipacao, Pessoa socio) {
            this.percentualDeParticipacao = percentualDeParticipacao;
            this.socio = socio;
        }

        @Override
        public boolean equals(Object obj) {
            if(!obj.getClass().equals(Pessoa.class)){
                Pessoa pessoa = (Pessoa) obj;
                if(this.socio.equals(pessoa)){
                    return true;
                }
            }
            return false;
        }
    }
}
