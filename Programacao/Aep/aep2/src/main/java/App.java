import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String args[]){
        RepositorioDeAvaliacoes repositorioDeAvaliacoes = new RepositorioDeAvaliacoes();
        List<Disciplina> listaDeDisciplinas = new ArrayList<>();
        List<Avaliacao> listaDeAvaliacoes = new ArrayList<>();

        listaDeDisciplinas.add(new Disciplina("(1) Matematica"));
        listaDeDisciplinas.add(new Disciplina("(2) História"));
        listaDeDisciplinas.add(new Disciplina("(3) Portugues"));
        listaDeDisciplinas.add(new Disciplina("(4) Biologia"));
        listaDeDisciplinas.add(new Disciplina("(5) Quimica"));

        Aluno aluno1 = new Aluno("Ana",1);
        Aluno aluno2 = new Aluno("Bruna",2);
        Aluno aluno3 = new Aluno("Carlos",3);
        Aluno aluno4 = new Aluno("Daniel",4);
        Aluno aluno5 = new Aluno("Eduardo",5);
        Aluno aluno6 = new Aluno("Fabio",6);
        Aluno aluno7 = new Aluno("Guilherme",7);
        Aluno aluno8 = new Aluno("Hannah",8);
        Aluno aluno9 = new Aluno("Isabela",9);
        Aluno aluno10 = new Aluno("João",10);

        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno1(listaDeDisciplinas,aluno1));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno2(listaDeDisciplinas,aluno2));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno3(listaDeDisciplinas,aluno3));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno4(listaDeDisciplinas,aluno4));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno5(listaDeDisciplinas,aluno5));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno6(listaDeDisciplinas,aluno6));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno7(listaDeDisciplinas,aluno7));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno8(listaDeDisciplinas,aluno8));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno9(listaDeDisciplinas,aluno9));
        listaDeAvaliacoes.addAll(adicionarAvaliacoesAluno10(listaDeDisciplinas,aluno10));

        listaDeAvaliacoes
                .forEach(repositorioDeAvaliacoes::adicionar);

        listaDeDisciplinas
                .forEach(disciplina -> mostrarAprovados(repositorioDeAvaliacoes.obterAprovados(disciplina), disciplina));
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno1(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(4,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(4,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(4,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno2(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(4,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(1.2f,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(4,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(3.4f,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(2.5f,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno3(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(8.5f,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(4,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno4(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9.5f,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(0,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno5(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9.2f,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(1,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(2,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno6(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(4,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(9.2f,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(3,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(9.2f,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno7(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno8(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno9(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(9.2f,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(9.2f,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(5.9f,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(5,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static List<Avaliacao> adicionarAvaliacoesAluno10(List<Disciplina> disciplinas, Aluno aluno){
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(10,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(0),aluno));
        listaAvaliacao.add(new Avaliacao(8.2f,disciplinas.get(0),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(7,disciplinas.get(1),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(1),aluno));

        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(2),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(2),aluno));

        listaAvaliacao.add(new Avaliacao(10,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(10,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(10,disciplinas.get(3),aluno));
        listaAvaliacao.add(new Avaliacao(10,disciplinas.get(3),aluno));

        listaAvaliacao.add(new Avaliacao(8,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(6,disciplinas.get(4),aluno));
        listaAvaliacao.add(new Avaliacao(9,disciplinas.get(4),aluno));
        return listaAvaliacao;
    }

    private static void mostrarAprovados(List<Aluno> alunos, Disciplina disciplina) {
        System.out.println("Alunos aprovados da disciplina: " + disciplina.getNome());
        alunos.forEach(aluno -> System.out.println(aluno.getNome()));
        System.out.println("------------------------------------------------");

    }

}
