package Estudos.EstruturasFlexiveis.FilaFlexivel;

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

    int remove(){
        int elemento = 0;
        if(ultimo == primeiro){
            try{
                throw new Exception("FILA VAZIA");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            Celula tmp = primeiro;
            primeiro = primeiro.prox;
            elemento = primeiro.elemento;

            tmp.prox = tmp = null;
        }

        return elemento;
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
        fila.inserir(4);
        fila.mostra();
        fila.inserir(5);
        fila.mostra();
        fila.remove();
        fila.mostra();
        fila.remove();
        fila.mostra();
        fila.remove();
        fila.mostra();
        fila.remove();
        fila.mostra();
        fila.remove();
        fila.mostra();


    }  
}



