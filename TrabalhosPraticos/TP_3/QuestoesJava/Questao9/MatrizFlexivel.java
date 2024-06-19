//package Questao9;

import java.util.Scanner;

class Celula {
    public int elemento;
    public Celula esq;
    public Celula dir;
    public Celula sup;
    public Celula inf;

    Celula() {
        this.elemento = 0;
        this.esq = this.dir = this.sup = this.inf = null;
    }
}

class Matriz {
    public Celula inicio;
    public int NumLinhas;
    public int NumColunas;

    Matriz(){
        inicio = createLinha();
        Celula linhaAbaixo = createLinha();

        for (Celula i = inicio, tmp = linhaAbaixo; i != null; i = i.dir) {
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

        for (int j = 0; j < x - 1; j++) {
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

        for (int j = 0; j < x - 1; j++) {
            Celula nova = new Celula();
            tmp.inf = nova;
            nova.sup = tmp;

            tmp = nova;
        }

        return i;
    }

    void addLinha(){
        Celula i;
        for (i = inicio; i.inf != null; i = i.inf)
            ;
        for (Celula j = createLinha(NumColunas); j != null; j = j.dir) {
            i.inf = j;
            j.sup = i;

            i = i.dir;
        }
        NumLinhas++;
    }

    void addColuna(){
        Celula i;
        for (i = inicio; i.dir != null; i = i.dir)
            ;
        for (Celula j = createColuna(NumLinhas); j != null; j = j.inf) {
            i.dir = j;
            j.esq = i;

            i = i.inf;
        }

        NumColunas++;
    }

    void removeLinha(){
        if (NumLinhas == 0) {
            try {
                throw new Exception("Matriz vazia");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (NumLinhas == 1) {
            inicio = null;
            NumLinhas--;
        } else {
            Celula i;
            for (i = inicio; i.inf != null; i = i.inf)
                ;
            while (i != null) {
                i.sup.inf = null;
                i.sup = null;

                i = i.dir;
            }

            NumLinhas--;
        }
    }

    void removeColuna(){
        if (NumColunas == 0) {
            try {
                throw new Exception("Matriz vazia");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (NumColunas == 1) {
            inicio = null;
            NumColunas--;
        } else {
            Celula i;
            for (i = inicio; i.dir != null; i = i.dir)
                ;
            while (i != null) {
                i.esq.dir = i.esq = null;
                i = i.inf;
            }
            NumColunas--;
        }
    }

    void addElemento(int x, int linhaPos, int colunaPos){
        if(linhaPos >= NumLinhas || colunaPos >= NumColunas || linhaPos < 0 || colunaPos < 0){
            try{
                throw new Exception("Posicao invalida");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Celula tmp = inicio;
            for(int i = 0; i < colunaPos; i++){
                tmp = tmp.dir;
            }
            for(int i = 0; i < linhaPos; i++){
                tmp = tmp.inf;
            }
            tmp.elemento = x;
        }
    }

    void getDiagonalPrincipal(){
        if(NumColunas != NumLinhas){
            try{
                throw new Exception("Esta matriz nao possui Diagonal Principal");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Celula i = inicio;

            while(i != null){
                System.out.print(i.elemento + " ");
                i = i.dir;
                if(i != null){
                    i = i.inf;
                }
            }
            System.out.println();
        }

    }

    void getDiagonalSecundaria(){
        if(NumColunas != NumLinhas){
            try{
                throw new Exception("Esta matriz nao possui Diagonal Principal");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Celula i = inicio;

            while(i.dir != null){
                i = i.dir;
            }

            while(i != null){
                System.out.print(i.elemento + " ");
                i = i.esq;
                if(i != null){
                    i = i.inf;
                }
            }
            System.out.println();
        }
    }

    void mostra(){
        for (Celula i = inicio; i != null; i = i.inf) {
            for (Celula j = i; j != null; j = j.dir) {
                System.out.print(j.elemento + " " );
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class MatrizFlexivel {

    public static void multiplicaMatrizes(Matriz mat1, Matriz mat2){
        
        //int contador = 0;
        if(mat1.NumColunas == mat2.NumLinhas){
            for (Celula i = mat1.inicio ; i != null ; i = i.inf) {
                for(Celula k = mat2.inicio;  k != null; k = k.dir){
                    int soma = 0;
                    for (Celula j = i, p = k; j != null && p != null; j = j.dir, p = p.inf) {
                        soma = soma + (j.elemento* p.elemento);
                    }
                    System.out.print(soma + " ");
                }
                System.out.println();
            }
        }
        
    }
    
    public static void somaMatrizes(Matriz mat1, Matriz mat2){
        for (Celula i = mat1.inicio, k = mat2.inicio; i != null && k != null; i = i.inf, k = k.inf) {
            for (Celula j = i, p = k; j != null && p != null; j = j.dir, p = p.dir) {
                System.out.print((j.elemento + p.elemento) + " " );
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner Sc = new Scanner(System.in);

        int numInstancias = Sc.nextInt();

        for(int i = 0; i < numInstancias; i++){
            Matriz mat = new Matriz();
            Matriz mat1 = new Matriz();

            int numLinhas = Sc.nextInt();
            int numColunas = Sc.nextInt();

            for(int j = 0; j < numLinhas - 2; j++){
                mat.addLinha();
            }
            for(int j = 0; j < numColunas - 2; j++){
                mat.addColuna();
            }

            for(int j = 0; j < numLinhas ; j++){
                for(int k = 0; k < numColunas; k++){
                    mat.addElemento(Sc.nextInt(), j, k);
                }
            }

            numLinhas = Sc.nextInt();
            numColunas = Sc.nextInt();

            for(int j = 0; j < numLinhas - 2; j++){
                mat1.addLinha();
            }
            for(int j = 0; j < numColunas - 2; j++){
                mat1.addColuna();
            }

            for(int j = 0; j < numLinhas ; j++){
                for(int k = 0; k < numColunas; k++){
                    mat1.addElemento(Sc.nextInt(), j, k);
                }
            }
            
            mat.getDiagonalPrincipal();
            mat.getDiagonalSecundaria();
            somaMatrizes(mat, mat1);
            multiplicaMatrizes(mat, mat1);
            //mat.mostra();
            //mat1.mostra();

            
        }



    }
}
