package visao;

import contole.ControleBibliotecario;

public class Teste {

    public static void main(String[] args) {
        ControleBibliotecario cBiblioteca = new ControleBibliotecario();
        
        cBiblioteca.cadastrarLivro("Cronicas", 2, "Autor1", "cpfAutor1");
        cBiblioteca.cadastrarLivro("LeagueOfLegends", 3, "Autor2", "cpfAutor2");

        cBiblioteca.cadastrarCliente("Diego", "cpfCliente1");

        cBiblioteca.ClientePegaLivro("Cronicas", "cpfCliente1");
        
        cBiblioteca.getCliente("cpfCliente1").pritarLivrosEmprestados();

//        System.out.println("Clientes: " + clientes);
//        System.out.println("Livros: "+livros);
//
//        clientes.get("cpfCliente1").pritarLivrosEmprestados();
    }
}
