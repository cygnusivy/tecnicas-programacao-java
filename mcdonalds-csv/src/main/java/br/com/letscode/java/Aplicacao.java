package br.com.letscode.java;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplicacao {

    private List<MenuItem> menuItems;

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();
        app.prepararLeituraArquivoCsv();
        //mostrar o hamburguer com mais caloria
        app.findHamburguerMaisCalorico("Beef & Pork");
        app.findHamburguerMaisCalorico("Chicken & Fish");
        //categoria que mais repete
        app.getCategoriaComMaisItens();
        //qual mais calorico
        app.getItemMaisCalorico();
        //hambúrguer com maior valor proteico
        app.findHamburguerMaisProteico("Beef & Pork");
        app.findHamburguerMaisProteico("Chicken & Fish");
    }

    private void findHamburguerMaisProteico(String categoria) {
        System.out.println("#4 - hambúrguer com maior valor proteico - " + categoria);
        this.menuItems.stream()
            .filter(item -> item.getCategory().equals(categoria))
            .filter(item -> !item.getName().contains("piece"))
            .max(Comparator.comparingInt(MenuItem::getProtein))
            .ifPresent(System.out::println);
    }

    private void getItemMaisCalorico() {
        System.out.println("#3 - o item mais calórico.");
        this.menuItems.stream()
            .max(Comparator.comparingInt(MenuItem::getCalories))
            .ifPresent(System.out::println);
    }

    private void getCategoriaComMaisItens() {
        System.out.println("#2 - categoria que mais repete");
        Map<String, Long> categorias = this.menuItems.stream()
            .map(MenuItem::getCategory)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        categorias.entrySet().stream()
            .max(Comparator.comparingLong(Entry::getValue))
            .ifPresent(c -> System.out.println(c.getKey() + " - " + c.getValue() + " itens."));
    }

    private void findHamburguerMaisCalorico(String categoria) {
        this.escreverArquivoCsv("#1 - o hambúrguer com mais calorias - " + categoria + "\n");
        this.menuItems.stream()
            .filter(item -> item.getCategory().equals(categoria))
            .filter(item -> !item.getName().contains("piece"))
            .max(Comparator.comparingInt(MenuItem::getCalories))
            .ifPresent(mi -> this.escreverArquivoCsv(mi.toCsv()));
    }

    private void escreverArquivoCsv(String linha) {
        String filePath = getFilepathFromResourceAsStream("respostas.csv");
        try {
            Files.writeString(Path.of(filePath), linha, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepararLeituraArquivoCsv() {
        String filepath = getFilepathFromResourceAsStream("mcdonalds-menu.csv");
        try (Stream<String> lines = Files.lines(Path.of(filepath))) {
            this.menuItems = lines.skip(1)
                .map(MenuItem::fromLine)
                .collect(Collectors.toList());// Java 11
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFilepathFromResourceAsStream(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);
        File file = new File(url.getFile());
        return file.getPath();
    }

}
