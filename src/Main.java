public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca(10);
        b.cadastrarItem(new Livro(1, "Percy Jackson"));
        b.cadastrarItem(new Livro(2, "Brás Cubas"));
        b.cadastrarItem(new Revista(3, "Veja"));
        b.cadastrarItem(new Revista(4, "o Sentinela"));
        b.cadastrarItem(new DVD(5, "Matrix"));

        Aluno maria = new Aluno("Maria");

        b.listarAcervo();

        b.emprestar(maria, 1);   // ok
        b.emprestar(maria, 2);   // ok
        b.emprestar(maria, 3);   // ok
        b.emprestar(maria, 4);   // RECUSADO: limite atingido

        b.devolver(maria, 1, 20); // livro: 6 dias de atraso -> R$ 3.0

        b.emprestar(maria, 5); // ok

        b.devolver(maria, 5, 10); // DVD: 3 dias de atraso -> R$ 2.25

        b.listarAcervo();
    }
}