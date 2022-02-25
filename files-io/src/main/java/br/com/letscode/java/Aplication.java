package br.com.letscode.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplication {
    //Realiza uma cópia do arquivo "xanadu.txt" para "outagain.txt"
    public static void main(String[] args) throws IOException {
//        tryWithResources();
//        scannerReading();
//        scannerPaths();
        Path path = Paths.get(System.getProperty("user.home"), "lines.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(System.out::println);
        }
    }

    private static void scannerPaths() throws IOException {
        Path path = Paths.get(System.getProperty("user.home"), "lines.txt");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    private static void scannerReading() throws IOException {
        try(
            Scanner scanner = new Scanner(new File("xanadu.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("outagain.txt"))
            ) {
            while(scanner.hasNext()) {
                out.write(scanner.nextLine());
                out.newLine();
            }
        }
    }

    private static void tryWithResources() throws IOException {
        try (
            FileInputStream in = new FileInputStream("xanadu.txt");
            FileOutputStream out = new FileOutputStream("outagain.txt")
        ) {
            int c;
            while ((c = in.read()) != -1) {
//                if (c >= 65 && c <= 90) {
//                    out.write(Character.toLowerCase(c));
//                } else if (c >= 97 && c <= 122) {
//                    out.write(Character.toUpperCase(c));
//                } else {
                    out.write(c);
//                }
            }
        }
    }
}
