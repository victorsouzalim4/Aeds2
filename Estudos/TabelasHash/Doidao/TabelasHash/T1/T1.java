package Estudos.TabelasHash.Doidao.TabelasHash.T1;
import Estudos.TabelasHash.Doidao.TabelasHash.T2.*;

public class T1 {
    public String palavraString[];
    public T2 t2;

    public T1(){
        this.palavraString = new String[10];
        this.t2 = null;

        for(int i = 0; i < 10; i++){
            palavraString[i] = null;
        }
    }

    public void inserirPalavra(String palavra){
        int pos = hash(palavra.charAt(palavra.length() - 1));
        if(palavraString[pos] == null){
            System.out.println("Entrei nesse caralho de T1");
            palavraString[pos] = palavra;
        }else{
            pos = rehash(palavra.charAt(palavra.length() - 1));
            if(palavraString[pos] == null){
                palavraString[pos] = palavra;
            }else{
                if(t2 == null){
                    t2 = new T2();
                }

                t2.inserirPalavra(palavra);
            }
        }
    }

    public int hash(char c){
        return (c % 10);
    }

    public int rehash(char c){
        return (++c % 10);
    }
}
