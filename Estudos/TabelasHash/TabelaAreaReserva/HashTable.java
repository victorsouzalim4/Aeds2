package Estudos.TabelasHash.TabelaAreaReserva;

class Table{
    private int[] tabela;
    private int[] areaDeReserva;
    private int Nulo;

    Table(){
        tabela = new int[10];
        areaDeReserva = new int[5];
        Nulo = -1;

        for(int i = 0; i < 10; i++)tabela[i] = Nulo;
        for(int i = 0; i < 5; i++)areaDeReserva[i] = Nulo;
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

    public void mostra(){
        for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != Nulo){
                System.out.print(tabela[i] + " ");
            }
        }
        System.out.println("\nArea De Reserva:");
        for(int i = 0; i < areaDeReserva.length; i++){
            if(areaDeReserva[i] != Nulo){
                System.out.print(areaDeReserva[i] + " ");
            }
        }
        System.out.println();
    }

    public void pesquisa(int x){
        boolean flag = false;
        int pos = hash(x);

        if(tabela[pos] == x)flag = true;
        else{
            for(int i = 0; i < areaDeReserva.length; i++){
                if(areaDeReserva[i] == x)flag = true;
            }
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
        tabela.mostra();
        //tabela.pesquisa(3);
    }   
}

//posteriormente irei remodelar a area de reserva para um arrayList para facilitar na implementacao do metodo de remocao da tabela