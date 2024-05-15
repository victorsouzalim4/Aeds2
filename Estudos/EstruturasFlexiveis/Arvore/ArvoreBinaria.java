package Estudos.EstruturasFlexiveis.Arvore;

class No{
    public int elemento;
    public No dir;
    public No esq;

    No(int x){
        this.elemento = x;
        this.dir = null;
        this.esq = null;
    }
}

class Arvore{
    private No raiz;

    Arvore(int x){
        raiz = new No(x);
    }

    void inserir(int x){
        raiz = inserir(raiz, x);
    }

    void caminharCentral(){
        caminharCentral(raiz);
        System.out.println();
    }

    void caminharPosOrdem(){
        caminharPosOrdem(raiz);
        System.out.println();
    }

    void caminharPreOrdem(){
        caminharPreOrdem(raiz);
        System.out.println();
    }

    private No inserir(No i, int x){
        if(i == null){
            i = new No(x);
        }else if(x > i.elemento){
            i.dir = inserir(i.dir, x);
        }else if(x < i.elemento){
            i.esq = inserir(i.esq, x);
        }else{
            System.out.println("ERRO");
            return i;
        }

        return i;
    }

    private void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    private void caminharPosOrdem(No i){
        if(i != null){
            caminharPosOrdem(i.esq);
            caminharPosOrdem(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    private void caminharPreOrdem(No i){
        if(i != null){
            System.out.print(i.elemento + " ");
            caminharPreOrdem(i.esq);
            caminharPreOrdem(i.dir);
        }
    }
}

public class ArvoreBinaria{
    public static void main(String args[]){

        Arvore tree = new Arvore(0);
        tree.inserir(3);
        tree.inserir(-2);
        tree.inserir(1);
        tree.inserir(-3);
        tree.inserir(2);
        tree.inserir(-1);
        tree.caminharCentral();
        tree.caminharPosOrdem();
        tree.caminharPreOrdem();


    }
}