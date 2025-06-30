package list.somanumeros;

import java.util.Scanner;

public class MenuSomaNumeros {
    public static void main(String[] args) {
        SomaNumeros numeros = new SomaNumeros();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu Soma Números ===");
            System.out.println("1. Adicionar número");
            System.out.println("2. Calcular soma");
            System.out.println("3. Encontrar maior número");
            System.out.println("4. Encontrar menor número");
            System.out.println("5. Exibir números");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o número a ser adicionado: ");
                        int numero = scanner.nextInt();
                        numeros.adicionarNumeros(numero);
                        System.out.println("Número adicionado com sucesso!");
                        break;

                    case 2:
                        System.out.println("Soma dos números: " + numeros.calcularSoma());
                        break;

                    case 3:
                        System.out.println("Maior número: " + numeros.encontrarMaiorNumero());
                        break;

                    case 4:
                        System.out.println("Menor número: " + numeros.encontrarMenorNumero());
                        break;

                    case 5:
                        System.out.println("\nNúmeros na lista:");
                        numeros.exibirNumeros();
                        break;

                    case 0:
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

        } while (opcao != 0);

        scanner.close();
    }
}
