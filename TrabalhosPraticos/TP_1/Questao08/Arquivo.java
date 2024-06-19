
//import java.util.MyIOanner;
import java.io.RandomAccessFile;

public class Arquivo {
    public static void main(String[] args) {
        // Scanner Sc = new Scanner(System.in);

        int qtd;

        try {
            RandomAccessFile arq = new RandomAccessFile("Arquivo.txt", "rw");
            qtd = MyIO.readInt();

            float num;
            int temp = qtd;

            while (qtd > 0) {
                num = MyIO.readFloat();
                arq.writeFloat(num);
                qtd--;
            }

            // System.out.println(pos);
            // long pos = arq.getFilePointer();
            // arq.close();
            // arq = new RandomAccessFile("Arquivo.txt", "rw");
            // long pos = (long) qtd;

            while (temp > 0) {
                arq.seek(4 * (temp - 1));

                num = arq.readFloat();
                if (num == (int) num) {
                    System.out.println((int) num);
                } else {
                    System.out.println(num);
                }

                temp--;
            }
            arq.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}