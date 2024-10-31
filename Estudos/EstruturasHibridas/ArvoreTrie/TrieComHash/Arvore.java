package Estudos.EstruturasHibridas.ArvoreTrie.TrieComHash;

class Arvore{
    No raiz;

    Arvore(){
        raiz = new No();
    }

    public void inserir(String palavra){
        inserir(raiz, palavra, 0);
    }

    private void inserir(No i, String palavra, int pos){
        if(i.prox[palavra.charAt(pos)] == null){
            i.prox[palavra.charAt(pos)] = new No(palavra.charAt(pos));

            if(pos == palavra.length() -1){
                i.prox[palavra.charAt(pos)].folha = true;
            }else{
                inserir(i.prox[palavra.charAt(pos)], palavra, ++pos);
            }
    
        }else if(i.prox[palavra.charAt(pos)].folha != true && pos < palavra.length() - 1){
            inserir(i.prox[palavra.charAt(pos)], palavra, ++pos);

        }else{
            System.out.println("ERRO AO INSERIR");
        }
    }

    public void mostra(){
        mostra(raiz, "");
    }

    private void mostra(No i, String palavra){
        if(i.folha == true){
            System.out.println(palavra + i.letra);
        }else{
            for(int j = 0; j < 255; j++){
                if(i.prox[j] != null){
                    if(i != raiz){
                        mostra(i.prox[j], palavra + i.letra);
                    }else{
                        mostra(i.prox[j], palavra);
                    }

                }
            }
        }
    }

    public void pesquisa(String palavra){
        if(pesquisa(raiz, palavra, -1)){
            System.out.println("Palavra encontrada");
        }else{
            System.out.println("Palavra nao encontrada");
        }
    }

    private boolean pesquisa(No i, String palavra, int pos){
        boolean flag;
        pos++;

        if(i.folha != true && i.prox[palavra.charAt(pos)] == null){
            flag = false;
        }else if(i.folha == true && pos < palavra.length()){
            flag = false;
        }else if(i.folha == true && pos == palavra.length()){
            flag = true;
        }else{
            flag = pesquisa(i.prox[palavra.charAt(pos)], palavra, pos);
        }

        return flag;
    }

    public int countA(){
        return countA(raiz);
    }

    private int countA(No i){
        int count = 0;

        if(i.folha == true && i.letra == 'a'){
            count++;
        }else{
            if(i.letra == 'a'){
                count++;
                for(int j = 0; j < i.prox.length; j++){
                    if(i.prox[j] != null){
                        count += countA(i.prox[j]);
                    }
                }
            }else{
                for(int j = 0; j < i.prox.length; j++){
                    if(i.prox[j] != null){
                        count += countA(i.prox[j]);
                    }
                }
            }
        }


        return count;
    }
}
