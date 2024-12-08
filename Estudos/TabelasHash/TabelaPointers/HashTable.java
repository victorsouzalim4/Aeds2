package Estudos.TabelasHash.TabelaPointers;

class HashTable {
    Celula [] tabela;
    int NULO;

    HashTable(){
        this.tabela = new Celula[10];
        this.NULO = -1;

        for(int i = 0; i < tabela.length; i++){
            tabela[i] = new Celula(NULO);
        }
    }

    void inserir(int x){
        int pos = hash(x);
        if(tabela[pos].elemento == NULO){
            tabela[pos].elemento = x;
        }else{
            Celula tmp;
            for(tmp = tabela[pos]; tmp.prox != null; tmp = tmp.prox);
            Celula novaCelula = new Celula(x);
            tmp.prox = novaCelula;
        }
    }
    

    int hash(int x){
        return (x % 10);
    }

    void mostrar(){
        for(int i = 0; i < 10; i++){
            if(tabela[i].elemento != NULO){
                for(Celula tmp = tabela[i]; tmp != null; tmp = tmp.prox){
                    System.out.print(tmp.elemento + " ");
                }
                System.out.println();
            }
            
        }
    }
}
