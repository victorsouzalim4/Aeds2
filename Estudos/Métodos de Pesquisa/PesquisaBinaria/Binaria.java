import java.util.Scanner;

public class Binaria {

    public static void Pesquisa(int array[], int num) {

        int pos = 0;
        int n = array.length;

        while (pos < n) {
            int meio = (pos + n) / 2;
            if (array[meio] == num) {
                n = pos;
            } else if (array[meio] > num) {
                n = meio - 1;
            } else {
                pos = meio + 1;
            }
        }
    }

    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);
        int array[] = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * i + 1;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int x = Sc.nextInt();

        Pesquisa(array, x);
    }
}