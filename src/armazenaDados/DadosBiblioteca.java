package armazenaDados;

import java.util.TreeMap;
import modelo.ModeloAutor;
import modelo.ModeloCliente;
import modelo.ModeloLivro;
/**
 * está classe esta simulando porcamente o banco de dados
 * armazenando os dados em tempo de execução
 * nas devidas TreeMap
*/
public class DadosBiblioteca {
    /**
     * TreeMap são estrutura de dados assim como vetores,
     * aplicando o conceito de tabela de simbolo,
     * aonde estamos usando String como chave/índice,
     * e ModeloClsse como valor/conteúdo,
     * 
     * por exemplo,
     * na TreeMap clientes,
     * String "chave" é o CPF do objeto cliente,
     * utilizamos a "chave" como índece de um vetor,
     * para saber qual objeto da TreeMap estamos referenciando,
     * o objeto cliente, é uma instancia da classe ModeloCliente
     * esse objeto cliente é o "valor", 
     * ou seja, o conteúdo em si.
     */
/**
 * Então, com a chave, consegue achar o conteúdo na arvore.
 * 
 * outra peculiaridade,
 * é que a TreeMap não permite repetição de chave.
 */    
    
    public static TreeMap<String, ModeloCliente> clientes = new TreeMap<>();
    public static TreeMap<String, ModeloLivro> livros = new TreeMap<>();
    public static TreeMap<String, ModeloAutor> autores = new TreeMap<>();

}
