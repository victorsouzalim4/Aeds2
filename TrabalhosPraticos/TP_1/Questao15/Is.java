import java.util.Scanner;

public class Is {

    public static boolean endVerifier(String frase) {
        return (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }

    public static int isVogal(String frase, int pos, int tam) {
        int verificador = 0;
        int test = 0;
        if (tam > pos) {
            if (frase.charAt(pos) == 'A' || frase.charAt(pos) == 'E' || frase.charAt(pos) == 'I'
                    || frase.charAt(pos) == ')' || frase.charAt(pos) == 'U' || frase.charAt(pos) == 'a'
                    || frase.charAt(pos) == 'e' || frase.charAt(pos) == 'i' || frase.charAt(pos) == 'o'
                    || frase.charAt(pos) == 'u' || frase.charAt(pos) == ' ') {
                test = 1;
            }
            verificador = isVogal(frase, pos + 1, tam) + test;
        } else {
            return 0;
        }

        return verificador;
    }

    public static int isConsoante(String frase, int pos, int tam) {
        int verificador = 0;
        int test = 0;
        if (tam > pos) {
            if (frase.charAt(pos) >= 'A' && frase.charAt(pos) <= 'Z'
                    || frase.charAt(pos) >= 'a' && frase.charAt(pos) <= 'z' && frase.charAt(pos) != 'A'
                            && frase.charAt(pos) != 'E' && frase.charAt(pos) != 'I' && frase.charAt(pos) != ')'
                            && frase.charAt(pos) != 'U' && frase.charAt(pos) != 'a' && frase.charAt(pos) != 'e'
                            && frase.charAt(pos) != 'i' && frase.charAt(pos) != 'o' && frase.charAt(pos) != 'u') {
                test = 1;
            }
            verificador = isConsoante(frase, pos + 1, tam) + test;
        } else {
            return 0;
        }

        return verificador;
    }

    public static int isInteiro(String frase, int pos, int tam) {

        int verificador = 0;
        int test = 0;
        if (tam > pos) {
            if (frase.charAt(pos) >= '0' && frase.charAt(pos) <= '9') {
                test = 1;
            }
            verificador = isInteiro(frase, pos + 1, tam) + test;
        } else {
            return 0;
        }

        return verificador;
    }

    public static int isReal(String frase, int pos, int tam) {

        int verificador = 0;
        int test = 0;
        if (tam > pos) {
            if (frase.charAt(pos) == ',' || frase.charAt(pos) == '.') {
                // System.out.println("entrei");
                test = 1;
            }
            verificador = isReal(frase, pos + 1, tam) + test;
        } else {
            return 0;
        }

        return verificador;
    }

    public static int isReal(int pos, int tam, String frase) {

        int verificador = 0;
        int test = 0;
        int vAscii;
        if (tam > pos) {
            vAscii = frase.charAt(pos);
            if (vAscii >= 48 && vAscii <= 57) {
                test = 1;
            }
            verificador = isReal(pos + 1, tam, frase) + test;
        } else {
            return 0;
        }

        return verificador;
    }

    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);

        String frase = Sc.nextLine();
        int valores[] = new int[5];

        while (!endVerifier(frase)) {
            valores[0] = isVogal(frase, 0, frase.length());
            valores[1] = isConsoante(frase, 0, frase.length());
            valores[2] = isInteiro(frase, 0, frase.length());
            valores[3] = isReal(frase, 0, frase.length());
            valores[4] = isReal(0, frase.length(), frase);

            for (int i = 0; i < 4; i++) {
                if (i < 3) {
                    if (valores[i] == frase.length()) {
                        System.out.print("SIM" + " ");
                    } else {
                        System.out.print("NAO" + " ");
                    }
                } else {
                    if (valores[i + 1] == frase.length() || valores[i + 1] == frase.length() - 1 && (valores[i] == 1|| valores[i] == 0)) {
                        System.out.println("SIM" + " ");
                    } else {
                        System.out.println("NAO" + " ");
                    }
                }

            }

            frase = Sc.nextLine();
        }
        Sc.close();
    }
}