import list.CarrinhoDeCompras;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu Carrinho de Compras ===");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Exibir itens");
            System.out.println("4. Calcular valor total");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço do item: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    carrinho.adicionarItem(nome, preco, quantidade);
                    System.out.println("Item adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do item a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    carrinho.removerItem(nomeRemover);
                    System.out.println("Item removido com sucesso!");
                    break;

                case 3:
                    System.out.println("\nItens no carrinho:");
                    carrinho.exibirItens();
                    break;

                case 4:
                    System.out.printf("Valor total do carrinho: R$ %.2f%n",
                        carrinho.calcularValorTotal());
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}