package Estudos.TabelasHash.Doidao.Doidao;
import Estudos.TabelasHash.Doidao.Arvore.Arvore;;

public class Doidao {
    Arvore tree;

    public Doidao(){
        this.tree = new Arvore();
        for(char c = 65; c <= 90; c++){
            tree.inserir(c);
        }
    }

    public void inserirPalavra(String palavra){
        tree.inserirPalavra(palavra);
    }
}
