package Estudos.EstruturasHibridas.HashTableDeLista;

class Table{
    Lista[] tabela;
    int Nulo;

    Table(){
        tabela = new Lista[10];
        Nulo = -1;

        for(int i = 0; i < 10; i++){
            tabela[i] = new Lista();
        }
    }

    public void inserir(int x){
        tabela[hash(x)].inserirFim(x);
    }

    public void pesquisa(int x){
        if(tabela[hash(x)].pesquisa(x)){
            System.out.println("Elemento Encontrado");
        }
        else {
            System.out.println("Elemento nao encontrado");
        }
    }

    private int hash(int x){
        return (x % 10);
    }

    public void mostra(){
        for(int i = 0; i < tabela.length; i++){
            if(tabela[i].primeiro != null){
                tabela[i].mostraLista();
            }
        }
    }

}


public class HashTable{
    public static void main(String[] args){
        Table tabela = new Table();

        tabela.inserir(0);
        tabela.inserir(10);
        tabela.inserir(1);
        tabela.inserir(11);
        tabela.inserir(7);
        tabela.mostra();

    }
}