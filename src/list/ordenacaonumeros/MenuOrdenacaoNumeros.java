package list.ordenacaonumeros;

import java.util.Scanner;

public class MenuOrdenacaoNumeros {
    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu Ordenação de Números ===");
            System.out.println("1. Adicionar número");
            System.out.println("2. Exibir números em ordem crescente");
            System.out.println("3. Exibir números em ordem decrescente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número a ser adicionado: ");
                    int numero = scanner.nextInt();
                    numeros.adicionarNumero(numero);
                    System.out.println("Número adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nNúmeros em ordem crescente:");
                    System.out.println(numeros.ordenarAscendente());
                    break;

                case 3:
                    System.out.println("\nNúmeros em ordem decrescente:");
                    System.out.println(numeros.ordenarDescendente());
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
