package Estudos.EstruturasFlexiveis.MatrizFlexivel;

class Celula{
    public int elemento;
    public Celula esq;
    public Celula dir;
    public Celula sup;
    public Celula inf;

    Celula(){
        this.elemento = 0;
        this.esq = this.dir = this.sup = this.inf = null;
    }
}

class Matriz{
    private Celula inicio;
    private int NumLinhas;
    private int NumColunas;

    Matriz(){
        inicio = createLinha();
        Celula linhaAbaixo = createLinha();

        for(Celula i = inicio, tmp = linhaAbaixo; i != null; i = i.dir){
            i.inf = tmp;
            tmp.sup = i;

            tmp = tmp.dir;
        }
        NumLinhas = 2;
        NumColunas = 2;

    }

    Celula createLinha(){
        Celula i = new Celula();
        Celula j = new Celula();

        i.dir = j;
        j.esq = i;

        return i;
    }

    Celula createLinha(int x){
        Celula i = new Celula();
        Celula tmp = i;

        for(int j = 0; j < x - 1; j++){
            Celula nova = new Celula();
            tmp.dir = nova;
            nova.esq = tmp;
            tmp = nova;
        }

        return i;
    }

    Celula createColuna(int x){
        Celula i = new Celula();
        Celula tmp = i;

        for(int j = 0; j < x -1; j++){
            Celula nova = new Celula();
            tmp.inf = nova;
            nova.sup = tmp;

            tmp = nova;
        }

        return i;
    }

    void addLinha(){
        Celula i;
        for(i = inicio; i.inf != null; i = i.inf);
        for(Celula j = createLinha(NumColunas); j != null; j = j.dir){
            i.inf = j;
            j.sup = i;

            i = i.dir;
        }
        NumLinhas++;
    }

    void addColuna(){
        Celula i;
        for(i = inicio; i.dir != null; i = i.dir);
        for(Celula j = createColuna(NumLinhas); j != null; j = j.inf){
            i.dir = j;
            j.esq = i;

            i = i.inf;
        }

        NumColunas++;
    }

    void removeLinha(){
        Celula i;
        for(i = inicio; i.inf != null; i = i.inf);
        while(i != null){
            i.sup.inf = null;
            i.sup = null;

            i = i.dir;
        }
    }

    void mostra(){
        for(Celula i = inicio; i != null; i = i.inf){
            for(Celula j = i; j != null; j = j.dir){
                System.out.print(j.elemento + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class MatrizFlexivel {
    public static void main(String args[]){

        Matriz mat = new Matriz();
        mat.mostra();

        mat.addLinha();
        mat.mostra();

        mat.addColuna();
        mat.mostra();

        mat.addColuna();
        mat.mostra();

        mat.addLinha();
        mat.mostra();

        mat.removeLinha();
        mat.mostra();
        
    }
}
