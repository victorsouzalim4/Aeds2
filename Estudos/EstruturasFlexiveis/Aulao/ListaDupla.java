package Estudos.EstruturasFlexiveis.Aulao;

class ListaDupla {
    Celula primeira;
    Celula ultimo;
    int tam;

    ListaDupla(){
        primeira = new Celula();
        ultimo = primeira;
        tam = 0;
    }

    void inserirInicio(int x){
        Celula novaSentinela = new Celula();

        primeira.elemento = x;
        primeira.ant = novaSentinela;
        novaSentinela.prox = primeira;
        primeira = novaSentinela;

        tam++;
    }

    void inserirFim(int x){
        Celula novaCelula = new Celula(x);

        novaCelula.ant = ultimo;
        ultimo.prox = novaCelula;
        ultimo = novaCelula;

        tam++;
    }

    void inserir(int x, int pos){
        if(pos == 0) inserirInicio(x);
        else if(pos == tam) inserirFim(x);
        else if(pos > tam || pos < 0) System.out.println("Posicao invalida");
        else{
            Celula novaCelula = new Celula(x);
            Celula tmp = primeira.prox;

            for(int i = 0; i < pos; tmp = tmp.prox, i++);

            novaCelula.ant = tmp.ant;
            tmp.ant.prox = novaCelula;
            novaCelula.prox = tmp;
            tmp.ant = novaCelula;

            tam++;
        }
    }

    int removeInicio(){
        int removido = -1;

        if(tam > 0){
            Celula tmp = primeira;

            primeira = primeira.prox;
            primeira.ant = null;
            tmp.prox = null;

            tam--;
            removido = primeira.elemento;
        }
        
        return removido;
    }

    int removeFim(){
        int removido = -1;

        if(tam > 0){
            Celula tmp = ultimo;
        
            ultimo = ultimo.ant;
            ultimo.prox = null;
            tmp.ant = null;
    
            tam--;
            removido = tmp.elemento;        
        }

        
        return removido;
    }

    int remove(int pos){
        int removido = -1;

        if(pos == 0) removido = removeInicio();
        else if(pos + 1 == tam) removido = removeFim();
        else if(pos < 0 || pos >= tam) System.out.println("Posicao invalida");
        else if(tam > 0){
            Celula tmp = primeira.prox;
            
            for(int i = 0; i < pos; tmp = tmp.prox, i++);

            tmp.prox.ant = tmp.ant;
            tmp.ant.prox = tmp.prox;

            tmp.prox = tmp.ant = null;
            removido = tmp.elemento;

            tam--;
        }
        return removido;
    }

    void mostrar(){
        for(Celula i = primeira.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }
}
