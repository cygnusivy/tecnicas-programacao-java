package br.com.letscode.java.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesAlternative {
    
    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream(getInputFilePath());
            FileOutputStream out = new FileOutputStream(getOutputFilePath())
        ) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static String getInputFilePath() {
        return System.getProperty("user.home") + "/Downloads/xanadu.txt";
    }

    private static String getOutputFilePath() {
        File outputDir = new File(System.getProperty("java.io.tmpdir") + "/letscode/");
        if ( outputDir.mkdirs() ) {
            System.out.println("Criando diretórios intermediários.");
        }
        return outputDir.getAbsolutePath() + "outagain.txt";
    }
}
