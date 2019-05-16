package ObjetoAcessoDados_DAO;

import assistente.InterfaceCRUD;
import modelo.ModeloAutor;
import static armazenaDados.DadosBiblioteca.autores;

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

}
