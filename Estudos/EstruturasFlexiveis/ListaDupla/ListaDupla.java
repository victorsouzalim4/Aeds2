package Estudos.EstruturasFlexiveis.ListaDupla;

class CelulaDupla{
    public int elemento;
    public CelulaDupla ant;
    public CelulaDupla prox;

    CelulaDupla(){
        this.elemento = 0;
        this.prox = this.ant = null;
    }

    CelulaDupla(int x){
        this.elemento = x;
        this.prox = this.ant = null;
    }
}

class List{
    private CelulaDupla primeiro, ultimo;
    private int tam;

    List(){
        this.primeiro = new CelulaDupla();
        this.ultimo = primeiro;
        tam = 0;
    }

    void inserirFim(int x){
        CelulaDupla tmp = new CelulaDupla(x);
        ultimo.prox = tmp;
        tmp.ant = ultimo;

        ultimo = tmp;
        tmp = null;
        tam++;
    }

    void inserirInicio(int x){
        if(primeiro == ultimo){
            inserirFim(x);
        }else{
            CelulaDupla tmp = new CelulaDupla(x);

            tmp.prox = primeiro.prox;
            primeiro.prox.ant = tmp;
    
            primeiro.prox = tmp;
            tmp.ant = primeiro;
            tam++;
        }

    }

    void inserir(int pos, int x){
        if(pos < 0 || pos > tam){
            try{
                throw new Exception("POSICAO INVALIDA");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(pos == 0) inserirInicio(x);
        else if(pos == tam) inserirFim(x);
        else{
            CelulaDupla i = primeiro.prox;
            for(int j = 0; j != pos; i = i.prox, j++);

            CelulaDupla tmp = new CelulaDupla(x);

            tmp.prox = i;
            tmp.ant = i.ant;

            i.ant.prox = tmp;
            i.ant = tmp;

            i = tmp = null;
            tam++;
        }
    }

    int removeInicio(){
        int elemento = -1;
        if(ultimo == primeiro){
            try{
                throw new Exception("Lista vazia");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            CelulaDupla tmp = primeiro;
            primeiro = primeiro.prox;
            primeiro.ant = null;
            tmp = tmp.prox = null;

            tam--;
        }


        return elemento;
    }

    int removeFim(){
        int elemento = -1;
        if(ultimo == primeiro){
            try{
                throw new Exception("Lista vazia");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            CelulaDupla tmp = ultimo;
            ultimo = ultimo.ant;

            elemento = tmp.elemento;
            ultimo.prox = tmp.ant = tmp = null;
            tam--;
        }
        return elemento;
    }

    int remove(int pos){
        int elemento = -1;
        if(pos < 0 || pos > tam){
            try{
                throw new Exception("Posicao invalida");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(pos == 0)removeInicio();
        else if(pos+1 == tam)removeFim();
        else{
            CelulaDupla i = primeiro.prox;
            for(int j = 0; j < pos; i = i.prox, j++);

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            elemento = i.elemento;

            i.prox = i.ant = i = null;
            tam--;
        }
        return elemento;
    }

    void mostra(){
        for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
}

public class ListaDupla{
    public static void main(String args[]){

        List lista = new List();

        lista.inserirFim(1);
        lista.mostra();
        lista.inserirInicio(2);
        lista.mostra();
        lista.inserirInicio(3);
        lista.mostra();
        lista.inserirInicio(4);
        lista.mostra();
        lista.inserirInicio(3);
        lista.mostra();
        lista.inserirFim(7);
        lista.mostra();
        lista.remove(3);
        lista.mostra();
        lista.remove(4);
        lista.mostra();
        lista.removeInicio();
        lista.mostra();
        lista.removeFim();
        lista.mostra();




    }
}
