package set.listaalunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        for (Aluno a : alunoSet) {
            if (a.getMatricula() == matricula) {
                System.out.println("Aluno: " + a.toString() + " removido com sucesso.");
                alunoSet.remove(a);
                return;
            }
        }
        throw new IllegalArgumentException("erro: matrícula inexistente.");
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosporNota = new TreeSet<>(new ComparatorPorNota());
        alunosporNota.addAll(alunoSet);
        return alunosporNota;
    }


    public static void main(String[] args) {
        GerenciadorAlunos ga = new GerenciadorAlunos();

        ga.adicionarAluno("Vitor", 2003L, 8.03);
        ga.adicionarAluno("Karina", 2004L, 8.5);
        ga.adicionarAluno("Victor", 2002L, 9.03);
        ga.adicionarAluno("Vinicius", 2003L, 8.02);

        System.out.println(ga.exibirAlunosPorNome());
        System.out.println(ga.exibirAlunosPorNota());
        ga.removerAluno(2003L);
    }
}
