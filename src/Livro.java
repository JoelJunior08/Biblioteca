public class Livro extends ItemBiblioteca{
    public Livro(int codigo, String titulo){
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDias() {
        return 14;
    }

    @Override
    public double getMultaDia() {
        return 0.50;
    }
}
