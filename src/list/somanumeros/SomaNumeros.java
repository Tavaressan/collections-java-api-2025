package list.somanumeros;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private static final String ERRO_LISTA_VAZIA = "erro: a lista está vazia.";
    List<Integer> numerosLista;

    public SomaNumeros() {
        this.numerosLista = new ArrayList<>();
    }

    public void adicionarNumeros(int numero) {
        numerosLista.add(numero);
    }

    public int calcularSoma() {
        int somaNumeros = 0;
        if (!numerosLista.isEmpty()) {
            for (int n : numerosLista) {
                somaNumeros += n;
            }
        } else throw new IllegalStateException(ERRO_LISTA_VAZIA);
        return somaNumeros;
    }

    public int encontrarMaiorNumero() {
        int maiorNumero = -999999999;
        if (!numerosLista.isEmpty()) {
            for (int n : numerosLista) {
                if (n > maiorNumero) maiorNumero = n;
            }
        } else throw new IllegalStateException(ERRO_LISTA_VAZIA);
        return maiorNumero;
    }

    public int encontrarMenorNumero() {
        int menorNumero = 999999999;
        if (!numerosLista.isEmpty()) {
            for (int n : numerosLista) {

                if (n < menorNumero) menorNumero = n;
            }
        } else throw new IllegalStateException(ERRO_LISTA_VAZIA);
        return menorNumero;
    }

    public void exibirNumeros() {
        for (int n : numerosLista) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        var s = new SomaNumeros();
        s.adicionarNumeros(10);
        s.adicionarNumeros(15);

        System.out.println(s.calcularSoma());
        System.out.println(s.encontrarMaiorNumero());
        System.out.println(s.encontrarMenorNumero());
        s.exibirNumeros();
    }
}


