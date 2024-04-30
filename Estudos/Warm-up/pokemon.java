import java.util.Scanner;

public class pokemon {

    public static int verificaIguais(String pokemons[], int qtd) {

        int n = qtd;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //System.out.println(pokemons[i] + " " + pokemons[j]);
                if (pokemons[i].equals(pokemons[j])) {
                    //System.out.println("entrei");
                    qtd--;
                    pokemons[j] = j + " ";
                }
            }
        }

        //System.out.println(qtd);
        return qtd;
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        int qtdPok = Sc.nextInt();
        Sc.nextLine();
        String pokemons[] = new String[qtdPok];

        // System.out.println(pokemons.length);

        for (int i = 0; i < qtdPok; i++) {
            pokemons[i] = Sc.nextLine();
        }

        qtdPok = verificaIguais(pokemons, qtdPok);

        int faltam = 151 - qtdPok;
        System.out.println("Falta(m) " + faltam + " pomekon(s).");
    }
}