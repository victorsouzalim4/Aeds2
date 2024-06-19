import java.io.*;

public class Palindrome {
	
	public static boolean endVerifier(String frase) {
		
		if(frase.equals("FIM")) {
			return false;
		}
		return true;
		
	}
	
	
	public static boolean isPalindrome(String frase) {
		for(int i = 0; i < frase.length()/2; i++) {
			if(frase.charAt(i) != frase.charAt(frase.length() - i -1)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args ) throws IOException{
		
		BufferedReader leitor = new BufferedReader( new InputStreamReader(System.in));
		String frase;
		
		frase = leitor.readLine();
		
		
		while(endVerifier(frase)) {
			if(isPalindrome(frase)) {
				System.out.println("SIM");
			}
			else{
				System.out.println("NAO");
			}
			frase = leitor.readLine();
		}
		
	}

}
