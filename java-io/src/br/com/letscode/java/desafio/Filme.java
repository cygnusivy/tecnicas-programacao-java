package br.com.letscode.java.desafio;

public class Filme {
    private String imdbId;
    private String titulo;
    private int qdtVotos;
    private double pontuacao;

    public Filme() {
    }

    public Filme(String imdbId, String titulo, int qdtVotos, double pontuacao) {
        this.imdbId = imdbId;
        this.titulo = titulo;
        this.qdtVotos = qdtVotos;
        this.pontuacao = pontuacao;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQdtVotos() {
        return qdtVotos;
    }

    public void setQdtVotos(int qdtVotos) {
        this.qdtVotos = qdtVotos;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Filme{" +
            "imdbId='" + imdbId + '\'' +
            ", titulo='" + titulo + '\'' +
            ", qdtVotos=" + qdtVotos +
            ", pontuacao=" + pontuacao +
            '}';
    }
}
