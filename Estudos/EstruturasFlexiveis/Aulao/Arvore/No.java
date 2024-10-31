package Estudos.EstruturasFlexiveis.Aulao.Arvore;

class No {
    int elemento;
    No esq;
    No dir;

    No(){
        this(0);
    }

    No(int x){
        this.elemento = x;
        this.esq = this.dir = null;
    }
}
