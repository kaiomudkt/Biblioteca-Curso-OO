package contole;

import assistente.InterfaceCRUD;
import modelo.ModeloAutor;
import static objetoAcessoDados.DAOBiblioteca.autores;

public class ControleAutor implements InterfaceCRUD {
    
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
}
