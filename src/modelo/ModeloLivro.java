package modelo;

import ObjetoAcessoDados_DAO.DAOAutor;

public class ModeloLivro {

    private String nome;
    private int qtdCopias;
    private ModeloAutor autor;
    private boolean disponivelParaEmprestimo;

    public ModeloLivro(String nome, int qtdCopias, ModeloAutor autor) {
        this.nome = nome;
        this.qtdCopias = qtdCopias;
        this.autor = autor;
        if (qtdCopias > 0) {
            this.disponivelParaEmprestimo = true;
        }else{
            this.disponivelParaEmprestimo = false;
        }
    }

    public ModeloLivro(String nome, int qtdCopias, String cpfAutor) {
        this.nome = nome;
        this.qtdCopias = qtdCopias;
        this.autor = (ModeloAutor) new DAOAutor().get(cpfAutor);
        this.disponivelParaEmprestimo = true;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCopias() {
        return qtdCopias;
    }

    public boolean setQtdCopias(int qtdCopias) {
        if (this.qtdCopias > 0 && this.qtdCopias - qtdCopias > 0) {
            this.qtdCopias = qtdCopias;
            return true;
        }
        return false;
    }

    public boolean isDisponivelParaEmprestimo() {
        return disponivelParaEmprestimo;
    }

    public void setDisponivelParaEmprestimo(boolean disponivelParaEmprestimo) {
        this.disponivelParaEmprestimo = disponivelParaEmprestimo;
    }

    public ModeloAutor getAutor() {
        return autor;
    }

    public void setAutor(ModeloAutor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro: "+getNome()+" Autor: "+getAutor().toString(); 
    }

}
