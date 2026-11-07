public class Revista extends ItemBiblioteca{
    public Revista(int codigo, String titulo){
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDias() {
        return 7;
    }

    @Override
    public double getMultaDia() {
        return 1.0;
    }
}