package list;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> listaDeCompras;

    public CarrinhoDeCompras() {
        this.listaDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listaDeCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemRemocaoLista = new ArrayList<>();
        for (Item i : listaDeCompras) {
            if (i.getNome().equalsIgnoreCase(nome)) itemRemocaoLista.add(i);
        }
        listaDeCompras.removeAll(itemRemocaoLista);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item i : listaDeCompras) {
            valorTotal += i.getPreco() * i.getQuantidade();
        }
        return valorTotal;
    }

    public void exibirItens () {
        for (Item i : listaDeCompras) {
            System.out.println(i.toString());
        }
    }
}
