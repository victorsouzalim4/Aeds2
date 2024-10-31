package Estudos.EstruturasFlexiveis.Aulao;

class Celula {
    int elemento;
    Celula prox;
    Celula ant;

    Celula(){
        this(0);
    }

    Celula(int x){
        this.elemento = x;
        this.prox = null;
        this.ant = null;
    }
}
