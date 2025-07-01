package set.listaalunos;

import java.util.Scanner;
import java.util.Set;

public class MenuGerenciadorAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();
        int opcao;

        do {
            System.out.println("\n=== Menu Gerenciador de Alunos ===");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Remover aluno");
            System.out.println("3. Exibir alunos por nome");
            System.out.println("4. Exibir alunos por nota");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a matrícula do aluno: ");
                        Long matricula = scanner.nextLong();
                        System.out.print("Digite a média do aluno: ");
                        double media = scanner.nextDouble();
                        gerenciador.adicionarAluno(nome, matricula, media);
                        System.out.println("Aluno adicionado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite a matrícula do aluno a remover: ");
                        long matriculaRemover = scanner.nextLong();
                        gerenciador.removerAluno(matriculaRemover);
                        break;

                    case 3:
                        System.out.println("\nAlunos ordenados por nome:");
                        Set<Aluno> alunosPorNome = gerenciador.exibirAlunosPorNome();
                        for (Aluno aluno : alunosPorNome) {
                            System.out.println(aluno);
                        }
                        break;

                    case 4:
                        System.out.println("\nAlunos ordenados por nota:");
                        Set<Aluno> alunosPorNota = gerenciador.exibirAlunosPorNota();
                        for (Aluno aluno : alunosPorNota) {
                            System.out.println(aluno);
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
