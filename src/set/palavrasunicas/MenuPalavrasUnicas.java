package set.palavrasunicas;

import java.util.Scanner;

public class MenuPalavrasUnicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas();
        int opcao;

        do {
            System.out.println("\n=== Menu Conjunto de Palavras Únicas ===");
            System.out.println("1. Adicionar palavra");
            System.out.println("2. Remover palavra");
            System.out.println("3. Verificar palavra");
            System.out.println("4. Exibir palavras únicas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite a palavra para adicionar: ");
                        String palavraAdd = scanner.nextLine();
                        conjunto.adicionarPalavra(palavraAdd);
                        System.out.println("Palavra adicionada com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite a palavra para remover: ");
                        String palavraRemover = scanner.nextLine();
                        conjunto.removerPalavra(palavraRemover);
                        System.out.println("Palavra removida com sucesso!");
                        break;

                    case 3:
                        System.out.print("Digite a palavra para verificar: ");
                        String palavraVerificar = scanner.nextLine();
                        conjunto.verificarPalavra(palavraVerificar);
                        break;

                    case 4:
                        System.out.println("\nPalavras únicas no conjunto:");
                        conjunto.exibirPalavrasUnicas();
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
