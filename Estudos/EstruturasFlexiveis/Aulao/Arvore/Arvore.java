package Estudos.EstruturasFlexiveis.Aulao.Arvore;

class Arvore {
    No raiz;

    Arvore(){
        raiz = null;
    }

    public void inserir(int x){
        raiz = inserir(raiz, x);
    }

    private No inserir(No i, int x){
        if(i == null){
            i = new No(x);
        }else if(x < i.elemento){
            i.esq = inserir(i.esq, x);
        }else if(x > i.elemento){
            i.dir = inserir(i.dir, x);
        }else{
            System.out.println("Valor ja contido");
        }

        return i;
    }

    public void central(){
        central(raiz);
        System.out.println();
    }

    private void central(No i){
        if(i != null){
            central(i.esq);
            System.out.print(i.elemento + " ");
            central(i.dir);
        }
    }

    public int soma(){
        return soma(raiz);
    }

    private int soma(No i){
        if(i == null) return 0;

        int soma = i.elemento + soma(i.esq) + soma(i.dir);
        return soma;
    }
}
