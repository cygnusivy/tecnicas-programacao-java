package br.com.letscode.java.copy;

import br.com.letscode.java.exceptions.CloseException;
import br.com.letscode.java.exceptions.EscritaException;
import br.com.letscode.java.exceptions.LeituraException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        System.out.println("Início do programa");
        try {
            FileInputStream in = getFileInputStream();
            FileOutputStream out = getFileOutputStream();
            int c;
            copyBytes(in, out);
            if (in != null) {
                closeStream(in);
            }
            if (out != null) {
                closeStream(out);
            }
        } catch (LeituraException e) {
            System.err.println("Não foi possível ler o arquivo.");
        } catch (EscritaException e) {
            System.err.println("Não foi possível escrever o arquivo de saída.");
        } catch (CloseException e) {
            System.err.println("Não foi possível fechar o fluxo de dados.");
        }
        System.out.println("Fim do programa");
    }

    private static FileInputStream getFileInputStream() throws LeituraException {
        FileInputStream in;
        try {
            in = new FileInputStream("zanadu.txt");
        } catch (FileNotFoundException e) {
            throw new LeituraException(e);
        }
        return in;
    }

    private static FileOutputStream getFileOutputStream() throws EscritaException {
        FileOutputStream out;
        try {
            out = new FileOutputStream("outagain.txt");
        } catch (FileNotFoundException e) {
            throw new EscritaException(e);
        }
        return out;
    }

    private static void copyBytes(FileInputStream in, FileOutputStream out) throws EscritaException {
        int c;
        try {
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e){
            throw new EscritaException(e);
        }
    }

    private static void closeStream(FileInputStream in) throws CloseException {
        try {
            in.close();
        } catch (IOException e) {
            throw new CloseException(e);
        }
    }

    private static void closeStream(FileOutputStream out) throws CloseException {
        try {
            out.close();
        } catch (IOException e) {
            throw new CloseException(e);
        }
    }
}
