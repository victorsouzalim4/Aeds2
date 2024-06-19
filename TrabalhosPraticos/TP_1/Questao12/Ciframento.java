import java.util.Scanner;

public class Ciframento{

    public static boolean endVerifier(String frase){
        return(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }

    public static char[] troca(String frase, char novaFrase[]){
        for(int i = 0; i < frase.length(); i++){
            novaFrase[i] = frase.charAt(i);
        }
        return novaFrase;
    }

    public static char[] codifica(String frase){
        return codifica(frase, 0, frase.length() - 1);
    }
        
        public static char[] codifica(String frase, int i, int n){
            
            char novaLetra;
            char novaFrase[] = new char[frase.length()];

            if(n >= i){
                novaLetra = frase.charAt(i);
                novaFrase = troca(frase, novaFrase);
                novaFrase = codifica(frase, i+1, n);
                int test = novaLetra;
                if(test >= 0 && test <= 127 ){
                    novaLetra += 3;
                    novaFrase[i] = novaLetra;
                }
                else{
                    novaFrase[i] = novaLetra;
                }
            }
            else{
                return novaFrase;
            }

            return novaFrase;
        }



    public static void main(String[] args){
        
        Scanner Sc = new Scanner(System.in);

        String frase = Sc.nextLine();
        char novaFrase[] = new char[1000];

        while(!endVerifier(frase)){

            novaFrase = codifica(frase);
            System.out.println(novaFrase);

            frase = Sc.nextLine();
        }
        Sc.close();
    }
}