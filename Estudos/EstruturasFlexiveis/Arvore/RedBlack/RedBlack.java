package Estudos.EstruturasFlexiveis.Arvore.RedBlack;

class No {
    public int elemento;
    public No dir;
    public No esq;
    public boolean cor;

    No(int x) {
        this.elemento = x;
        this.dir = null;
        this.esq = null;
        this.cor = true;
    }
}

class Arvore {
    private No raiz;

    Arvore(int x) {
        raiz = new No(x);
    }

    void inserir(int x) {
        if (raiz == null) {
            raiz = new No(x);
        } else if (raiz.dir == null && raiz.esq == null) {
            if (x < raiz.elemento) {
                raiz.esq = new No(x);
            } else {
                raiz.dir = new No(x);
            }
        } else if (raiz.esq == null) {
            if (x < raiz.elemento) {
                raiz.esq = new No(x);
            } else if (x < raiz.dir.elemento) {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = x;
            } else {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = x;
            }

            raiz.esq.cor = raiz.dir.cor = false;
        } else if (raiz.dir == null) {
            if (x > raiz.elemento) {
                raiz.dir = new No(x);
            } else if (x > raiz.esq.elemento) {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = x;
            } else {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = x;
            }
        } else {
            inserir(x, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    void caminharCentral() {
        caminharCentral(raiz);
        System.out.println();
    }

    void caminharPosOrdem() {
        caminharPosOrdem(raiz);
        System.out.println();
    }

    void caminharPreOrdem() {
        caminharPreOrdem(raiz);
        System.out.println();
    }

    void remover(int x) {
        raiz = remover(raiz, x);
    }

    int pesquisa(int x) {
        int resp = pesquisa(raiz, x);
        return resp;
    }

    int getAltura() {
        int altura = getAltura(raiz);
        return altura;
    }

    int getSoma() {
        int soma = getSoma(raiz);
        return soma;
    }

    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    private void caminharPosOrdem(No i) {
        if (i != null) {
            caminharPosOrdem(i.esq);
            caminharPosOrdem(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    private void caminharPreOrdem(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            caminharPreOrdem(i.esq);
            caminharPreOrdem(i.dir);
        }
    }

    private void inserir(int x, No bisAvo, No avo, No pai, No i) {
        if (i == null) {
            if (x < pai.elemento) {
                i = pai.esq = new No(x);
            } else {
                i = pai.dir = new No(x);
            }

            if (pai.cor == true) {
                balancear(bisAvo, avo, pai, i);
            }
        } else {
            is4No(bisAvo, avo, pai, i);

            if (x < i.elemento) {
                inserir(x, avo, pai, i, i.esq);
            } else if (x > i.elemento) {
                inserir(x, avo, pai, i, i.dir);
            } else {
                System.out.println("Erro, elemento repetido");
            }
        }
    }

    private No remover(No i, int x) {
        if (i == null) {
            System.out.println("ERRO, elemento nao encontrado");
        } else if (x < i.elemento) {
            i.esq = remover(i.esq, x);
        } else if (x > i.elemento) {
            i.dir = remover(i.dir, x);
        } else if (i.dir == null) {
            i = i.esq;
        } else if (i.esq == null) {
            i = i.dir;
        } else {
            i.esq = getMaiorEsq(i, i.esq);
        }

        return i;
    }

    private int pesquisa(No i, int x) {
        int resp = -1;
        if (i == null) {
            return resp;
        } else if (x > i.elemento) {
            resp = pesquisa(i.dir, x);
        } else if (x < i.elemento) {
            resp = pesquisa(i.esq, x);
        } else {
            resp = 1;
        }

        return resp;
    }

    private int getAltura(No i) {
        if (i == null) {
            return -1;
        }
        int alturaEsq = getAltura(i.esq) + 1;
        int alturaDir = getAltura(i.dir) + 1;

        int altura = (alturaEsq > alturaDir ? alturaEsq : alturaDir);
        return altura;
    }

    private int getSoma(No i) {
        if (i == null) {
            return 0;
        }
        int soma = i.elemento + getSoma(i.esq) + getSoma(i.dir);
        return soma;
    }

    private No getMaiorEsq(No i, No j) {
        if (j.dir == null) {
            i.elemento = j.elemento;
            j = j.esq;
        } else {
            j.dir = getMaiorEsq(i, j.dir);
        }

        return j;
    }

    private void balancear(No bisAvo, No avo, No pai, No i) {
        if (pai.cor == true) {
            if (pai.elemento > avo.elemento) {
                if (i.elemento > pai.elemento) {
                    avo = rotacaoEsq(avo);
                } else {
                    pai = rotacaoDir(pai);
                    avo = rotacaoEsq(avo);
                }
            } else {
                if (i.elemento < pai.elemento) {
                    avo = rotacaoDir(avo);
                } else {
                    pai = rotacaoEsq(pai);
                    avo = rotacaoDir(avo);
                }
            }
        }

        if (bisAvo == null) {
            raiz = avo;
        } else if (avo.elemento < bisAvo.elemento) {
            bisAvo.esq = avo;
        } else {
            bisAvo.dir = avo;
        }

        avo.cor = false;
        avo.esq.cor = avo.dir.cor = true;
    }

    private No rotacaoDir(No i) {
        No tmp = i.esq;
        i.esq = tmp.dir;
        tmp.dir = i;

        return tmp;
    }

    private No rotacaoEsq(No i) {
        No tmp = i.dir;
        i.dir = tmp.esq;
        tmp.esq = i;

        return tmp;
    }

    private void is4No(No bisAvo, No avo, No pai, No i) {
        if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
            i.cor = true;
            i.esq.cor = i.dir.cor = false;

            if (i == raiz) {
                i.cor = false;
            } else if (pai.cor == true) {
                balancear(bisAvo, avo, pai, i);
            }
        }
    }

}

public class RedBlack{
    public static void main(String args[]) {

        Arvore tree = new Arvore(0);
        for (int i = 1; i <= 20; i++) {
            tree.inserir(i);
        }

        //System.out.println("alow");
        System.out.println(tree.getAltura());

    }
}