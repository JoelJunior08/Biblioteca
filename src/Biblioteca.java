public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private int totalItens = 0;

    public Biblioteca(int capacidade){
        acervo = new ItemBiblioteca[capacidade];
    }

    public boolean cadastrarItem(ItemBiblioteca item){
        if(totalItens == acervo.length){
            System.err.println("ERRO: O acervo está cheio!");
            return false;
        }else {
            acervo[totalItens] = item;
            totalItens++;
            return true;
        }
    }

    public void listarAcervo(){
        for(int i = 0; i < totalItens; i++){
            ItemBiblioteca item = acervo[i];
            System.out.println(item.getCodigo() + " | " + item.getTitulo() + " | " + item.getPrazoDias() + " | " + item.getMultaDia() + " | " + (item.isDisponivel() ? "Disponível" : "Emprestado"));
        }
    }

    private ItemBiblioteca buscarPorCodigo(int codigo){
        for(int i = 0; i < totalItens; i++){
            if (acervo[i].getCodigo() == codigo){
                return acervo[i];
            }
        }
        return null;
    }

    public boolean emprestar(Usuario usuario, int codigoItem){
        ItemBiblioteca item = buscarPorCodigo(codigoItem);
        if(item == null){
            System.out.println("ERRO: Esse item não existe!");
            return false;
        }
        if(!item.isDisponivel()) {
            System.out.println("ERRO: Esse item não está disponível!");
            return false;
        }
        if(usuario.getQuantidadeEmprestada() >= usuario.getLimiteItens()){
            System.out.println("ERRO: Limite de empréstimos atingido!");
            return false;
        }
        item.marcarComoEmprestado();
        usuario.registrarEmprestimo();
        System.out.println("AVISO: Empréstimo realizado com sucesso!");
        return true;
    }

    public double devolver(Usuario usuario, int codigoItem, int diasComItem){
        ItemBiblioteca item = buscarPorCodigo(codigoItem);
        if(item == null || item.isDisponivel()){
            System.out.println("ERRO: Devolução inválida!");
            return -1;
        }
        int diasAtraso = Math.max(0, diasComItem - item.getPrazoDias());
        double multa = diasAtraso * item.getMultaDia();

        item.marcarComoDisponivel();
        usuario.registrarDevolucao();

        System.out.println("AVISO: Devolução realizada. Multa: R$ " + multa);
        return multa;
    }
}
