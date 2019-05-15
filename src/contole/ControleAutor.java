package contole;

import assistente.InterfaceDe_CRUD_DeListasDePessoas;
import modelo.ModeloAutor;
import static objetoAcessoDados.DAOBiblioteca.autores;

public class ControleAutor implements InterfaceDe_CRUD_DeListasDePessoas {

    @Override
    public boolean contem(String cpf) {
        if (autores.containsKey(cpf)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean cadastrar(String nome, String cpf) {
        if (contem(cpf)) {
            ModeloAutor autor = new ModeloAutor(nome, cpf);
            return true;
        }
        return false;
    }

    @Override
    public boolean remover(String cpf) {
        if (contem(cpf)) {
            autores.remove(cpf);
        }
        System.out.println("Não existe Autor com este CPF.");
        return false;
    }
}
