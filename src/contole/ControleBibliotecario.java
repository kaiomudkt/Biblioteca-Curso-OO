package contole;

import ObjetoAcessoDados_DAO.DAOAutor;
import ObjetoAcessoDados_DAO.DAOCliente;
import ObjetoAcessoDados_DAO.DAOLivro;
import modelo.ModeloAutor;
import modelo.ModeloCliente;
import modelo.ModeloLivro;

/**
 * esta classe ControleBibliotecario, tem acesso direto somente as tres classes
 * do tipo DAO e utiliza os respectivos MODELO de cada DAO para se comunicar com
 * o DAO por objetos de seu tipo "MODELO".
 * 
 * Por meio desta classe ControleBibliotecario que a classe Teste.java esta
 * exercendo porcamente o papel de "interface grafica", que é a responsável por
 * interagir com o usuario de nossa aplicação, assim a classe Teste.java irá
 * interagir somente com a clesse ControleBibliotecario.
 */
public class ControleBibliotecario {

    public ModeloCliente getCliente(String cpf) {
        return (ModeloCliente) new DAOCliente().get(cpf);
    }

    public ModeloLivro getLivro(String nome) {
        return (ModeloLivro) new DAOLivro().get(nome);
    }

     public ModeloAutor getAutor(String cpf) {
        try{
            return (ModeloAutor) new DAOAutor().get(cpf);
        }catch(Exception e){
            System.out.println("Provavelmente não existe esse CPF na TreeMap de ModeloAutor");
            return null;
        }
    }

    public void cadastrarLivro(String nome, int qtdCopias, String nomeAutor, String cpfAutor) {
        DAOLivro daoLivro = new DAOLivro();
        DAOAutor daoAutor = new DAOAutor();
        if (daoAutor.contem(cpfAutor)) {
            daoLivro.cadastrar(new ModeloLivro(nome, qtdCopias, cpfAutor));
            ModeloAutor autor = (ModeloAutor) daoAutor.get(nomeAutor);
            autor.setQtdObras(autor.getQtdObras()+1);
            daoAutor.cadastrar(autor);
        } else {
            daoLivro.cadastrar(new ModeloLivro(nome, qtdCopias, new ModeloAutor(nomeAutor, cpfAutor)));
            daoAutor.cadastrar(new ModeloAutor(nomeAutor, cpfAutor));
        }
    }

    public void removerLivro(String nomeLivro) {
        DAOLivro cLivro = new DAOLivro();
        if (cLivro.contem(nomeLivro)) {
            cLivro.remover(nomeLivro);
        }
    }

    public void cadastrarCliente(String nome, String cpf) {
        DAOCliente cCliente = new DAOCliente();
        if (cCliente.contem(cpf)) {
            System.out.println("CPF já cadastrado como Cliente.");
        } else {
            cCliente.cadastrar(new ModeloCliente(nome, cpf));
        }
    }

    public void removeCliente(String cpf) {
        DAOCliente daoCliente = new DAOCliente();
        if (!daoCliente.contem(cpf)) {
            System.out.println("Não existe este CPF como cliente.");
            return;// encerra o método
        }
        daoCliente.remover(cpf);
    }

    public void ClientePegaLivro(String nomeLivro, String cpf) {
        DAOCliente daoCliente = new DAOCliente();
        if (daoCliente.contem(cpf)) {
            if (new DAOLivro().qtdCopiasLivro(nomeLivro) > 0) {
                daoCliente.pegarLivroEmprestado(nomeLivro, cpf);
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
        DAOCliente daoCliente = new DAOCliente();
        if (daoCliente.contem(cpf)) {// existe cliente cadastrado
            if (new DAOLivro().contem(nomeLivro)) {// existe livro cadastrado
                daoCliente.devolverLivroEmprestado(nomeLivro, cpf);
            } else {
                System.out.println("Livro não cadastrado para poder devolver");
            }
        } else {
            System.out.println("Cliente não cadastrado");
        }
    }

    public void listaLivrosCadastrados() {
        DAOLivro daoLivro = new DAOLivro();
        daoLivro.listarLivrosCadastrados();

    }

    public void listaLivrosDisponiveis() {
        DAOLivro daoLivro = new DAOLivro();
        daoLivro.listarLivrosDisponiveis();
    }
}
