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
    public static TreeMap<String, ModeloCliente> clientes = new TreeMap<>();
    public static TreeMap<String, ModeloLivro> livros = new TreeMap<>();
    public static TreeMap<String, ModeloAutor> autores = new TreeMap<>();

}
