package modelo;

import assistente.Pessoa;

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
        return "Nome autor: " + getNome() + " " + getCpf(); //To change body of generated methods, choose Tools | Templates.
    }

}
