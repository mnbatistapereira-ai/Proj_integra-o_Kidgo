public class Aluno {
    private String nomeAluno;
    private String enderecoAluno;
    private String nomeResponsavel;
    private String telefoneResponsavel;
    private String nomeEscola;
    private String enderecoEscola;

    public Aluno(String nomeAluno, String enderecoAluno,
            String nomeResponsavel, String telefoneResponsavel,
            String nomeEscola, String enderecoEscola) {
        this.nomeAluno = nomeAluno;
        this.enderecoAluno = enderecoAluno;
        this.nomeResponsavel = nomeResponsavel;
        this.telefoneResponsavel = telefoneResponsavel;
        this.nomeEscola = nomeEscola;
        this.enderecoEscola = enderecoEscola;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getEnderecoAluno() {
        return enderecoAluno;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public String getEnderecoEscola() {
        return enderecoEscola;
    }
}
