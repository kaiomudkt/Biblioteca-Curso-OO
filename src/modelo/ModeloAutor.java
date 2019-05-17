package modelo;

import assistente.Pessoa;
/**
 * 
 * Classes ModeloClasse, tem por objetivo,
 * somente modelar algo do mundo real,
 * para gerar objetos que serão manipulados
 */
public class ModeloAutor extends Pessoa {

    private int qtdObras;

    public ModeloAutor(String nome, String cpf) {
        super(nome, cpf);
        qtdObras = 1;
    }

    public int getQtdObras() {
        return qtdObras;
    }

    public void setQtdObras(int qtdObras) {
        this.qtdObras = qtdObras;
    }

    @Override
    public String toString() {
        return "Nome autor: " +getNome()+"."; //To change body of generated methods, choose Tools | Templates.
    }

}
