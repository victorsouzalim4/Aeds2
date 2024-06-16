package Estudos.EstruturasHibridas.ArvoreTrie;

public class Main {
    public static void main(String[] args){
        Arvore tree = new Arvore();

        tree.inserir("Caralho");
        tree.inserir("Casa");
        tree.inserir("Abacate");
        tree.inserir("Abacatao");
        tree.mostra();
        tree.pesquisa("Abacatao");
    }
}
