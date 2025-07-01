package set.listatarefas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet = new HashSet<>();

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefasRemovida = new Tarefa();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (Objects.equals(t.getDescricao(), descricao)) {
                    tarefasRemovida = t;
                    break;
                }
            }
            tarefaSet.remove(tarefasRemovida);
        }
    }

    public void exibirTarefas() {
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                System.out.println(t.toString());
            }
        }
    }

    public void contarTarefas() {
        System.out.println(tarefaSet.size());
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.isFoiConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (!t.isFoiConcluida()) {
                    tarefasPendentes.add(t);
                }
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao() != null && t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setFoiConcluida(true);
                    return;
                }
            }
        throw new IllegalArgumentException("erro: a tarefa não existe.");
        }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t : tarefaSet) {
            if (t.getDescricao() != null && t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setFoiConcluida(false);
                return;
            }
        }
        throw new IllegalArgumentException("erro: a tarefa não existe.");
    }

    public void limparListaTarefas() {
        if (tarefaSet.isEmpty()) {
            throw new IllegalStateException("erro: a lista já está vazia.");
        }
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        var listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Treinar Jiu");
        listaTarefas.adicionarTarefa("Fazer alongamentos");
        listaTarefas.adicionarTarefa("Estudar Java");

        listaTarefas.exibirTarefas();
        listaTarefas.contarTarefas();
        listaTarefas.marcarTarefaConcluida("Estudar Java");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());
    }
}
