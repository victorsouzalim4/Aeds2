import java.util.Scanner;

class Pil{
    int array[];
    int n;


    Pil(){
        array = new int[6];
        n = 0;
    }
    Pil(int tam){
        array = new int[tam];
        n = 0;
    }

    void II(int x){
        
        if(array.length == n){
            System.out.println("PILHA CHEIA");
        }
        else{
            for(int i = n; i > 0; i--){
                array[i] = array[i-1];
            }
            array[0] = x;
            n++;
        }
      
    }

    int RI(){

        if(n == 0 || array.length == 0){
            System.out.println("PILHA VAZIA");
            return -1;
        }
        else{
            int x = array[0];

            for(int i = 0; i < n -1; i++){
                array[i] = array[i+1];
            }
            n--;
    
            return x;
        }

    }

    void Mostra(){
        System.out.println("PILHA: ");
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class Pilha{
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);

        System.out.println("Digite o tamanho da vetor");
        int tam = Sc.nextInt();
        Pil pilha = new Pil(tam);


        int escolha = 0;
        while(escolha != 4){
            System.out.println("====================================================");
            System.out.println("1- Adicionar");
            System.out.println("2- Remover");
            System.out.println("3- Mostrar");
            System.out.println("4- Sair");
            System.out.println("====================================================");

            escolha = Sc.nextInt();
            switch(escolha){
                case 1:
                    System.out.println("Digite o valor que deseja adicionar");
                    int x = Sc.nextInt();
                    pilha.II(x);
                    break;
                case 2:
                    pilha.RI();
                    break;
                case 3:
                    pilha.Mostra();
                    break;
                default:
                    escolha = 4;
            }

            //escolha = Sc.nextInt();
        }
        


    }
}