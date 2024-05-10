import java.util.Scanner;

public class Quick {

    public static void Mostra(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void Swap(int array[], int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void Ordena(int array[], int esq, int dir) {

        int i = esq;
        int j = dir;
        int pivot = array[(i+j)/2];

        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot ) {
                j--;
            }

            if (i <= j) {
                Swap(array, i, j);
                i++;
                j--;
            }
            Mostra(array);
        }
        

        if (esq < j) {
            Ordena(array, esq, j);
        }
        if (dir > i) {
            Ordena(array, i, dir);
        }
       

    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

       
        int array[] = {3,7,1,4,0,9,2,5,11};


        Ordena(array, 0, array.length - 1);
    }
}