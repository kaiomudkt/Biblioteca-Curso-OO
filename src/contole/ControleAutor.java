package contole;

import assistente.InterfaceCRUD;
import modelo.ModeloAutor;
import static objetoAcessoDados.DAOBiblioteca.autores;

public class ControleAutor implements InterfaceCRUD {
    
    @Override
    public boolean contem(Object obj) {
        ModeloAutor autor = (ModeloAutor) obj;
        if (autores.containsKey(autor.getCpf())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean cadastrar(Object obj) {
        ModeloAutor autor = (ModeloAutor) obj;
        if (contem(autor.getCpf())) {
            return true;
        }
        autores.put(autor.getCpf(), autor);
        return false;
    }

    @Override
    public boolean remover(Object obj) {
        ModeloAutor autor = (ModeloAutor) obj;
        if (contem(autor.getCpf())) {
            autores.remove(autor.getCpf());
        }
        System.out.println("Não existe Autor com este CPF.");
        return false;
    }
}
