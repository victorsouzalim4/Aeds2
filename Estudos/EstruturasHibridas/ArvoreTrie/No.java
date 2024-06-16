package Estudos.EstruturasHibridas.ArvoreTrie;
 

class No {
    public char letra;
    public int tamanho;
    public No[] prox;
    public boolean folha; 

    No(){
        this(' ');
    }

    No(char letra){
        this.letra = letra;
        tamanho = 255;
        prox = new No[tamanho];
        folha = false;

        for(int i = 0; i < tamanho; i++){
            prox[i] = null;
        }
    }
}
