package list.ordenacaonumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private final List<Integer> listaOrdenacaoNumeros;

    public OrdenacaoNumeros() {
        this.listaOrdenacaoNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        listaOrdenacaoNumeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendente = new ArrayList<>(listaOrdenacaoNumeros);
        Collections.sort(numerosAscendente);
        return numerosAscendente;
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDesscendente = new ArrayList<>(listaOrdenacaoNumeros);
        Collections.sort(numerosDesscendente);
        Collections.reverse(numerosDesscendente);
        return numerosDesscendente;
    }


    public static void main(String[] args) {
        var numeros = new OrdenacaoNumeros();
        numeros.adicionarNumero(10);
        numeros.adicionarNumero(11);
        numeros.adicionarNumero(12);
        numeros.adicionarNumero(13);
        numeros.adicionarNumero(14);
        System.out.println(numeros.ordenarAscendente());
        System.out.println(numeros.ordenarDescendente());
    }
}
