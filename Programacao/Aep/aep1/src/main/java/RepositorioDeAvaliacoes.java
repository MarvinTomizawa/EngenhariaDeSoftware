import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositorioDeAvaliacoes {
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionar(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public List<Aluno> obterAprovados(Disciplina disciplinaPesquisada){
        Set<Aluno> alunos = new HashSet<>();
        avaliacoes.stream()
                .filter(avaliacao -> avaliacao.getDisciplina().equals(disciplinaPesquisada))
                .forEach(avaliacao -> alunos.add(avaliacao.getAluno()));

        List<Aluno> alunosAprovados = new ArrayList<>();

        alunos.forEach(aluno -> {
            List<Float> notas = new ArrayList<>();
            avaliacoes.stream()
                    .filter(avaliacao -> avaliacao.getAluno().equals(aluno) && avaliacao.getDisciplina().equals(disciplinaPesquisada))
                    .forEach(avaliacao -> notas.add(avaliacao.getNota()));

            double media = notas.stream().mapToDouble(nota -> nota).sum() / 4;

            if(media >=6){
                alunosAprovados.add(aluno);
            }
        });

        return alunosAprovados;
    }
}
