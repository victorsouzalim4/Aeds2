import java.util.Scanner;

public class Sequencial{

    public static void Pesquisa(int array[], int num){
        int test = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == num){
                System.out.println(num + " encontrado na posicao " + i);
                test = 1;
            }
        }

        if(test == 0){
            System.out.println("Elemento nao encontrado");
        }
    }
   
    public static void main(String[] args){
        Scanner Sc = new Scanner (System.in);
        int array[] = new int[10];

        for(int i = 0; i < array.length; i++){
            array[i] = i*2 + 1;
        }

        int num = Sc.nextInt();
        Pesquisa(array, num);
        Sc.close();
    }
}