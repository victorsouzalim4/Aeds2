package Estudos.EstruturasHibridas.ArvoreTrie;

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

}
