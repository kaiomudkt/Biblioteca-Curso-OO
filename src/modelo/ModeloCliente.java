package modelo;

import assistente.Pessoa;
import static objetoAcessoDados.DAOBiblioteca.livros;

public class ModeloCliente extends Pessoa {

    private ModeloLivro[] livrosEmprestados;
    private final int qtdLivro = 3;

    public ModeloCliente(String nome, String cpf) {
        super(nome, cpf);
        this.livrosEmprestados = new ModeloLivro[qtdLivro];
    }

    public boolean contemLivro(String nome) {
        for (int i = 0; i < qtdLivro; i++) {
            if (livrosEmprestados[i] != null) {
                if (livrosEmprestados[i].getNome().equals(nome)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ModeloLivro[] getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosLocados(ModeloLivro[] livrosLocados) {
        this.livrosEmprestados = livrosLocados;
    }

    public boolean addLivroListaEmprestados(ModeloLivro livro) {
        if (!contemLivro(livro.getNome())) {
            for (int i = 0; i < livrosEmprestados.length; i++) {
                if (livrosEmprestados[i] == null) {
                    livrosEmprestados[i] = livro;
                    return true;
                }
            }
        }
        return false;
    }

    public void pritLivrosEmprestados() {
        System.out.println("Livros emprestados: ");
        for (int i = 0; i < livrosEmprestados.length; i++) {
            if (livrosEmprestados[i] != null) {
                System.out.print(livrosEmprestados[i] + " a");
            }
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return getNome() + " " + getCpf() + " " + getLivrosEmprestados(); //To change body of generated methods, choose Tools | Templates.
    }

}
