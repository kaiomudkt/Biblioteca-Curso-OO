package assistente;

public interface InterfaceCRUD {

    public boolean contem(String cpf);

    public boolean cadastrar(String nome, String cpf);

    public boolean remover(String cpf);
}
