package contole;

import assistente.InterfaceCRUD;
import modelo.ModeloCliente;
import static objetoAcessoDados.DAOBiblioteca.clientes;

public class ControleCliente implements InterfaceCRUD {

    @Override
    public boolean contem(Object obj) {
        ModeloCliente cliente = (ModeloCliente) obj;
            if (clientes.containsKey(cliente.getCpf())) {
                return true;
            }
        return false;
    }

    @Override
    public boolean cadastrar(Object obj) {
        ModeloCliente cliente = (ModeloCliente) obj;
        return clientes.put(cliente.getCpf(), cliente) != null;
    }

    @Override
    public boolean remover(Object obj) {
        ModeloCliente cliente = (ModeloCliente) obj;
        return clientes.remove(cliente.getCpf()) != null;
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
    
    
    public boolean devolverLivroEmprestado(){
    
    }
}
