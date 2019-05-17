package assistente;

/**
 * CRUD (acrónimo do inglês Create, Read, Update e Delete) são as quatro
 * operações básicas (criação, consulta, atualização e destruição de dados)
 * utilizadas em bases de dados relacionais (RDBMS) fornecidas aos utilizadores
 * do sistema.
 */

/**
 *
 * lembrando que a TreeMap trabalha com o conceito de tabela de simbolo aonde se
 * utiliza a "chave/key" como índice de um vetor e "valor/value" como conteúdo,
 * que em nosso caso é um objeto do tipo Modelo, o mesmo modelo utilizado para
 * instanciar a TreeMap que estiver manipulando.
 */
public interface InterfaceCRUD {

    /**
     * verifica na respectiva TreeMap existe essa chave
     *
     * @param chave
     * @return
     */
    public boolean contem(String chave);

    /**
     * estamos usando um "Object" como parametro, pois cada classe DAO que
     * implementar esta interface utilizará esse parâmetro "obj" de um "Modelo"
     * de forma diferente, forçando realizar um typecasting para o tipo de
     * "Modelo" que estiver usando.
     *
     * @param obj
     */
    public void cadastrar(Object obj);

    /**
     * Utiliza somente o parâmetro chave para remover
     * pois é simplesmente oque a TreeMap 
     * precisa para remover algum objeto 
     * @param chave
     */
    public void remover(String chave);
/**
 * retorna um objeto do tipo "Object"
 * que precisara passar por um typecasting para ser utilizado
 * encontra objeto na TreeMap somente com a chave
 * @param chave
 * @return 
 */
    public Object get(String chave);
}
