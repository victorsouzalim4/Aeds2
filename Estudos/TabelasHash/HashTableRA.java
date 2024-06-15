package Estudos.TabelasHash;

class Table{
    private int[] tabela;
    private int[] areaDeReserva;
    private int Nulo;

    Table(){
        tabela = new int[10];
        areaDeReserva = new int[5];
        Nulo = -1;

        for(int i = 0; i < 10; i++, tabela[i] = Nulo);
        for(int i = 0; i < 5; i++, areaDeReserva[i] = Nulo);
    }

    public void inserir(int x){
        int pos = hash(x);
        if(tabela[pos] == Nulo){
            tabela[pos] = x;
        }else{
            boolean flag = true;
            for(int i = 0; i < 5; i++){
                if(areaDeReserva[i] == Nulo){
                    areaDeReserva[i] = x;
                    i = 5;
                    flag = false;
                }
            }
            if(flag) System.out.println("Nao foi possivel inserir este valor");
        }
    }

    private int hash(int x){
        return (x % 10);
    }
}


public class HashTableRA{
    public static void main(String[] args){

    }   
}