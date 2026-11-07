public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada = 0;

    public Usuario(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public abstract int getLimiteItens();

    void registrarEmprestimo(){
        quantidadeEmprestada ++;
    }
    void registrarDevolucao(){
        quantidadeEmprestada --;
    }
}