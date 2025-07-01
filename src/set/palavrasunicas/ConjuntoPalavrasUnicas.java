package set.palavrasunicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private final Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra) {
        String palavraRemovida = null;
        if (palavrasUnicas.isEmpty()) {
            throw new IllegalStateException("erro: a coleção está vazia\n");
        }
        for (String p : palavrasUnicas) {
            if (p.equalsIgnoreCase(palavra)) {
                palavraRemovida = p;
                break;
            }
        }
        palavrasUnicas.remove(palavraRemovida);
    }

    public void verificarPalavra(String palavra) {
        if (palavrasUnicas.isEmpty()) {
            throw new IllegalStateException("erro: a coleção está vazia\n");
        }
        for (String p : palavrasUnicas) {
            if (Objects.equals(palavra, p)) {
                System.out.printf("A palavra '%s' está presente na coleção\n", p);
                break;
            } else throw new IllegalStateException("erro: a palavra não se encontra na coleção.");
        }
    }

    public void exibirPalavrasUnicas() {
        for (String p : palavrasUnicas) System.out.println(p);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas c = new ConjuntoPalavrasUnicas();
        c.adicionarPalavra("Palavras");
        c.adicionarPalavra("Ao");
        c.adicionarPalavra("Vento");
        c.adicionarPalavra("Palavras");
        c.exibirPalavrasUnicas();
        c.verificarPalavra("Palavras");
        c.removerPalavra("Vento");
        c.exibirPalavrasUnicas();
    }
}
