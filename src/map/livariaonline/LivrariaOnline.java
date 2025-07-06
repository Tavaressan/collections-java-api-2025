package map.livariaonline;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

public class LivrariaOnline {
    private final Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulivrariaOnline, String autor, double preco) {
        livrosMap.put(link, new Livro(titulivrariaOnline,autor,preco));
    }

    public void removerLivro(String titulivrariaOnline) {
        livrosMap.remove(titulivrariaOnline);
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        return livrosMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Livro::getPreco)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosAutor = new ArrayList<>();
        if (!livrosMap.isEmpty()) {
            for (Livro l : livrosMap.values()) {
                if (Objects.equals(l.getAutor(), autor)) {
                    livrosAutor.add(l);
                }
            }
            if (livrosAutor.isEmpty()) throw new IllegalArgumentException("erro: Este livro não está listado.");
        }
        return livrosAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livroMaisCaro = new Livro("","",Double.MIN_VALUE);
        if (!livrosMap.isEmpty()) {
            for (Livro l : livrosMap.values()) {
                if (l.getPreco() > livroMaisCaro.getPreco()) {
                    livroMaisCaro = l;
                }
            }
        }
        return livroMaisCaro;
    }

    public Livro exibirLivroMaisBarato() {
        Livro livroMaisBarato = new Livro("","",Double.MAX_VALUE);
        if (!livrosMap.isEmpty()) {
            for (Livro l : livrosMap.values()) {
                if (l.getPreco() < livroMaisBarato.getPreco()) {
                    livroMaisBarato = l;
                }
            }
        }
        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        // Adiciona livros para teste
        livrariaOnline.adicionarLivro("https://livro1.com", "Java Efetivo", "Joshua Bloch", 150.0);
        livrariaOnline.adicionarLivro("https://livro2.com", "Clean Code", "Robert Martin", 120.0);
        livrariaOnline.adicionarLivro("https://livro3.com", "Domain-Driven Design", "Eric Evans", 180.0);
        livrariaOnline.adicionarLivro("https://livro4.com", "Refactoring", "Martin Fowler", 140.0);
        livrariaOnline.adicionarLivro("https://livro5.com", "Padrões de Projeto", "Eric Evans", 130.0);

        System.out.println("\n=== Teste de Ordenação por Preço ===");
        Map<String, Livro> livrosOrdenados = livrariaOnline.exibirLivrosOrdenadosPorPreco();
        double precoAnterior = 0;
        boolean ordenacaoCorreta = true;

        for (Map.Entry<String, Livro> entry : livrosOrdenados.entrySet()) {
            Livro livro = entry.getValue();
            System.out.printf("Livro: %s - Preço: R$ %.2f%n", livro.getTitulo(), livro.getPreco());

            if (livro.getPreco() < precoAnterior) {
                ordenacaoCorreta = false;
                System.out.println("ERRO: Livros não estão ordenados corretamente por preço!");
                break;
            }
            precoAnterior = livro.getPreco();
        }
        if (ordenacaoCorreta) {
            System.out.println("SUCESSO: Livros estão corretamente ordenados por preço!");
        }

        System.out.println("\n=== Teste de Pesquisa por Autor ===");
        List<Livro> livrosEric = livrariaOnline.pesquisarLivrosPorAutor("Eric Evans");
        System.out.println("Livros do autor Eric Evans:");
        if (livrosEric.size() == 2) {
            System.out.println("SUCESSO: Encontrados 2 livros do autor Eric Evans");
            for (Livro livro : livrosEric) {
                if (!livro.getAutor().equals("Eric Evans")) {
                    System.out.println("ERRO: Encontrado livro com autor diferente de Eric Evans!");
                }
                System.out.printf("- %s (R$ %.2f)%n", livro.getTitulo(), livro.getPreco());
            }
        } else {
            System.out.println("ERRO: Número incorreto de livros encontrados!");
        }

        System.out.println("\n=== Teste do Livro Mais Caro ===");
        Livro livroMaisCaro = livrariaOnline.obterLivroMaisCaro();
        if (livroMaisCaro.getTitulo().equals("Domain-Driven Design") && livroMaisCaro.getPreco() == 180.0) {
            System.out.println("SUCESSO: Livro mais caro encontrado corretamente!");
        } else {
            System.out.println("ERRO: Livro mais caro incorreto!");
        }
        System.out.printf("Livro mais caro: %s - R$ %.2f%n", livroMaisCaro.getTitulo(), livroMaisCaro.getPreco());

        System.out.println("\n=== Teste do Livro Mais Barato ===");
        Livro livroMaisBarato = livrariaOnline.exibirLivroMaisBarato();
        if (livroMaisBarato.getTitulo().equals("Clean Code") && livroMaisBarato.getPreco() == 120.0) {
            System.out.println("SUCESSO: Livro mais barato encontrado corretamente!");
        } else {
            System.out.println("ERRO: Livro mais barato incorreto!");
        }
        System.out.printf("Livro mais barato: %s - R$ %.2f%n", livroMaisBarato.getTitulo(), livroMaisBarato.getPreco());
    }
}
