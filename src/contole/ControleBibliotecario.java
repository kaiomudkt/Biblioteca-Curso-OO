package contole;

import ObjetoAcessoDados_DAO.DAOAutor;
import ObjetoAcessoDados_DAO.DAOCliente;
import ObjetoAcessoDados_DAO.DAOLivro;
import modelo.ModeloAutor;
import modelo.ModeloCliente;
import modelo.ModeloLivro;
/**
 * esta classe ControleBibliotecario,
 tem acesso direto somente as tres classes do tipo CONTROLE
 e utiliza os respectivos MODELO de cada CONTROLE
 para se comunicar com o CONTROLE por objetos de seu tipo "MODELO".
 * 
 * Por meio desta classe ControleBibliotecario
 que a classe Teste.java
 esta exercendo o papel de "interface grafica",
 que é a responsável por interagir com o usuario de nossa aplicação,
 assim a classe Teste.java irá interagir somente 
 com a clesse ControleBibliotecario.
*/
public class ControleBibliotecario {
    
    public ModeloCliente getCliente(String cpf){
        return (ModeloCliente) new DAOCliente().get(cpf);
    }
    
    public ModeloLivro getLivro(String nome){
        return (ModeloLivro) new DAOLivro().get(nome);
    }
    
    public ModeloAutor getAutor(String cpf){
        return (ModeloAutor) new DAOAutor().get(cpf);
    }

    public void cadastrarLivro(String nome, int qtdCopias, String nomeAutor, String cpfAutor) {
        DAOLivro cLivro = new DAOLivro();
        if (new DAOAutor().contem(cpfAutor)) {
            cLivro.cadastrar(new ModeloLivro(nome, qtdCopias, cpfAutor));
        } else {
            cLivro.cadastrar(new ModeloLivro(nome, qtdCopias, new ModeloAutor(nomeAutor, cpfAutor)));
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
        DAOCliente cCliente = new DAOCliente();
        if (!cCliente.contem(cpf)) {
            System.out.println("Não existe este CPF como cliente.");
            return;//encerra o método
        }
        cCliente.remover(cpf);
    }

    public void ClientePegaLivro(String nomeLivro, String cpf) {
        DAOCliente cCliente = new DAOCliente();
        if (cCliente.contem(cpf)) {
            if (new DAOLivro().qtdCopiasLivro(nomeLivro) > 0) {
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
        DAOCliente cCliente = new DAOCliente();
        if (cCliente.contem(cpf)) {//existe cliente cadastrado
            if (new DAOLivro().contem(nomeLivro)) {//existe livro cadastrado
                cCliente.devolverLivroEmprestado(nomeLivro, cpf);
            }else{
                System.out.println("Livro não cadastrado para poder devolver");
            }
        } else {
            System.out.println("Cliente não cadastrado");
        }
    }
    
    
    public void listaLivrosCadastrados(){
        DAOLivro cLivro = new DAOLivro();
        cLivro.
    
    }
    
    public void listaLivrosDisponiveis(){
        DAOLivro cLivro = new DAOLivro();
        cLivro.
    
    }
    
    
    

}
