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
    private int tam ;

    public Lista(){
        primeiro = ultimo = new Celula();
        int tam = 0;
    }

    public void inserirFim(int x){
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
        tam++;
    }
    public void inserirInicio(int x){
        Celula tmp = new Celula();

        primeiro.elemento = x;
        tmp.prox = primeiro;
        primeiro = tmp;
        tmp = null;
        tam++;
    }
    public void inserir(int x, int pos){
        if(pos < 0 || pos > tam ){
            try{
                throw new Exception("INVALID POSITION");
            }catch(Exception e){
                e.printStackTrace();
            }   
        }else if(pos == 0){
            inserirInicio(x);
        }else if(pos == tam){
            inserirFim(x);
        }else{
            Celula i = primeiro;
            for(int j = 0; j < pos; i = i.prox, j++);
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
         }
            
        
        
    }

    public void mostraLista(){
        for(Celula i = primeiro; i.prox != null; i = i.prox){
            System.out.print(i.prox.elemento + " ");

        }
        System.out.println();
    }
}



public class ListaEncadeada{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Lista lista = new Lista();
        lista.inserirInicio(1);
        lista.mostraLista();
        lista.inserirFim(2);
        lista.mostraLista();
        lista.inserirInicio(3);
        lista.mostraLista();
        lista.inserirFim(4);
        lista.mostraLista();
        lista.inserir(100, 2);
        lista.mostraLista();

    }
}