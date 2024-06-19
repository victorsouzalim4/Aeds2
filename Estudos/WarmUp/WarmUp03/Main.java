package Estudos.WarmUp.WarmUp03;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        int tamEstacionamento;
        int qtdCarros;

        qtdCarros = Sc.nextInt();
        tamEstacionamento = Sc.nextInt();

        while(tamEstacionamento != 0 && qtdCarros != 0){     
            Pilha stack = new Pilha(tamEstacionamento);
            boolean flag = true; 

            for(int i = 0; i < qtdCarros; i++){
                int entrada = Sc.nextInt();
                int saida =  Sc.nextInt();
                Carro car = new Carro(entrada, saida);
                flag = stack.inserir(car);
            }

            if(flag){
                System.out.println("Sim");
            }else{
                System.out.println("Nao");
            }

            qtdCarros = Sc.nextInt();
            tamEstacionamento = Sc.nextInt();
        }

    }
}