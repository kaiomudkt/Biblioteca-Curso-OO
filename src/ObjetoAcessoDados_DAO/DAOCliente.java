package ObjetoAcessoDados_DAO;

import assistente.InterfaceCRUD;
import modelo.ModeloCliente;
import static armazenaDados.DadosBiblioteca.clientes;
import java.util.Map;
import modelo.ModeloLivro;

/**
 * A classe DAOCliente tem acesso direto a lista de clientes, que esta
 * armazenada em uma TreeMap, esta TreeMap é do tipo ModeloCliente na classe
 * DadosBiblioteca.java veja que a lista de cliente, chamada de (clientes), é
 * static, ou seja, sempre vamos esta utilizando a MESMA TreeMap clientes, e não
 * uma nova instancia dela.
 *
 * A classe DAOCliente também importa ModeloCliente.java para poder criar
 * objetos deste tipo/formato e assim poder manipulalos de acordo com a
 * necessidade de cada método.
 *
 * A classe DAOCliente implementa a interface InterfaceCRUD do pacote assitente
 * que possui assinatura do comportamento padrão de método necessário em nosso
 * contexto
 */
public class DAOCliente implements InterfaceCRUD {

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
            DAOLivro cLivro = new DAOLivro();
            cliente.addLivroListaEmprestados((ModeloLivro) cLivro.get(nomeLivro));
            clientes.put(cpf, cliente);//escreve mudanças na Lista de clientes
            cLivro.emprestarLivro(nomeLivro);//escreve mudanças na Lista de Livros
            return true;
        } catch (Exception e) {
            System.out.println("Erro metodo pegarLivroEmprestado()");
            return false;
        }
    }

    /**
     *
     */
    public void devolverLivroEmprestado(String nomeLivro, String cpfCliente) {
        ModeloCliente cliente = clientes.get(cpfCliente);//acha cliente
        DAOLivro cLivro = new DAOLivro();
        if (cliente.contemLivro(nomeLivro)) {
            cliente.removerLivroListaEmprestados((ModeloLivro) cLivro.get(nomeLivro));//atualiza livro que estao com o cliente
            cLivro.devolverLivroEmprestado(nomeLivro);//atualiza qtd copias disponivel
        } else {
            System.out.println("Cliente não pegou esse livro para poder devolver.");
        }
    }

    @Override
    public Object get(String chave) {
        return (ModeloCliente) clientes.get(chave);
    }

    public void listaClientes() {
        for (Map.Entry<String, ModeloCliente> entry : clientes.entrySet()) {
            ModeloCliente cliente = entry.getValue();
            System.out.println(cliente.getNome()+" "+cliente.getCpf()+" "+cliente.livrosCliente() );
        }
    }
}


