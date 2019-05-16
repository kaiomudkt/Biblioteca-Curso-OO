package armazenaDados;

import java.util.TreeMap;
import modelo.ModeloAutor;
import modelo.ModeloCliente;
import modelo.ModeloLivro;

public class DadosBiblioteca {
    public static TreeMap<String, ModeloCliente> clientes = new TreeMap<>();
    public static TreeMap<String, ModeloLivro> livros = new TreeMap<>();
    public static TreeMap<String, ModeloAutor> autores = new TreeMap<>();

}
