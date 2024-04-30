import java.util.Scanner;

class Fil {
    int array[];
    int n;

    Fil() {
        array = new int[6];
        n = 0;
    }

    Fil(int tam) {
        array = new int[tam];
        n = 0;
    }

    void IF(int x) {
        if (n == array.length) {
            System.out.println("FILA CHEIA");
        } else {
            array[n++] = x;
        }
    }

    int RI() {
        int x = array[0];
        if (n == 0) {
            System.out.println("FILA VAZIA");
            return -1;
        } else {
            for (int i = 0; i < n-1; i++) {
                array[i] = array[i + 1];
            }
            n--;
        }

        return x;
    }

    void Mostra() {
        System.out.println("FILA: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class Fila {

    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);

        System.out.println("Digite o tamanho da vetor");
        int tam = Sc.nextInt();
        Fil pilha = new Fil(tam);


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
                    pilha.IF(x);
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