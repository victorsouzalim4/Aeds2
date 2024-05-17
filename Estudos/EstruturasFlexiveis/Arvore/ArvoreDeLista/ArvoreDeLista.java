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

    public void mostraContatos(){
        mostraContatos(raiz);
    }

    public void remover(String nome){
        remover(raiz, nome);
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
                Celula tmp = new Celula(contato.nome, contato.telefone, contato.email, contato.cpf);
                i.ultimo.prox = tmp;
                i.ultimo = tmp;
                tmp = null;

            //System.out.println(i.ultimo.contato.nome + " " + i.ultimo.contato.telefone + " " + i.ultimo.contato.email + " " + i.ultimo.contato.cpf );
        }
    }

    private void mostraContatos(No i){
        if(i != null){
            mostraContatos(i.esq);
            boolean flag = true;
            for(Celula tmp = i.primeiro.prox; tmp != null && flag == true; tmp = tmp.prox){
                if(tmp.contato.nome == ""){
                    flag = false;
                }else{
                    System.out.println(tmp.contato.nome + " " + tmp.contato.telefone + " " + tmp.contato.email + " " + tmp.contato.cpf );
                }
            }
            mostraContatos(i.dir);
        }
    }

    private void remover(No i, String nome){
        if(i == null){
            System.out.println("ERRO, valor indisponivel");
        }else if(nome.charAt(0) > i.letra){
            remover(i.dir, nome);
        }else if(nome.charAt(0) < i.letra){
            remover(i.esq, nome);
        }else{
            tiraDaLista(i, nome);
        }
    }

    private void tiraDaLista(No i, String nome){
        boolean flag = true;
        boolean encontrou = false;

        for(Celula tmp = i.primeiro; tmp != null && flag == true; tmp = tmp.prox){
            if(i.primeiro == i.ultimo){
                flag = false; 

            }else if(tmp.prox == i.ultimo){
                if(i.ultimo.contato.nome.equals(nome)){
                    i.ultimo = tmp;
                    tmp.prox = null;
                    encontrou = true;
                }
                flag = false;  //independente do que acontecer, a flag sera falsa caso entre nesta condicao, pois se o nome for igual, sai do loop, senao, nao ha mais contatos para buscar

            }else if(tmp.prox.contato.nome.equals(nome)){
                    Celula novoTmp = tmp.prox;
                    tmp.prox = novoTmp.prox;
                    novoTmp.prox = novoTmp = null;
                    flag = false;
                    encontrou = true;
            }
            
        }
        if(encontrou == true){
            System.out.println("\nContato removido\n");
        }else{
            System.out.println("\nContato nao encontrado\n");
        }
    }

}

public class ArvoreDeLista {
    public static void main(String Args[]){


        Agenda test = new Agenda();
        //test.caminharCentral();
        Contato contato = new Contato("Victor", "1234567", "dhfhsfsd", 1234);
        test.inserir(contato);

        contato = new Contato("Vinicius", "1234567", "dhfhsfsd", 1234);
        test.inserir(contato);

        contato = new Contato("Ana", "1234567", "dhfhsfsd", 1234);
        test.inserir(contato);

        contato = new Contato("Pedro", "1234567", "dhfhsfsd", 1234);
        test.inserir(contato);

        contato = new Contato("Vanessa", "1234567", "dhfhsfsd", 1234);
        test.inserir(contato);

 
        test.mostraContatos();

        test.remover("Douglas");
        test.mostraContatos();
        














        //No test = new No('V', "Victor", "12345", "shdhgsjsd", 123);

        //System.out.println(test.primeiro.contato.nome + " " + test.primeiro.contato.telefone + " "  + test.primeiro.contato.email + " " + test.primeiro.contato.cpf);

    }
}
