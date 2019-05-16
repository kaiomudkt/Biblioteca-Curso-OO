package visao;

import static objetoAcessoDados.DAOBiblioteca.clientes;
import objetoAcessoDados.DAOBiblioteca;
import contole.ControlePrincipalBibliotecario;

public class Teste {

    public static void main(String[] args) {
        //DAOBiblioteca biblioteca = new DAOBiblioteca();
        ControlePrincipalBibliotecario cBiblioteca = new ControlePrincipalBibliotecario();
        cBiblioteca.cadastrarLivro("Cronicas", 2, "Autor1", "cpfAutor1");

        cBiblioteca.cadastrarCliente("Diego", "cpfCliente1");

        cBiblioteca.emprestarLivro("Cronicas", "cpfCliente1");

        //System.out.println("Clientes: " + clientes);
        //System.out.println("Livros: "+livros);

        clientes.get("cpfCliente1").pritLivrosEmprestados();
    }
}
