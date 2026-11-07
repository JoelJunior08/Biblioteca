public abstract class ItemBiblioteca {
    private int codigo;
    private String titulo;
    private boolean disponivel = true;

    public ItemBiblioteca(int codigo, String titulo){
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getTitulo(){
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public abstract int getPrazoDias();

    public abstract double getMultaDia();

    void marcarComoEmprestado(){
        disponivel = false;
    }

    void marcarComoDisponivel(){
        disponivel = true;
    }
}
