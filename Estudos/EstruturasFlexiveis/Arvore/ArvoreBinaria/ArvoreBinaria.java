package Estudos.EstruturasFlexiveis.Arvore.ArvoreBinaria;

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

    int pesquisa(int x){
        int resp = pesquisa(raiz, x);
        return resp;
    }

    int getAltura(){
        int altura = getAltura(raiz);
        return altura;
    }

    int getSoma(){
        int soma = getSoma(raiz);
        return soma;
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

    private int pesquisa(No i, int x){
        int resp = -1;
        if(i == null){
            return resp;
        }else if(x > i.elemento){
            resp = pesquisa(i.dir, x);
        }else if(x < i.elemento){
            resp = pesquisa(i.esq, x);
        }else{
            resp = 1;
        }

        return resp;
    }

    private int getAltura(No i){
        if(i == null){
            return -1;
        }
        int alturaEsq = getAltura(i.esq) + 1;
        int alturaDir = getAltura(i.dir) + 1;

        int altura = (alturaEsq > alturaDir ? alturaEsq : alturaDir);
        return altura; 
    }

    private int getSoma(No i){
        if(i == null){
            return 0;
        }
        int soma = i.elemento + getSoma(i.esq) + getSoma(i.dir);
        return soma;
    }
}

public class ArvoreBinaria{
    public static void main(String args[]){

        Arvore tree = new Arvore(-2);
        tree.inserir(4);
        tree.inserir(2);
        tree.inserir(7);
        tree.inserir(-3);
        tree.inserir(-5);
        tree.inserir(1);
        tree.caminharCentral();
        tree.caminharPosOrdem();
        tree.caminharPreOrdem();

        //System.out.println(tree.pesquisa(3));
        //System.out.println(tree.getAltura());
        System.out.println(tree.getSoma());

    }
}