package contole;

import modelo.ModeloAutor;
import modelo.ModeloCliente;
import modelo.ModeloLivro;

public class ControlePrincipalBiblioteca {

    public void cadastrarLivro(String nome, int qtdCopias, String nomeAutor, String cpfAutor) {
        if (new ControleAutor().contem(cpfAutor)) {
            ModeloLivro livro = new ModeloLivro(nome, qtdCopias, cpfAutor);
        } else {
            new ControleLivro().cadastrar(nome, qtdCopias, new ModeloAutor(nomeAutor, cpfAutor));
        }
    }

    public boolean cadastrarCliente(String nome, String cpf) {
        if (new ControleCliente().contem(cpf)) {
            return false;
        } else {
            
            new ControleCliente().cadastrar(new ModeloCliente(nome, cpf));
            return true;
        }
    }

    public boolean emprestarLivro(String nomeLivro, String cpf) {
        new ControleCliente().pegarLivroEmprestado(nomeLivro, cpf);
        return true;
    }

    public boolean clienteDevolveLivro() {

        return true;
    }

}
