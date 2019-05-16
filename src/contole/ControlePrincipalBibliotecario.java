package contole;

import modelo.ModeloAutor;
import modelo.ModeloCliente;
import modelo.ModeloLivro;

public class ControlePrincipalBibliotecario {

    public void cadastrarLivro(String nome, int qtdCopias, String nomeAutor, String cpfAutor) {
        ControleLivro cLivro = new ControleLivro();
        if (new ControleAutor().contem(cpfAutor)) {
            cLivro.cadastrar(new ModeloLivro(nome, qtdCopias, cpfAutor));
        } else {
            cLivro.cadastrar(new ModeloLivro(nome, qtdCopias, new ModeloAutor(nomeAutor, cpfAutor)));
        }
    }

    public void removerLivro(String nomeLivro) {
        ControleLivro cLivro = new ControleLivro();
        if (cLivro.contem(nomeLivro)) {
            cLivro.remover(nomeLivro);
        }
    }

    public void cadastrarCliente(String nome, String cpf) {
        ControleCliente cCliente = new ControleCliente();
        if (cCliente.contem(cpf)) {
            System.out.println("CPF já cadastrado como Cliente.");
        } else {
            cCliente.cadastrar(new ModeloCliente(nome, cpf));
        }
    }

    public void removeCliente(String cpf) {
        ControleCliente cCliente = new ControleCliente();
        if (!cCliente.contem(cpf)) {
            System.out.println("Não existe este CPF como cliente.");
            return;//encerra o método
        }
        cCliente.remover(cpf);
    }

    public void emprestarLivro(String nomeLivro, String cpf) {
        ControleCliente cCliente = new ControleCliente();
        if (cCliente.contem(cpf)) {
            if (new ControleLivro().qtdCopiasLivro(nomeLivro) > 0) {
                cCliente.pegarLivroEmprestado(nomeLivro, cpf);
            } else {
                System.out.println("Não há cópias disponiveis.");
            }
        } else {
            System.out.println("Cliente não cadastrado");
        }
    }

    /**
     * @nomeLivro livro a ser devolvido
     * @cpf cliente que esta devolvendo
     */
    public void clienteDevolveLivro(String nomeLivro, String cpf) {
        ControleCliente cCliente = new ControleCliente();
        if (cCliente.contem(cpf)) {
            if (new ControleLivro().contem(nomeLivro)) {
                cCliente.devolverLivroEmprestado(nomeLivro, cpf);
            }else{
                System.out.println("Livro não cadastrado para poder devolver");
            }
        } else {
            System.out.println("Cliente não cadastrado");
        }
    }

}
