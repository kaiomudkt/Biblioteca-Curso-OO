package contole;

import modelo.ModeloLivro;
import static objetoAcessoDados.DAOBiblioteca.livros;
import assistente.InterfaceCRUD;

public class ControleLivro implements InterfaceCRUD {
    @Override
    public boolean contem(String chave) {
        return livros.containsKey(chave);
    }

    @Override
    public void cadastrar(Object obj) {
        ModeloLivro livro = (ModeloLivro) obj;
        livros.put(livro.getNome(), livro);
    }

    @Override
    public void remover(String nomeLivro){
        livros.remove(nomeLivro);
    }
    
    
    public void devolverLivroEmprestado(String nome){
        ModeloLivro livro = livros.get(nome);
        livro.setQtdCopias(livro.getQtdCopias()+1);
        livros.put(nome, livro);
    }
    
    public void emprestarLivro(String nome){
        ModeloLivro livro = livros.get(nome);
        livro.setQtdCopias(livro.getQtdCopias()-1);
        livros.put(nome, livro);
    }
    
    
    public int qtdCopiasLivro(String nome){
        return livros.get(nome).getQtdCopias();
    }
    
    public ModeloLivro getLivro(String nome){
        return livros.get(nome);
    }
}
