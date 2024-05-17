package Estudos.EstruturasFlexiveis.Arvore.ArvoreDeLista;

class Contato{
    public String nome;
    public String telefone;
    public String email;
    public int cpf;

    Contato(){
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.cpf = 0;
    }
    Contato(String nome, String telefone, String email, int cpf){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
}

class Celula{
    public Contato contato;
    public Celula prox;

    Celula(){
        contato = new Contato();
        this.prox = null;
    }
    Celula(String nome, String telefone, String email, int cpf){
        contato = new Contato(nome, telefone, email, cpf);
        this.prox = null;
    }
}

class No{
    public char letra;
    public No dir, esq;
    public Celula primeiro, ultimo;

    No(char letra){
        this.letra = letra;
        this.dir = this.esq = null;
        primeiro = new Celula();
        ultimo = primeiro;
    }
    No(char letra, String nome, String telefone, String email, int cpf){
        this.letra = letra;
        this.dir = this.esq = null;
        primeiro = new Celula(nome, telefone, email, cpf);
        ultimo = primeiro;
    }
}

class Agenda{
    private No raiz;

    Agenda(){
        raiz = new No('M');
        for(char letra = 'A'; letra <= 'Z'; letra += 2){
            raiz = inserirNo(raiz, letra);
        }
        for(char letra = 'B'; letra <= 'Z'; letra += 2){
            raiz = inserirNo(raiz, letra);
        }
    }

    public void inserir(Contato contato){
        inserir(raiz,contato);
    }

    public void caminharCentral(){
        caminharCentral(raiz);
    }

    private No inserirNo(No i, char letra){
        if(i == null){
            i = new No(letra);
        }else if(letra > i.letra){
            i.dir = inserirNo(i.dir, letra);
        }else if(letra < i.letra){
            i.esq = inserirNo(i.esq, letra);
        }

        return i;
    }

    private void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.print(i.letra + " ");
            caminharCentral(i.dir);
        }
    }

    private void inserir(No i, Contato contato){
        if(i == null){
            System.out.println("ERRO");
        }else if(contato.nome.charAt(0) > i.letra){
            inserir(i.dir, contato);
        }else if(contato.nome.charAt(0) < i.letra){
            inserir(i.esq, contato);
        }else{
            if(i.primeiro.contato.nome == ""){
                i.primeiro.contato.nome = contato.nome;
                i.primeiro.contato.telefone = contato.telefone;
                i.primeiro.contato.email = contato.email;
                i.primeiro.contato.cpf = contato.cpf;
            }else{
                Celula tmp = new Celula(contato.nome, contato.telefone, contato.email, contato.cpf);
                i.ultimo.prox = tmp;
                i.ultimo = tmp;
                tmp = null;
            }

            //System.out.println(i.ultimo.contato.nome + " " + i.ultimo.contato.telefone + " " + i.ultimo.contato.email + " " + i.ultimo.contato.cpf );
        }
    }

}

public class ArvoreDeLista {
    public static void main(String Args[]){


        Agenda test = new Agenda();
        //test.caminharCentral();
        Contato contato = new Contato("Victor", "1234567", "dhfhsfsd", 1234);
        test.inserir(contato);
        Contato contat = new Contato("Vinicius", "1234567", "dhfhsfsd", 1234);
        test.inserir(contat);
        














        //No test = new No('V', "Victor", "12345", "shdhgsjsd", 123);

        //System.out.println(test.primeiro.contato.nome + " " + test.primeiro.contato.telefone + " "  + test.primeiro.contato.email + " " + test.primeiro.contato.cpf);

    }
}
