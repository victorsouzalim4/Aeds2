import java.util.Scanner;

class Fila{
    int array[];
    int primeiro, ultimo;

   Fila(){
        array = new int[6];
        primeiro = ultimo = 0;
    }
    
   Fila(int tam){
        array = new int[tam +1];
        primeiro = ultimo = 0;
    }

    void I(int x){
        if((ultimo+1) % array.length == primeiro){
            System.out.println("FILA CHEIA");
        }
        else{
            array[ultimo] = x;
            ultimo = (ultimo+1) % array.length;
        }
    }

    int R(){
        int x = -1;
        if(ultimo == primeiro){
            System.out.println("FILA VAZIA");
        }
        else{
            x = array[primeiro];
            primeiro = (primeiro+1) % array.length;
        }
        return x;
    }


    void Mostra(){
        int i = primeiro;
        while(i != ultimo){
            System.out.print(array[i] + " ");
            i = (i+1) % array.length;
        }
        System.out.println();
    }
}

public class FIlaCirc{
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);

        System.out.println("Digite o tamanho da vetor");
        int tam = Sc.nextInt();
        Fila fila = new Fila(tam);


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
                    fila.I(x);
                    break;
                case 2:
                    fila.R();
                    break;
                case 3:
                    fila.Mostra();
                    break;
                default:
                    escolha = 4;
            }

        }
        Sc.close();
    }
}