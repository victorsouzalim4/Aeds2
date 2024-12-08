package Estudos.TabelasHash.Doidao.Arvore;
import Estudos.TabelasHash.Doidao.TabelasHash.T1.*;

public class No {
    public char caracter;
    public T1 t1;
    public No esq, dir;

    No(char c){
        this.caracter = c;
        this.t1 = null;
        this.esq = this.dir = null;
    }
}
