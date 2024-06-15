package Estudos.TabelasHash.TabelaRehash;

class Table{
    private int[] tabela;
    private int Nulo;

    Table(){
        tabela = new int[10];
        Nulo = -1;

        for(int i = 0; i < 10; i++)tabela[i] = Nulo;
    }

    public void inserir(int x){
        int pos = hash(x);
        if(tabela[pos] == Nulo){
            tabela[pos] = x;
        }else{
            boolean flag = true;
            if(tabela[rehash(x)] == Nulo){
                tabela[rehash(x)] = x;
                flag = false;
            }
            if(flag) System.out.println("Nao foi possivel inserir este valor");
        }
    }

    private int hash(int x){
        return (x % 10);
    }

    private int rehash(int x){
        return(++x % 10);
    }

    public void mostra(){
        for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != Nulo){
                System.out.print(tabela[i] + " ");
            }
        }
        System.out.println();
    }

    public void pesquisa(int x){
        boolean flag = false;

        if(tabela[hash(x)] == x)flag = true;
        else{
            if(tabela[rehash(x)] == x)flag = true;
        }

        if(flag){
            System.out.println("Elemento encontrado");
        }else{
            System.out.println("Elemento nao encontrado");
        }

    }

}


public class HashTable{
    public static void main(String[] args){
        Table tabela = new Table();

        tabela.inserir(0);
        tabela.inserir(10);
        tabela.inserir(20);
        tabela.inserir(30);
        tabela.inserir(7);
        tabela.inserir(2);
        tabela.inserir(17);
        tabela.inserir(27);
        tabela.mostra();
    }   
}
