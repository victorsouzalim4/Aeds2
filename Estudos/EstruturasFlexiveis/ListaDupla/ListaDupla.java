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


    }
}
