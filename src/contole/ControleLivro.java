package contole;

import modelo.ModeloLivro;
import static objetoAcessoDados.DAOBiblioteca.livros;
import assistente.InterfaceCRUD;

public class ControleLivro implements InterfaceCRUD {



 

    @Override
    public boolean contem(Object obj) {
        ModeloLivro livro = (ModeloLivro) obj;
        if (livros.containsKey(livro.getNome())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean cadastrar(Object obj) {
        ModeloLivro livro = (ModeloLivro) obj;
        if (contem(livro.getNome())) {
            return false;
        }
        livros.put(livro.getNome(), livro);
        return true;
    }

    @Override
    public boolean remover(Object obj) {
        ModeloLivro livro = (ModeloLivro) obj;
        return livros.remove(livro.getNome()) != null;
    }
    
}
