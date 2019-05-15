package contole;

import modelo.ModeloAutor;
import modelo.ModeloLivro;
import static objetoAcessoDados.DAOBiblioteca.livros;
import assistente.InterfaceCRUD;

public class ControleLivro implements InterfaceCRUD {

    public boolean contem(String nome) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean cadastrar(String nome, int qtdCopias, ModeloAutor autor) {
        if (contem(nome)) {
            return false;
        }
        ModeloLivro livro = new ModeloLivro(nome, qtdCopias, autor);
        livros.put(nome, livro);
        return true;
    }

    public boolean remover(String nome) {
        if (contem(nome)) {
            livros.remove(nome);
            return true;
        }
        return false;
    }

}
