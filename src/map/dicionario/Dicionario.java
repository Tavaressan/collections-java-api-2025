package map.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private final Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
            return;
        }
        throw new IllegalArgumentException("erro: palavra não existe no dicionário.");
    }

    public void exibirPalavras () {
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            return dicionarioMap.get(palavra);
        }
        throw new IllegalArgumentException("erro: palavra não existe no dicionário.");
    }

    public static void main(String[] args) {
        var dicionario = new Dicionario();

        dicionario.adicionarPalavra("Palavra", "unidade da língua escrita, situada entre dois espaços em branco, ou entre espaço em branco e sinal de pontuação.");
        dicionario.adicionarPalavra("Demissão", "dispensa dos serviços de pessoa empr. no quadro de funcionários de uma empresa.");
        dicionario.adicionarPalavra("Estágio", "período de prática em posto, serviço ou empresa para que um médico, um advogado etc. se habilite a exercer bem sua profissão.");

        dicionario.exibirPalavras();
        System.out.println(dicionario.pesquisarPorPalavra("Estágio"));
        dicionario.removerPalavra("Demissão");
        dicionario.exibirPalavras();

    }
}
