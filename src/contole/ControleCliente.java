package contole;

import assistente.InterfaceDe_CRUD_DeListasDePessoas;
import modelo.ModeloCliente;
import static objetoAcessoDados.DAOBiblioteca.clientes;
//import static objetoAcessoDados.DAOBiblioteca.livros;

public class ControleCliente implements InterfaceDe_CRUD_DeListasDePessoas {

    @Override
    public boolean cadastrar(String nome, String cpf) {
        if (contem(cpf)) {//existe no ArrayList de Cliente, cliente com este CPF
            System.out.println("CPF já cadastrado como Cliente.");
            return false;
        }
        //Não existe esse cpf
        clientes.put(cpf, new ModeloCliente(nome, cpf));//cria novo Cliente no ArrayList
        return true;
    }

    /*
    * Método contemCliente verifica se existe esse cpf cadastrado como cliente
     */
    @Override
    public boolean contem(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remover(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean pegarLivroEmprestado(String nomeLivro, String cpf) {
        try {
            ModeloCliente cliente = clientes.get(cpf);
            if (cliente.contemLivro(nomeLivro)) {
                System.out.println("Cliente ja possui este livro.");
                return false;
            }
            //procura livro no acervo da biblioteca livros.get(nomeLivro)
            //adiciona livro a lista de livros que cliente pegou emprestado atualmente
            cliente.addLivroListaEmprestados(new ControleLivro().get livros.get(nomeLivro));
            return true;
        } catch (Exception e) {
            System.out.println("talvez nao existe cliente com este cpf");
            return false;
        }
    }

}
