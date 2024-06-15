package Estudos.EstruturasHibridas.HashTableDeLista;
import java.util.Scanner;

class Celula {
    public int elemento;
    public Celula prox;

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Lista {
    public Celula primeiro;
    public Celula ultimo;
    public int tam;

    public Lista() {
        primeiro = ultimo = null;
        tam = 0;
    }

    public void inserirFim(int x) {
        if (primeiro == null) {
            primeiro = ultimo = new Celula(x);
        } else {
            ultimo.prox = new Celula(x);
            ultimo = ultimo.prox;
        }
        tam++;
    }

    public void inserirInicio(int x) {
        Celula nova = new Celula(x);
        if (primeiro == null) {
            primeiro = ultimo = nova;
        } else {
            nova.prox = primeiro;
            primeiro = nova;
        }
        tam++;
    }

    public void inserir(int x, int pos) {
        if (pos < 0 || pos > tam) {
            try {
                throw new Exception("INVALID POSITION");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tam) {
            inserirFim(x);
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos - 1; i = i.prox, j++);
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tam++;
        }
    }

    public void removeFim() {
        if (primeiro == null) {
            try {
                throw new Exception("EMPTY LIST");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (primeiro == ultimo) {
            primeiro = ultimo = null;
            tam--;
        } else {
            Celula i;
            for (i = primeiro; i.prox != ultimo; i = i.prox);
            ultimo = i;
            ultimo.prox = null;
            tam--;
        }
    }

    public void removeInicio() {
        if (primeiro == null) {
            try {
                throw new Exception("EMPTY LIST");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (primeiro == ultimo) {
            primeiro = ultimo = null;
            tam--;
        } else {
            primeiro = primeiro.prox;
            tam--;
        }
    }

    public void remove(int pos) {
        if (pos < 0 || pos >= tam) {
            try {
                throw new Exception("INVALID POSITION");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (pos == 0) {
            removeInicio();
        } else if (pos == tam - 1) {
            removeFim();
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos - 1; i = i.prox, j++);
            Celula tmp = i.prox;
            i.prox = tmp.prox;
            tam--;
        }
    }

    public boolean pesquisa(int x){
        boolean flag = false;
        for(Celula i = primeiro; i != null; i = i.prox){
            if(i.elemento == x){
                flag = true;
                i = ultimo;
            }
        }

        return flag;
    }

    public void mostraLista() {
        for (Celula i = primeiro; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
}
