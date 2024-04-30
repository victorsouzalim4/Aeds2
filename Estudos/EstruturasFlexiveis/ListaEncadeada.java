package Estudos.EstruturasFlexiveis;
import java.util.Scanner;

class Celula{
    public int elemento;
    public Celula prox;

    public Celula(){
        this.elemento = 0;
        this.prox = null;
    }

    public Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
}

class Lista{
    private Celula primeiro;
    private Celula ultimo;

    public Lista(){
        primeiro = ultimo = new Celula();
    }

    public void inserirFim(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }
    public void inserirInicio(int x){
        Celula tmp = new Celula();

        primeiro.elemento = x;
        tmp.prox = primeiro;
        primeiro = tmp;
        tmp = null;
    }

    public void mostraLista(){
        for(Celula i = primeiro; i.prox != null; i = i.prox){
            System.out.println(i.prox.elemento);

        }
    }
}



public class ListaEncadeada{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Lista lista = new Lista();
        lista.inserirFim(2);
        lista.inserirFim(3);
        lista.inserirFim(4);
        lista.inserirInicio(1);
        lista.mostraLista();

    }
}