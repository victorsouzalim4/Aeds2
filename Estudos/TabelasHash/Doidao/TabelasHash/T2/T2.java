package Estudos.TabelasHash.Doidao.TabelasHash.T2;

public class T2 {
    public Celula tabela [];

    public T2(){
        tabela = new Celula[10];
        for(int i = 0; i < 10; i++){
            tabela[i] = new Celula(null);
        }
    }

    public void inserirPalavra(String palavra){
        int pos = hash(palavra.length());
        if(tabela[pos].palavra == null){
            tabela[pos].palavra = palavra;
            System.out.println("Entrei nesse caralho de T2");
        }else{
            Celula tmp;
            if(tabela[pos].palavra.compareTo(palavra) > 0){
                System.out.println("substitui o cabeca");
                tmp = new Celula(tabela[pos].palavra);
                tabela[pos].palavra = palavra;
            }else{
                tmp = new Celula(palavra);
                System.out.println("nao substitui o cabeca");
            }

            int cont = 0;
            Celula ant = tabela[pos];

            for(Celula i = tabela[pos]; i != null; i = i.prox){
                if(i.palavra.compareTo(tmp.palavra) > 0){
                    System.out.println("encadeei " + cont);
                    tmp.prox = i;
                    ant.prox = tmp;
                }else if(i.prox == null){
                    i.prox = tmp;
                    i = tmp;
                }

                if(cont > 1){
                    ant = ant.prox;
                }
                cont++;
            }
        }
    }

    int hash(int tam){
        return (tam % 10);
    }
}
