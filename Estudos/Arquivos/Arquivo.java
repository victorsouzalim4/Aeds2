import java.io.RandomAccessFile;
import java.util.Scanner;

public class Arquivo{
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        try{
            RandomAccessFile arq = new RandomAccessFile("exemplo.txt", "rw");
            
            float num = Sc.nextFloat();

            arq.writeFloat(num);

            num = Sc.nextFloat();

            arq.writeFloat(num);
            arq.seek(2);
            float valor = arq.readFloat();
            
            System.out.println(valor);

            arq.close();
        }catch(Exception test){
            test.printStackTrace();
        }
        Sc.close();
    }
  
}