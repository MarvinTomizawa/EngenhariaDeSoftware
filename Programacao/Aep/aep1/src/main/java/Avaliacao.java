public class Avaliacao {
    private float nota;
    private Disciplina disciplina;
    private Aluno aluno;

    public Avaliacao(float nota, Disciplina disciplina, Aluno aluno) {
        if(nota < 0 || nota > 10){
            throw new RuntimeException("Nota invalida");
        }
        this.nota = nota;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }

    public float getNota() {
        return nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }
}
