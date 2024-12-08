package Estudos.TabelasHash.Doidao.Arvore;

import Estudos.TabelasHash.Doidao.TabelasHash.T1.T1;

public class Arvore {
    No raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void inserir(char c){
        raiz = inserir(raiz, c);
    }

    private No inserir(No i, char c){
        if(i == null){
            i = new No(c);
        }else if(c < i.caracter){
            i.esq = inserir(i.esq, c);
        }else if(c > i.caracter){
            i.dir = inserir(i.dir, c);
        }else{
            System.out.println("Nao foi possivel inserir");
        }

        return i;
    }

    public void mostrarArvore(){
        mostrarArvore(raiz);
    }

    private void mostrarArvore(No i){
        if(i != null){
            mostrarArvore(i.esq);
            System.out.println(i.caracter);
            mostrarArvore(i.dir);
        }
    }

    public void inserirPalavra(String palavra){
        inserirPalavra(raiz, palavra);
    }

    private void inserirPalavra(No i, String palavra){
        if(i == null){
            System.out.println("Nao foi possivel inserir palavra");
        }else if(palavra.charAt(0) < i.caracter){
            inserirPalavra(i.esq, palavra);
        }else if(palavra.charAt(0) > i.caracter){
            inserirPalavra(i.dir, palavra);
        }else{
            if(i.t1 == null){
                System.out.println("Entrei nesse caralho de Arvore");
                i.t1 = new T1();
            }

            i.t1.inserirPalavra(palavra);
        }
    }
}
