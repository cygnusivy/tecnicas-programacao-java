package br.com.letscode.java.desafio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplicacao {

    public static void main(String[] args) {
        //1 - ler o arquivo filmes.csv
        //2 - converter o arquivo em objetos Filme
        //3 - exibir a lista no console
        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.home"), "filmes.csv"))) {
            List<String> linhas = stream.collect(Collectors.toList());
            List<Filme> filmes = converterEmFilme(linhas);
            filmes.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Filme> converterEmFilme(List<String> linhas) {
        //Generics
        List<Filme> resultado = new ArrayList<>();//diamond operator
        for (String linha : linhas) {
            //1 - split para ler cada campo da linha
            //2 - instanciar um objeto Filme
            //3 - adicionar na lista de resultado
            String[] campos = linha.split(",");
            Filme novoFilme = new Filme(campos[0], campos[1],
                Integer.parseInt(campos[2]),
                Double.parseDouble(campos[3]));
            resultado.add(novoFilme);
        }
        return resultado;
    }
}
