package Estudos.TabelasHash.TabelaPointers;

public class Main {
    public static void main(String[] args){
        HashTable tabelinhaDaDebs = new HashTable();
        tabelinhaDaDebs.inserir(0);
        tabelinhaDaDebs.inserir(10);
        tabelinhaDaDebs.inserir(20);
        tabelinhaDaDebs.inserir(2);
        tabelinhaDaDebs.inserir(12);
        tabelinhaDaDebs.inserir(5);
        
        tabelinhaDaDebs.mostrar();
    }
}
