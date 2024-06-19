import java.util.Scanner;

public class palindromo{

    public static boolean endVerifier(String frase){
        
        return(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }
    

    public static boolean IsPalindromo(int i, int n, String frase ){

        boolean test = true;
        
        if(i < n){
            if(frase.charAt(i) != frase.charAt(n)){
                test = false;
            }
            else{
                test = IsPalindromo(i+1, n-1, frase);
            }
        }

        return test;
    }


    public static void main(String[] args){

        Scanner Sc = new Scanner(System.in);

        String frase;
        boolean valor;

        frase = Sc.nextLine();

        while(!(endVerifier(frase))){
            valor = IsPalindromo(0, frase.length()-1, frase);
            if(valor == true){
                System.out.println("SIM");
            }
            else{
                System.out.println("NAO");
            }
            frase = Sc.nextLine();
        }
        Sc.close();
    }

}