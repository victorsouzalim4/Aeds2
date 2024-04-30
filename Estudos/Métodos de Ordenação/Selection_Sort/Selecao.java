import java.util.Scanner;

public class Selecao{

    public static int[] swap(int[] array, int i, int pos){
        int temp = array[i];
        array[i] = array[pos];
        array[pos] = temp;
        
        return array;

    }

    public static int[] Ordena(int vetor[]){
        
        int n = vetor.length;
        for(int i = 0; i < n-1; i++){
            int menor = vetor[i];
            int pos = i;
            for(int j = n-1; j > i; j--){
                if(vetor[j] < menor){
                    menor = vetor[j];
                    pos = j;
                }
            }
            vetor = swap(vetor, i, pos);
            for(int k = 0; k < vetor.length; k++){
                System.out.print(vetor[k] + " ");
             }
             System.out.println();
        }


        return vetor;
    }
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);

        int array[] = new int[7];

        for(int i = 0; i < array.length; i++){
            array[i] = Sc.nextInt();
        }

        for(int i = 0; i < array.length; i++){
           System.out.print(array[i] + " ");
        }
        System.out.println();

        array = Ordena(array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
         }

    }
}