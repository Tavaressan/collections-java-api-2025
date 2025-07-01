package set.listatarefas;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean foiConcluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.foiConcluida = false;
    }

    public Tarefa() {
    }

    @Override
    public String toString() {
        return "{'" + descricao + '\'' +
                ", foiConcluida=" + foiConcluida +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFoiConcluida() {
        return foiConcluida;
    }

    public void setFoiConcluida(boolean foiConcluida) {
        this.foiConcluida = foiConcluida;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(descricao, tarefa.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(descricao);
    }
}
