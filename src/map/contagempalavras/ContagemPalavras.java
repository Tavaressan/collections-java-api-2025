package map.contagempalavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private final Map<String, Integer> palavrasMap = new HashMap<>();

    public void adicionarPalavra(String palavra, Integer contagem) {
        if (palavra == null || palavra.trim().isEmpty()) {
            throw new IllegalArgumentException("A palavra não pode ser nula ou vazia.");
        }
        if (contagem == null || contagem < 0) {
            throw new IllegalArgumentException("A contagem não pode ser nula ou negativa.");
        }
        palavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (palavra == null || palavra.trim().isEmpty()) {
            throw new IllegalArgumentException("A palavra não pode ser nula ou vazia.");
        }
        if (palavrasMap.isEmpty()) {
            throw new IllegalStateException("A contagem está vazia.");
        }

        Integer palavraRemovida = palavrasMap.remove(palavra);
        if (palavraRemovida == null) {
            throw new IllegalArgumentException("A palavra '" + palavra + "' não está na contagem.");
        }
        System.out.println("A palavra '" + palavra + "' foi removida com sucesso.");
    }

    public void exibirContagemPalavras() {
        if (palavrasMap.isEmpty()) {
            throw new IllegalStateException("A contagem está vazia.");
        }
        palavrasMap.forEach((palavra, contagem) ->
                System.out.printf("Palavra: '%s', Contagem: %d\n", palavra, contagem));
    }

    public void encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = "";
        int numeroPalavraMaisFrequente = 0;
        for (Map.Entry<String, Integer> entry : palavrasMap.entrySet()) {
            int valor = entry.getValue();
            if (numeroPalavraMaisFrequente < valor) {
                numeroPalavraMaisFrequente = valor;
                palavraMaisFrequente = entry.getKey();
            }
        }
        System.out.printf("Palavra mais frequente: '%s' foi usada %d vezes.\n", palavraMaisFrequente, numeroPalavraMaisFrequente);
    }

        public static void main (String[]args){
            ContagemPalavras cp = new ContagemPalavras();

            cp.adicionarPalavra("Palavra", 17);
            cp.adicionarPalavra("Valor", 16);
            cp.adicionarPalavra("Paralelepípedo", 1);
            cp.adicionarPalavra("Mote", 17);

            cp.encontrarPalavraMaisFrequente();
            cp.exibirContagemPalavras();
            cp.removerPalavra("Mote");
            cp.exibirContagemPalavras();
        }


    }
