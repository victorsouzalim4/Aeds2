import java.io.*;
import java.net.*;
import java.util.Scanner;

class Site {
    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    public static int[] contaCaracter(String html) {

        int valores[] = new int[26];

        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '\u0061') {
                valores[0] = valores[0] + 1;
            } else if (html.charAt(i) == '\u0065') {
                valores[1] = valores[1] + 1;
            } else if (html.charAt(i) == '\u0069') {
                valores[2] = valores[2] + 1;
            } else if (html.charAt(i) == '\u006F') {
                valores[3] = valores[3] + 1;
            } else if (html.charAt(i) == '\u0075') {
                valores[4] = valores[4] + 1;
            } else if (html.charAt(i) == '\u00E1') {
                valores[5] = valores[5] + 1;
            } else if (html.charAt(i) == '\u00E9') {
                valores[6] = valores[6] + 1;
            } else if (html.charAt(i) == '\u00ED') {
                valores[7] = valores[7] + 1;
            } else if (html.charAt(i) == '\u00F3') {
                valores[8] = valores[8] + 1;
            } else if (html.charAt(i) == '\u00FA') {
                valores[9] = valores[9] + 1;
            } else if (html.charAt(i) == '\u00E0') {
                valores[10] = valores[10] + 1;
            } else if (html.charAt(i) == '\u00E8') {
                valores[11] = valores[11] + 1;
            } else if (html.charAt(i) == '\u00EC') {
                valores[12] = valores[12] + 1;
            } else if (html.charAt(i) == '\u00F2') {
                valores[13] = valores[13] + 1;
            } else if (html.charAt(i) == '\u00F9') {
                valores[14] = valores[14] + 1;
            } else if (html.charAt(i) == '\u00E3') {
                valores[15] = valores[15] + 1;
            } else if (html.charAt(i) == '\u00F5') {
                valores[16] = valores[16] + 1;
            } else if (html.charAt(i) == '\u00E2') {
                valores[17] = valores[17] + 1;
            } else if (html.charAt(i) == '\u00EA') {
                valores[18] = valores[18] + 1;
            } else if (html.charAt(i) == '\u00EE') {
                valores[19] = valores[19] + 1;
            } else if (html.charAt(i) == '\u00F4') {
                valores[20] = valores[20] + 1;
            } else if (html.charAt(i) == '\u00FB') {
                valores[21] = valores[21] + 1;
            } else if (html.charAt(i) >= 97 && html.charAt(i) <= 122 && html.charAt(i) != '\u0061'
                    && html.charAt(i) != '\u0065'
                    && html.charAt(i) != '\u0069' && html.charAt(i) != '\u006F' && html.charAt(i) != '\u0075') {
                valores[22] = valores[22] + 1;
            }

        }
        return valores;
    }

    public static boolean endVerifier(String frase) {
        return (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }

    public static void contaTags(String html, int vetor[], String nome) {

        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '<' && html.charAt(i + 1) == 'b' && html.charAt(i + 2) == 'r'
                    && html.charAt(i + 3) == '>') {
                vetor[23] = vetor[23] + 1;
                vetor[22] = vetor[22] - 2;
            } else if (html.charAt(i) == '<' && html.charAt(i + 1) == 't' && html.charAt(i + 2) == 'a'
                    && html.charAt(i + 3) == 'b' && html.charAt(i + 4) == 'l' && html.charAt(i + 5) == 'e'
                    && html.charAt(i + 6) == '>') {
                vetor[24] = vetor[24] + 1;
                vetor[22] = vetor[22] - 3;
                vetor[0] = vetor[0] - 1;
                vetor[1] = vetor[1] - 1;

            }

        }

    }

    public static void main(String[] args) {
        String endereco, html, frase;
        Scanner Sc = new Scanner(System.in);

        frase = Sc.nextLine();

        int vetor[] = new int[26];

        while (!endVerifier(frase)) {
            endereco = Sc.nextLine();
            html = getHtml(endereco);
            vetor = contaCaracter(html);

            contaTags(html, vetor, frase);

            System.out.println(
                    "\u0061" + "(" + (vetor[0]) + ")" + " " + "\u0065" + "(" + (vetor[1]) + ")" + " " + "\u0069" + "("
                            + (vetor[2]) + ")" + " " + "\u006F" + "(" + (vetor[3]) + ")"
                            + " " + "\u0075" + "(" + (vetor[4]) + ")" + " " + "\u00E1" + "(" + (vetor[5]) + ")" + " "
                            + "\u00E9" + "(" + (vetor[6])
                            + ")" + " " + "\u00ED" + "(" + (vetor[7]) + ")"
                            + " " + "\u00F3" + "(" + (vetor[8]) + ")" + " " + "\u00FA" + "(" + (vetor[9]) + ")" + " "
                            + "\u00E0" + "(" + (vetor[10]) + ")" + " " + "\u00E8" + "(" + (vetor[11])
                            + ")" + " " + "\u00EC" + "(" + (vetor[12]) + ")" + " " + "\u00F2" + "(" + (vetor[13]) + ")"
                            + " " + "\u00F9" + "("
                            + (vetor[14]) + ")" + " " + "\u00E3" + "(" + (vetor[15]) + ")"
                            + " " + "\u00F5" + "(" + (vetor[16]) + ")" + " " + "\u00E2" + "(" + (vetor[17]) + ")" + " "
                            + "\u00EA" + "(" + (vetor[18]) + ")" + " "
                            + "\u00EE" + "(" + (vetor[19]) + ")"
                            + " " + "\u00F4" + "(" + (vetor[20]) + ")" + " " + "\u00FB" + "(" + (vetor[21]) + ")" + " "
                            + "consoante" + "("
                            + (vetor[22]) + ")" + " " + "<br>"
                            + "(" + (vetor[23]) + ")" + " " + "<table>" + "(" + (vetor[24]) + ")" + " " + frase);

            frase = Sc.nextLine();

        }

        Sc.close();

    }
}