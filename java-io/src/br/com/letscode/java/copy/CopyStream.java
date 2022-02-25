package br.com.letscode.java.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyStream {

    public static void main(String[] args) throws IOException {
        Files.write(Path.of("hello.txt"), "hello files".getBytes());
    }

}
