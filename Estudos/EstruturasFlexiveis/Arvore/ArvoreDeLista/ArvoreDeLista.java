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
    Contato contato;
    Celula prox;

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

    No(){
        this.letra = ' ';
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

public class ArvoreDeLista {
    public static void main(String Args[]){

    }
}
