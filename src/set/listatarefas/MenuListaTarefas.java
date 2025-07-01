package set.listatarefas;

import java.util.Scanner;
import java.util.Set;

public class MenuListaTarefas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTarefas lista = new ListaTarefas();
        int opcao;

        do {
            System.out.println("\n=== Menu Lista de Tarefas ===");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Exibir tarefas");
            System.out.println("4. Contar tarefas");
            System.out.println("5. Exibir tarefas concluídas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite a descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        lista.adicionarTarefa(descricao);
                        System.out.println("Tarefa adicionada com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite a descrição da tarefa a remover: ");
                        String tarefaRemover = scanner.nextLine();
                        lista.removerTarefa(tarefaRemover);
                        System.out.println("Tarefa removida com sucesso!");
                        break;

                    case 3:
                        System.out.println("\nTarefas na lista:");
                        lista.exibirTarefas();
                        break;

                    case 4:
                        System.out.print("Número total de tarefas: ");
                        lista.contarTarefas();
                        break;

                    case 5:
                        System.out.println("\nTarefas concluídas:");
                        Set<Tarefa> concluidas = lista.obterTarefasConcluidas();
                        for (Tarefa t : concluidas) {
                            System.out.println(t);
                        }
                        break;

                    case 0:
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (opcao != 0);

        scanner.close();
    }
}
