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

class Fila{
    private Celula primeiro;
    private Celula ultimo;

    Fila(){
        primeiro = ultimo = new Celula();
    }

    void inserir(int x){
        Celula tmp = new Celula(x);

        ultimo.prox = tmp;
        ultimo = ultimo.prox;
        tmp = null;
    }

    void mostra(){
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
}

public class FilaFlexivel {
    public static void main(String args[]){
        Fila fila = new Fila();

        fila.inserir(1);
        fila.mostra();
        fila.inserir(2);
        fila.mostra();
        fila.inserir(3);
        fila.mostra();

    }  
}
