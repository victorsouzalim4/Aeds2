import java.io.*;

public class Cifra {
	
	public static boolean endVerifier(StringBuilder frase) {
		
		
		if(frase.toString().equals("FIM")) {
			return false;
		}
		
		return true;
		
	}
	
	public static StringBuilder changeCharacter(StringBuilder frase) {
		
		for(int i = 0; i < frase.length(); i++) {
			int aux = frase.charAt(i);
			if(aux >= 0 && aux <= 127) {
				aux = aux + 3;
				char aux2 = (char)aux;
				frase.setCharAt(i, aux2);
			}
		}
		
		return frase;
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader leitor = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder frase = new StringBuilder(leitor.readLine());
		
		while(endVerifier(frase)) {
			frase = changeCharacter(frase);
			System.out.println(frase);
			frase = new StringBuilder(leitor.readLine());
			
		}
		
	}

}
