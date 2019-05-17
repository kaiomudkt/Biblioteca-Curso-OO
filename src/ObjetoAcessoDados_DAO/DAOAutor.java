package ObjetoAcessoDados_DAO;

import assistente.InterfaceCRUD;
import modelo.ModeloAutor;
import static armazenaDados.DadosBiblioteca.autores;
import java.util.Map;
/**
 * Objeto de acesso a dados
 * (acrônimo do inglês Data Access Object - DAO), 
 * é um padrão para aplicações que utilizam persistência de dados,
 * onde tem a separaração das regras de negócio
 * das regras de acesso a banco de dados,
 * implementada com linguagens de programação orientadas a objetos.
 * 
 * Em nosso caso, não é realmente um Banco de Dados,
 * mas uma "simulação".
 */
public class DAOAutor implements InterfaceCRUD {
    
    @Override
    public boolean contem(String cpf) {
        return autores.containsKey(cpf);
    }

    @Override
    public void cadastrar(Object obj) {
        ModeloAutor autor = (ModeloAutor) obj;
        autores.put(autor.getCpf(), autor);
    }

    @Override
    public void remover(String cpf) {
        autores.remove(cpf);
    }

    @Override
    public Object get(String chave) {
        return (ModeloAutor) autores.get(chave);
    }
    
    public void listaAutores() {
        for (Map.Entry<String, ModeloAutor> entry : autores.entrySet()) {
            ModeloAutor autor = entry.getValue();
            System.out.println(autor.getNome()+" "+autor.getCpf()+" quantidade de obras: "+autor.getQtdObras() );
        }
    }

}
