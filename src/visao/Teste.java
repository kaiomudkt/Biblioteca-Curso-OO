package visao;

import controle.ControleBibliotecario;

public class Teste {

    public static void main(String[] args) {
        ControleBibliotecario cBiblioteca = new ControleBibliotecario();
        
        cBiblioteca.cadastrarLivro("Cronicas", 10, "Autor1", "cpfAutor1");
        cBiblioteca.cadastrarLivro("LeagueOfLegends", 5, "Autor2", "cpfAutor2");
        cBiblioteca.cadastrarLivro("Dota2", 1, "Autor2", "cpfAutor2");

        cBiblioteca.cadastrarCliente("Diego", "cpfCliente1");
        

        cBiblioteca.ClientePegaLivro("Cronicas", "cpfCliente1");
        cBiblioteca.ClientePegaLivro("Cronicas", "cpfCliente1");
        cBiblioteca.ClientePegaLivro("LeagueOfLegends", "cpfCliente1");
        
        //System.out.println(cBiblioteca.getCliente("cpfCliente1").toString());;
        //System.out.println(cBiblioteca.getAutor("cpfAutor1").toString());
        //System.out.println(cBiblioteca.getLivro("LeagueOfLegends").toString());
        
        //cBiblioteca.getCliente("cpfCliente1").pritarLivrosEmprestados();

        
        //cBiblioteca.listaLivrosCadastrados();
        //cBiblioteca.listaLivrosDisponiveis();
        //cBiblioteca.listaClientes();
        cBiblioteca.listaAutores();
    }
}
