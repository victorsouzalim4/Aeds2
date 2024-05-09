package Estudos.EstruturasFlexiveis;

class Celula{
    public int elemento;
    public Celula prox;

    Celula(){
        this.elemento = 0;
        this.prox = null;
    }
    Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha{
    private Celula topo;

    Pilha(){
        this.topo = null;
    }

    void inserir(int x){
        Celula tmp = new Celula(x);
        if(topo == null){
            topo = tmp;
        }else{
            tmp.prox = topo;
            topo = tmp;
        }
        tmp = null;
    }

    void mostra(){
        for(Celula i = topo; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
}

public class PilhaFlexivel {
    public static void main(String args[]){
        Pilha pilha = new Pilha();
        pilha.inserir(1);
        pilha.mostra();
        pilha.inserir(2);
        pilha.mostra();
        pilha.inserir(3);
        pilha.mostra();
        pilha.inserir(4);
        pilha.mostra();

    }
}
