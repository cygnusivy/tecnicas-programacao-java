package br.com.letscode.java;

public class Main {

    public static void main(String[] args) {
/*
Crie um validador para nome completo: deve ter nome e sobrenome, cada um com no mínimo duas letras. Não aceite caracteres especiais.
Crie um validador para telefones: deve aceitar ambos fixo e celular.
Crie um validador de e-mail.
Crie um validador de CPF.
Crie um validador de CNPJ.
Crie um validador de datas onde a pessoa informa o padrão (por exemplo, dd/MM/yyyy) que será aceito e faça a validação.
 */
        validaNomeSobrenome();
        validaTelefoneFixoCelular();
        validaEmail();
        validaCpf();
        validaCnpj();
        validaDataPorPadrao();
    }

    private static void validaNomeSobrenome() {
        String nome = "Raissa do Brasil";
        String nomesobrenome = "^([A-Z][a-z]{2,})(\\s(d[eoa])?(\\s[A-Z][a-z]{2,}))+$";
        System.out.println(nome.matches(nomesobrenome));
    }

    private static void validaTelefoneFixoCelular() {

    }

    private static void validaEmail() {

    }

    private static void validaCpf() {

    }

    private static void validaCnpj() {

    }

    private static void validaDataPorPadrao() {

    }
}
