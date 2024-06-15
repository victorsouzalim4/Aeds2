package Estudos.EstruturasFlexiveis.Arvore.ArvoreBinariaDePesquisa;

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

    void remover(int x){
        raiz = remover(raiz, x);
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

    private No remover(No i, int x){
        if(i == null){
            System.out.println("ERRO, elemento nao encontrado");
        }else if(x < i.elemento){
            i.esq = remover(i.esq, x);
        }else if(x > i.elemento){
            i.dir = remover(i.dir, x);
        }else if(i.dir == null){
            i = i.esq;
        }else if(i.esq == null){
            i = i.dir;
        }else{
            i.esq = getMaiorEsq(i, i.esq);
        }

        return i;
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

    private No getMaiorEsq(No i, No j){
        if(j.dir == null){
            i.elemento = j.elemento;
            j = j.esq;
        }else{
            j.dir = getMaiorEsq(i, j.dir);
        }

        return j;
    }

}

public class ArvoreBinaria{
    public static void main(String args[]){

        Arvore tree = new Arvore(0);
        for(int i = 1; i <= 1024; i++){
            tree.inserir(i);
        }

        System.out.println(tree.getAltura());

    }
}