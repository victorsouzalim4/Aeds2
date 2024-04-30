import java.util.Scanner;

public class Bubble{

    public static int[] Bolha(int array[]){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                Mostra(array);
            }
        }

        return array;
    }

    public static void Mostra(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
         int tam = Sc.nextInt();
         int array[] =  new int[tam];

        for(int i = 0; i < array.length; i++){
            array[i] = Sc.nextInt();
        }

        Mostra(array);
        
        array = Bolha(array);

        

    }
}