import java.util.Random;
import java.util.Scanner;

public class aleatoria{


    public static boolean trocaString(String palavra, char ch1, char ch2){

        char[] novaString = new char[palavra.length()];
        
        if(palavra.equals("FIM")){
            return false;
        }

        for(int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) == ch1){
                novaString[i] = ch2;
            }
            else{
                novaString[i] = palavra.charAt(i);
            }
        }
        
        System.out.println(novaString);

        return true;
    }



    public static void main(String[] args){

        Random gerador = new Random();
        gerador.setSeed(4);
        char caractere1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        char caractere2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        Scanner sc = new Scanner(System.in);

        //System.out.println(caractere1 + " " + caractere2);

        String palavra = sc.nextLine();

        while(trocaString(palavra, caractere1, caractere2)){
            caractere1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            caractere2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            palavra = sc.nextLine();
        }
        
    }
}