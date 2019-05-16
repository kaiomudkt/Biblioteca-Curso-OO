package contole;

import assistente.InterfaceCRUD;
import modelo.ModeloCliente;
import static objetoAcessoDados.DAOBiblioteca.clientes;

public class ControleCliente implements InterfaceCRUD {

    @Override
    public boolean contem(String cpf) {
        return clientes.containsKey(cpf);
    }

    @Override
    public void cadastrar(Object obj) {
        ModeloCliente cliente = (ModeloCliente) obj;
        clientes.put(cliente.getCpf(), cliente);
    }

    @Override
    public void remover(String nome) {
        clientes.remove(nome);
    }

    public boolean pegarLivroEmprestado(String nomeLivro, String cpf) {
        try {
            ModeloCliente cliente = clientes.get(cpf);
            if (cliente.contemLivro(nomeLivro)) {
                System.out.println("Cliente ja possui este livro.");
                return false;
            }
            ControleLivro cLivro = new ControleLivro();
            cliente.addLivroListaEmprestados(cLivro.getLivro(nomeLivro));
            clientes.put(cpf, cliente);//escreve mudanças na Lista de clientes
            cLivro.emprestarLivro(nomeLivro);
            return true;
        } catch (Exception e) {
            System.out.println("talvez nao existe cliente com este cpf");
            return false;
        }
    }

    /**
     *
     */
    public void devolverLivroEmprestado(String nomeLivro, String cpfCliente) {
        ModeloCliente cliente = clientes.get(cpfCliente);//acha cliente
        ControleLivro cLivro = new ControleLivro();
        cliente.removerLivroListaEmprestados(cLivro.getLivro(nomeLivro));//atualiza livro que estao com o cliente
        cLivro.devolverLivroEmprestado(nomeLivro);//atualiza qtd copias disponivel
    }

}
