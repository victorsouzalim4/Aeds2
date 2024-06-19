import java.util.Scanner;

public class Is{

    public static boolean endVerifier(String frase){
        if(frase.length() == 3 && frase.charAt(0) == 'F'  && frase.charAt(1) == 'I'  && frase.charAt(2) == 'M'){
            return false;
        }
        return true;
    }




    public static boolean isVogal(String frase){
        for(int i = 0; i < frase.length(); i++){
            if( frase.charAt(i) != 'A' && frase.charAt(i) != 'E' && frase.charAt(i) != 'I' && frase.charAt(i) != 'O'&& frase.charAt(i) != 'U'&& frase.charAt(i) != 'a'&& frase.charAt(i) != 'e'&& frase.charAt(i) != 'i'&& frase.charAt(i) != 'o'&& frase.charAt(i) != 'u' && frase.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    } 
    

    public static boolean isConsoante(String frase){
        for(int i = 0; i < frase.length(); i++){
            int periodo = frase.charAt(i);
            if( frase.charAt(i) != ' ' && !(periodo >=65 && periodo <= 90 || periodo >= 97 && periodo <= 122) || (frase.charAt(i) == 'A' || frase.charAt(i) == 'E' && frase.charAt(i) == 'I' || frase.charAt(i) == 'O' || frase.charAt(i) == 'U' || frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' || frase.charAt(i) == 'u')){
                return false;
            }
        }
        return true;
    }


    public static boolean isInteiro(String frase){
        for(int i = 0; i < frase.length() ; i++){
            int periodo = frase.charAt(i);
            if(!(periodo >= 48 && periodo <= 57)){
                return false;
            }
        }
        return true;
    }


    public static boolean isFloat(String frase){
        int cont = 0;
        boolean test = true;;
        
        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == ',' || frase.charAt(i) == '.'){
                cont++;
            }
            int periodo = frase.charAt(i);
            if(!(periodo >= 48 && periodo <= 57) && frase.charAt(i) != ',' && frase.charAt(i) != '.' ){
                
                test = false;
            }
        }

        if(test == false || cont != 0 && cont != 1){
            return false;
        }
        
        return true;
    }


    public static void main(String[] args){
        //Scanner Sc = new Scanner(System.in);

        String frase = MyIO.readLine();
        

        while(endVerifier(frase)){
            String vogal = "NAO", consoante = "NAO", inteiro = "NAO", real = "NAO";
            if(isVogal(frase)){
                vogal = "SIM";
            }
            if(isConsoante(frase)){
                consoante = "SIM";
            }
            if(isInteiro(frase)){
                inteiro = "SIM";
            }
            if(isFloat(frase)){
                real = "SIM";
            }

            System.out.println(vogal + " " + consoante + " " + inteiro + " " + real);
            frase = MyIO.readLine();
        }
    }
}