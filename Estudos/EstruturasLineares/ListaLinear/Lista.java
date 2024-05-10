import java.util.Scanner;

class List {
    int n;
    int array[];

    List() {
        array = new int[6];
        n = 0;
    }

    List(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }

    void inserirInicio(int x) {
        if (n >= array.length) {
            System.out.println("Erro");
        } else {
            for (int i = n; i > 0; i--) {
                array[i] = array[i - 1];
                //System.out.print(array[i] + " " + " AQUI");
            }
           
            array[0] = x;
            n++;
        }
    }

    void inserirFim(int x) {
        if (n >= array.length) {
            System.out.println("Erro");
        } else {
            array[n] = x;
            n++;
        }
    }

    void inserir(int x, int pos) {
        if (n >= array.length || pos < 0 || pos > n) {
            System.out.println("Erro");
        } else {
            for (int i = n; i > pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos] = x;
            n++;
        }
    }

    int removerInicio() {

        int resp = array[0];
        if (n == 0) {
            System.out.println("Erro");
        } else {
            for (int i = 0; i < n-1 ; i++) {
                array[i] = array[i + 1];
            }
            n--;
        }
        return resp;
    }

    int removerFinal() {

        int resp = array[n - 1];
        if (n == 0) {
            System.out.println("ERRO");
        } else {
            n--;
        }

        return resp;
    }

    int remover(int pos) {
        int resp = array[pos];

        if (n == 0 || pos >= n || pos < 0) {
            System.out.println("ERRO");
        } else {
            for (int i = pos; i < n; i++) {
                array[i] = array[i + 1];
            }
            n--;
        }
        return resp;
    }

    void mostra() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
    }

    int Soma(){
        int soma = 0;
        for(int i = 0; i < n; i++){
            soma += array[i];
        }

        return soma;
    }

    int Maior(){
        int maior = array[0];

        for(int i = 1; i < n; i++){
            if(array[i] > maior){
                maior = array[i];
            }
        }

        return maior;
    }

    void Inverte(){
        int temp[] = new int[array.length];

        for(int i = 0; i < n; i++){
            temp[i] = array[n-1-i];
        }
        for(int i = 0; i < n; i++){
            array[i] = temp[i];
        }
    }

    int Elementos(){   
        int count = 0;
        for(int i = 0; i < n; i++){
            if(array[i] % 2 == 0 || array[i] % 5 == 0){
                count++;
            }
        }
        return count;
     }

    void OrdenaSelecao(){
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0; j--){
                if(array[j] < array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        
        }
    }

    void OrdenaInsercao(){
        for(int i = 1; i < n; i++){
            int temp = array[i];
            int j = i;

            while(j > 0 && (temp < array[j-1])){
                array[j] = array[j-1];
                j--;
            }
            
            array[j] = temp;

            
        }
    }

    void OrdenaBolha(){
        
    }
}

public class Lista {

    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);

        List lista = new List(6);

        lista.inserirInicio(1);

        lista.mostra();
        lista.inserirFim(7);
        lista.mostra();
        lista.inserirFim(9);
        lista.mostra();
        lista.inserirInicio(3);

       lista.mostra();
        lista.inserir(8, 3);

       lista.mostra();

        lista.inserir(4, 2);


        lista.mostra();
        System.out.println("Seleçao");
        lista.OrdenaSelecao();
        lista.mostra();

  

        lista.removerInicio();
        lista.mostra();
        lista.removerFinal();

        lista.mostra();
        lista.remover(2);

        lista.mostra();

        int soma = lista.Soma();
        System.out.println(soma);

        int maior = lista.Maior();
        System.out.println(maior);

        lista.Inverte();
        lista.mostra();

        System.out.println("Inserçao");
        lista.OrdenaInsercao();
        lista.mostra();


        int qtd = lista.Elementos();
        System.out.println(qtd);


    }

}