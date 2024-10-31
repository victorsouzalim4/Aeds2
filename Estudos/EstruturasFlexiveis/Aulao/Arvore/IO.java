package Estudos.EstruturasFlexiveis.Aulao.Arvore;

public class IO {
    public static void main(String[] args) {
        Arvore tree = new Arvore();

        tree.inserir(5);
        tree.inserir(3);
        tree.inserir(7);
        tree.inserir(4);
        tree.inserir(6);
        tree.inserir(8);
        tree.central();

        System.out.println(tree.soma());
    }
}
