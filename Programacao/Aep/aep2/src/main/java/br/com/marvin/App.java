package br.com.marvin;

import br.com.marvin.entity.BilheteAereo;
import br.com.marvin.repository.BilheteAereoRepository;
import lombok.extern.log4j.Log4j2;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class App {

    private static final String MARINGA = "Maringa";
    private static final String PARANAVAI = "Paranavai";

    public static void main(String[] args) {
        BilheteAereoRepository bilheteAereoRepository = new BilheteAereoRepository();

        bilheteAereoRepository.excluirTodos();

        List<BilheteAereo> bilhetesAereo =
                List.of(
                        new BilheteAereo(1,1,MARINGA,PARANAVAI, Date.valueOf(LocalDate.now())),
                        new BilheteAereo(2,1,MARINGA,PARANAVAI, Date.valueOf(LocalDate.now())),
                        new BilheteAereo(3,2,PARANAVAI,MARINGA, Date.valueOf(LocalDate.now().minusDays(1))),
                        new BilheteAereo(4,2,PARANAVAI,MARINGA, Date.valueOf(LocalDate.now().minusDays(1))),
                        new BilheteAereo(5,1,MARINGA,PARANAVAI, Date.valueOf(LocalDate.now())),
                        new BilheteAereo(6,1,MARINGA,PARANAVAI, Date.valueOf(LocalDate.now()))
                );

        bilhetesAereo.forEach(bilheteAereoRepository::inserir);

        bilheteAereoRepository.excluir(bilhetesAereo.get(2).getId());

        bilhetesAereo = bilheteAereoRepository.obterTodas();
        bilhetesAereo.forEach(System.out::println);

        System.out.println("Alterando valores \n");
        bilheteAereoRepository.alterar(new BilheteAereo(4,3,"Jussara",MARINGA, Date.valueOf(LocalDate.now().minusDays(3))));

        bilhetesAereo = bilheteAereoRepository.obterTodas();

        bilhetesAereo.forEach(System.out::println);
        }
}
