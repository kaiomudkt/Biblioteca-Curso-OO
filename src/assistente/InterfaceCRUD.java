package assistente;

public interface InterfaceCRUD {

    public boolean contem(String chave);

    public void cadastrar(Object obj);

    public void remover(String chave);
    
    public Object get(String chave);
}
