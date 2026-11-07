public class DVD extends ItemBiblioteca{
    public DVD(int codigo, String titulo){
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDias(){
        return 7;
    }

    @Override
    public double getMultaDia() {
        return 0.75;
    }
}
