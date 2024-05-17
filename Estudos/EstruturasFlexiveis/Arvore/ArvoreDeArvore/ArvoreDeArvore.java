package Estudos.EstruturasFlexiveis.Arvore.ArvoreDeArvore;

class NoFilho {
    public String nome;
    public NoFilho esq, dir;

    public NoFilho() {
        this.nome = "";
        esq = dir = null;
    }

    public NoFilho(String nome) {
        this.nome = nome;
        esq = dir = null;
    }
}

class ArvoreFilho {
    private NoFilho raiz;

    public ArvoreFilho() {
        this.raiz = new NoFilho();
    }

    public void inserirFilho(String nome) {
        if (raiz.nome == "") {
            raiz.nome = nome;
        } else {
            inserirFilho(raiz, nome);
        }

    }

    public void caminharCentral() {
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

    private NoFilho inserirFilho(NoFilho i, String nome) {

        if (i == null) {
            i = new NoFilho(nome);
        } else if (nome.compareTo(i.nome) > 0) {
            i.dir = inserirFilho(i.dir, nome);
        } else if (nome.compareTo(i.nome) < 0) {
            i.esq = inserirFilho(i.esq, nome);
        } else {
            System.out.println("NOME INVALIDO");
            return i;
        }
        return i;
    }

    public boolean pesquisar(String nome) {
        boolean flag = pesquisar(raiz, nome);
        return flag;
    }

    private boolean pesquisar(NoFilho i, String nome) {
        boolean flag = false;
        if (i == null) {
            return flag;
        } else if (nome.compareTo(i.nome) > 0) {
            flag = pesquisar(i.dir, nome);
        } else if (nome.compareTo(i.nome) < 0) {
            flag = pesquisar(i.esq, nome);
        } else {
            flag = true;
        }
        return flag;
    }

    private void caminharCentral(NoFilho i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.nome + " ");
            caminharCentral(i.dir);
        }
    }

}

// ------------------------------------------------------------------------------------//

class No {
    public char primeiraLetra;
    public No dir, esq;
    public ArvoreFilho subArvore;

    public No() {
        this.primeiraLetra = ' ';
        this.dir = this.esq = null;
        subArvore = new ArvoreFilho();
    }

    public No(char letra) {
        this.primeiraLetra = letra;
        dir = esq = null;
        subArvore = new ArvoreFilho();
    }
}

class Arvore {
    private No raiz;

    public Arvore() {
        raiz = new No();
    }

    public void inserir(char letra) {
        if (raiz.primeiraLetra == ' ') {
            raiz.primeiraLetra = letra;
        } else {
            raiz = inserir(raiz, letra);
        }
    }

    public void caminharCentral() {
        caminharCentral(raiz);
        System.out.println();
    }

    public void mostrar() {
        mostrar(raiz);
        System.out.println();
    }

    public void pesquisar(String nome) {
        boolean flag = pesquisar(raiz, nome);
        if(flag == true){
            System.out.println("Nome encontrado");
        }else{
            System.out.println("Nome nao encontrado");
        }
    }

    private No inserir(No i, char letra) {
        if (i == null) {
            i = new No(letra);
        } else if (letra > i.primeiraLetra) {
            i.dir = inserir(i.dir, letra);
        } else if (letra < i.primeiraLetra) {
            i.esq = inserir(i.esq, letra);
        } else {
            System.out.println("ERRO");
        }
        return i;
    }

    public void inserirNome(String nome) {
        boolean flag = encontraLugarDoNome(raiz, nome);
        if (flag == true) {
            System.out.println("Cadastro realizado");
        } else {
            System.out.println("ERRO NO CADASTRO");
        }
    }

    public void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.primeiraLetra + " ");
            caminharCentral(i.dir);
        }
    }

    private boolean encontraLugarDoNome(No i, String nome) {
        boolean flag = false;

        if (i == null) {
            return flag;
        } else if (nome.charAt(0) > i.primeiraLetra) {
            flag = encontraLugarDoNome(i.dir, nome);
        } else if (nome.charAt(0) < i.primeiraLetra) {
            flag = encontraLugarDoNome(i.esq, nome);
        } else {
            flag = true;
            i.subArvore.inserirFilho(nome);
        }
        return flag;
    }

    private void mostrar(No i) {
        if (i != null) {
            mostrar(i.esq);
            i.subArvore.caminharCentral();
            mostrar(i.dir);
        }

    }

    private boolean pesquisar(No i, String nome) {
        boolean flag = false;
        if (i == null) {
            return flag;
        } else if (nome.charAt(0) > i.primeiraLetra) {
            flag = pesquisar(i.dir, nome);
        } else if (nome.charAt(0) < i.primeiraLetra) {
            flag = pesquisar(i.esq, nome);
        }else{
              flag = i.subArvore.pesquisar(nome);
        }
            return flag;
        }

    }

    // ------------------------------------------------------------------------------------//

public class ArvoreDeArvore {
    public static void main(String args[]) {

        Arvore tree = new Arvore();
        tree.inserir('D');
        tree.inserir('V');
        tree.inserir('F');
        tree.caminharCentral();
        tree.inserirNome("Victor");
        tree.inserirNome("Douglas");
        tree.inserirNome("Felipe");
        tree.inserirNome("Vinicius");
        tree.inserirNome("Diego");
        tree.inserirNome("Fernando");

        //tree.mostrar();

        tree.pesquisar("Pedro");

    }
}

// ------------------------------------------------------------------------------------//
