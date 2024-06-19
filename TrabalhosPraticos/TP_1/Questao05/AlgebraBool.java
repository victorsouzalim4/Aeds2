import java.util.Scanner;

public class AlgebraBool {

    public static void converteParaChar(char novaFrase[], String frase) {

        for (int i = 0; i < novaFrase.length; i++) {
            novaFrase[i] = frase.charAt(i);
        }
    }

    public static void retiraEntradas(char frase[], int qtd) {

        for (int i = 0; i < 8; i++) {
            if (frase[i] == 'a' || frase[i] == 'n' || frase[i] == 'o') {
                i = 8;
            } else {
                frase[i] = ' ';
            }
        }
    }

    public static Boolean temParenteses(char frase[]) {
        boolean test = false;

        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == '(' || frase[i] == ')') {
                test = true;
            }
        }

        return test;
    }

    public static int contaVariaveis(char novafrase[]) {
        int num = novafrase[0];

        num -= 48;
        return num;
    }

    public static char[] leVariaveis(char ValoresDasVariaveis[], char novaFrase[]) {

        for (int i = 2, j = 0; i <= ValoresDasVariaveis.length * 2; i += 2, j++) {
            ValoresDasVariaveis[j] = novaFrase[i];
        }

        return ValoresDasVariaveis;
    }

    public static void substituiValoresNaFrase(char ValoresDasVariaveis[], char novaFrase[]) {

        for (int i = 0; i < novaFrase.length; i++) {
            if (novaFrase[i] == 'A') {
                novaFrase[i] = ValoresDasVariaveis[0];
            } else if (novaFrase[i] == 'B') {
                novaFrase[i] = ValoresDasVariaveis[1];
            } else if (novaFrase[i] == 'C') {
                novaFrase[i] = ValoresDasVariaveis[2];
            }
        }
    }

    public static int FechamentoParenteses(char frase[]) {
        int pos = 0;
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == ')') {
                pos = i;
                i = frase.length;
            }
        }

        return pos;
    }

    public static int AberturaParenteses(int posFinal, char frase[]) {
        int pos = 0;
        for (int i = posFinal; i > 0; i--) {
            if (frase[i] == '(') {
                pos = i;
                i = 0;
            }
        }

        return pos;
    }

    public static int contaVariaveisParaOperar(char frase[], int posInicial, int posFinal) {
        int qtd = 0;

        for (int i = posInicial; i < posFinal; i++) {
            if (frase[i] == '0' || frase[i] == '1') {
                qtd++;
            }
        }

        return qtd;
    }

    public static void Not(char frase[], int posInicial, int posFinal) {
        for (int i = posInicial; i < posFinal; i++) {
            if (frase[i] == '0') {
                frase[i] = '1';
            } else if (frase[i] == '1') {
                frase[i] = '0';
            }
        }

        for (int i = posInicial - 3; i <= posFinal; i++) {
            if (frase[i] != '1' && frase[i] != '0') {
                frase[i] = ' ';
            }
        }
    }

    public static void And(char frase[], int posInicial, int posFinal, int tamanho) {

        Boolean valorLogico[] = new Boolean[tamanho];
        char result;

        int j = 0;
        for (int i = posInicial; i < posFinal; i++) {
            if (frase[i] == '1') {
                valorLogico[j] = true;
                // System.out.println(valorLogico[j] + " " + j);
                j++;
            } else if (frase[i] == '0') {
                valorLogico[j] = false;
                // System.out.println(valorLogico[j] + " " + j);
                j++;
            }
        }

        Boolean resultado = valorLogico[0];
        for (int k = 1; k < valorLogico.length; k++) {
            resultado = resultado && valorLogico[k];
        }
        // System.out.println(resultado);

        if (resultado == false) {
            result = '0';
        } else {
            result = '1';
        }

        int test = 0;
        for (int p = posInicial - 3; p <= posFinal; p++) {
            if ((frase[p] == '0' || frase[p] == '1') && test == 0) {
                frase[p] = result;
                test++;
            } else {
                frase[p] = ' ';
            }
        }

    }

    public static void Or(char frase[], int posInicial, int posFinal, int tamanho) {

        Boolean valorLogico[] = new Boolean[tamanho];
        char result;

        int j = 0;
        for (int i = posInicial; i < posFinal; i++) {
            if (frase[i] == '1') {
                valorLogico[j] = true;
                // System.out.println(valorLogico[j] + " " + j);
                j++;
            } else if (frase[i] == '0') {
                valorLogico[j] = false;
                // System.out.println(valorLogico[j] + " " + j);
                j++;
            }
        }

        Boolean resultado = valorLogico[0];
        for (int k = 1; k < valorLogico.length; k++) {
            resultado = resultado || valorLogico[k];
        }
        // System.out.println(resultado);

        if (resultado == false) {
            result = '0';
        } else {
            result = '1';
        }

        int test = 0;
        for (int p = posInicial - 2; p <= posFinal; p++) {
            if ((frase[p] == '0' || frase[p] == '1') && test == 0) {
                frase[p] = result;
                test++;
            } else {
                frase[p] = ' ';
            }
        }

    }

    public static char verificaResultado(char frase[]) {
        char result = 'E';

        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == '0' || frase[i] == '1') {
                result = frase[i];
            }
        }

        return result;
    }

    public static char Opera(char frase[]) {

        int posFinal = FechamentoParenteses(frase), posInicial = AberturaParenteses(posFinal, frase);

        while (posFinal != posInicial) {
            // System.out.println("entrei");
            if (frase[posInicial - 1] == 't') {
                Not(frase, posInicial, posFinal);
                // System.out.println(frase);
            } else if (frase[posInicial - 1] == 'd') {
                int cont = contaVariaveisParaOperar(frase, posInicial, posFinal);
                And(frase, posInicial, posFinal, cont);
                // System.out.println(frase);
            } else if (frase[posInicial - 1] == 'r') {
                int cont = contaVariaveisParaOperar(frase, posInicial, posFinal);
                Or(frase, posInicial, posFinal, cont);
                // System.out.println(frase);
            }

            posFinal = FechamentoParenteses(frase);
            posInicial = AberturaParenteses(posFinal, frase);

        }

        char resultado = verificaResultado(frase);
        return resultado;
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String frase = Sc.nextLine();

        while (frase.charAt(0) != '0') {

            char novaFrase[] = new char[frase.length()];
            converteParaChar(novaFrase, frase);
            int qtdVariaveis = contaVariaveis(novaFrase);

            char ValoresDasVariaveis[] = new char[qtdVariaveis];
            ValoresDasVariaveis = leVariaveis(ValoresDasVariaveis, novaFrase);

            substituiValoresNaFrase(ValoresDasVariaveis, novaFrase);
            retiraEntradas(novaFrase, qtdVariaveis);
            // System.out.println(novaFrase);

            char resultado = Opera(novaFrase);
            System.out.println(resultado);

            frase = Sc.nextLine();
        }

    }
}
