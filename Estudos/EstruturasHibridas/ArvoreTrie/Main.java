package Estudos.EstruturasHibridas.ArvoreTrie;

public class Main {
    public static void main(String[] args){
        Arvore tree = new Arvore();

        tree.inserir("Amelia");
        tree.inserir("Jussara");
        tree.inserir("Julia");
        tree.inserir("Julao");
        tree.inserir("Jussaro");
        tree.mostra();
        //tree.pesquisa("Abacatao");
        System.out.println(tree.countA());
    }
}
