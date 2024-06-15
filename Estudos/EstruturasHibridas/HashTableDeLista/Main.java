package Estudos.EstruturasHibridas.HashTableDeLista;

public class Main{
    public static void main(String[] args){
        Table tabela = new Table();

        tabela.inserir(0);
        tabela.inserir(10);
        tabela.inserir(1);
        tabela.inserir(11);
        tabela.inserir(7);
        tabela.mostra();
        tabela.remover(13);
        tabela.mostra();

    }
}