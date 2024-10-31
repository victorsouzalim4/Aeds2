package Estudos.EstruturasFlexiveis.Aulao.ListaDupla;

public class IO {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        lista.inserirInicio(2);
        lista.inserirInicio(3);
        lista.inserirInicio(4);
        lista.inserirFim(5);
        lista.inserirFim(6);
        lista.inserirFim(7);
        lista.mostrar();

        lista.inserir(10, 0);
        lista.inserir(11, 7);
        lista.mostrar();

        lista.inserir(12, 4);
        lista.inserir(0, 15); 
        lista.mostrar();

        lista.removeInicio();
        lista.removeFim();
        lista.mostrar();

        lista.remove(5);
        lista.remove(0);
        lista.mostrar();
        lista.remove(4);
        lista.mostrar();
    }
}
