import java.util.Scanner;

public class Insercao {

    public static int[] Ordena(int vetor[]) {

        int n = vetor.length;
        for (int i = 1; i < n; i++) {
            int menor = vetor[i];
            int j = i;
            while (j > 0 && menor < vetor[j - 1] ) {
                vetor[j] = vetor[j - 1];
                j--;
            }
            vetor[j] = menor;

        }
        return vetor;
    }

    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);
        int tam = Sc.nextInt();
        int vetor[] = new int[tam];

        for (int i = 0; i < tam; i++) {
            vetor[i] = Sc.nextInt();
        }

        for (int i = 0; i < tam; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println();

        vetor = Ordena(vetor);

        for (int i = 0; i < tam; i++) {
            System.out.print(vetor[i] + " ");
        }

    }
}