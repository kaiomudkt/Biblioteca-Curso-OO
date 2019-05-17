package ObjetoAcessoDados_DAO;

import modelo.ModeloLivro;
import static armazenaDados.DadosBiblioteca.livros;
import assistente.InterfaceCRUD;
import java.util.Map;

/**
 * As classes DAO tem a responsabilidade de interagir com Banco de dados, em
 * nosso caso, com a TreeMap livros.
 * 
 * Entao todos os acesso aos dados da TreeMap livros, deve ser realizada por
 * meio da classe DAOLivro.
 */
public class DAOLivro implements InterfaceCRUD {

    /**
     * verifica se chave "nome" existe dentro da TreeMap livros
     * 
     * @param chave
     * @return boolean
     */
    @Override
    public boolean contem(String chave) {
        return livros.containsKey(chave);
    }

    /**
     * Realiza o cadastro de um objeto do tipo ModeloLivro na TreeMap livros
     * 
     * @param obj
     */
    @Override
    public void cadastrar(Object obj) {
        ModeloLivro livro = (ModeloLivro) obj;
        livros.put(livro.getNome(), livro);
    }

    /**
     * remove todo o objeto da TreeMap livros
     * 
     * @param nomeLivro
     */
    @Override
    public void remover(String nomeLivro) {
        livros.remove(nomeLivro);
    }

    /**
     * Realiza a devolução do livro que estava emprestado, somando a quantidade de
     * copias disponiveis
     * 
     * @param nome
     */
    public void devolverLivroEmprestado(String nome) {
        ModeloLivro livro = livros.get(nome);
        livro.setQtdCopias(livro.getQtdCopias() + 1);
        livros.put(nome, livro);
    }

    /**
     * Realiza o emprestimo do livro, subtraindo quantidade de copias disponiveis
     * 
     * @param nome
     */
    public void emprestarLivro(String nome) {
        ModeloLivro livro = livros.get(nome);
        livro.setQtdCopias(livro.getQtdCopias() - 1);
        if (livro.getQtdCopias() < 1) {
            livro.setDisponivelParaEmprestimo(false);
        }
        livros.put(nome, livro);
    }

    /**
     * 
     * @param nome
     * @return int quantida de copias disponiveis atualmente
     */
    public int qtdCopiasLivro(String nome) {
        return livros.get(nome).getQtdCopias();
    }

    /**
     * 
     * @param chave
     * @return objeto ModeloLivro
     */
    @Override
    public Object get(String chave) {
        return (ModeloLivro) livros.get(chave);
    }

    /**
     * printa todos os livros cadastrados
     */
    public void listarLivrosCadastrados() {
        for (Map.Entry<String, ModeloLivro> entry : livros.entrySet()) {
            ModeloLivro livro = entry.getValue();
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Autor: " + livro.getAutor());
            if (livro.isDisponivelParaEmprestimo()) {
                System.out.println("Está disponível: sim");
            }else{
                System.out.println("Está disponível: não");
            }
            System.out.println("Cópias: " + livro.getQtdCopias()+"\n");

        }
    }

    /**
     * printa todos os livros que estão disponivel para ser emprestado ou seja,
     * quantidade de copias maior que zero
     */
    public void listarLivrosDisponiveis() {
        for (Map.Entry<String, ModeloLivro> entry : livros.entrySet()) {
            ModeloLivro livro = entry.getValue();
            if (livro.isDisponivelParaEmprestimo()) {
                System.out.println(livro.getNome());
            }
        }
    }
}
