package assistente;
/**
 * CRUD (acrónimo do inglês Create, Read, Update e Delete) 
 * são as quatro operações básicas 
 * (criação, consulta, atualização e destruição de dados) 
 * utilizadas em bases de dados relacionais (RDBMS) 
 * fornecidas aos utilizadores do sistema.
 */
public interface InterfaceCRUD {

    public boolean contem(String chave);

    public void cadastrar(Object obj);

    public void remover(String chave);
    
    public Object get(String chave);
}
