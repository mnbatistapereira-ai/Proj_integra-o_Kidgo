public class PontoParada {
    private String nome;
    private String tipo; // "Aluno" ou "Escola"
    private String endereco;

    public PontoParada(String tipo, String nome, String endereco) {
        this.tipo = tipo;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo; 
    }

    public String getNome() { 
        return nome; 
    }

    public String getEndereco() {
        return endereco;
    }

    public String get() {
        return "[" + tipo + "] -> " + nome + " -> " + endereco;
    }
}