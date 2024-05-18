#include <stdio.h>
#include <stdlib.h>

typedef struct No{
    int elemento;
    struct No* dir;
    struct No* esq;
}No;

No* construtorNo(int x){
    No* i = (No*) malloc(sizeof(No));
    i->elemento = x;
    i->dir = i->esq = NULL;

    return i;
}

typedef struct Arvore{
    No* raiz;
}Arvore;

Arvore* arvoreConstrutor(){
    Arvore* i = (Arvore*) malloc(sizeof(Arvore));
    i->raiz = NULL;

    return i;
}

No* inserir(No* i, int x){
    if(i == NULL){
        i = construtorNo(x);
    }else if(x > i->elemento){
        i->dir = inserir(i->dir, x);
    }else if(x < i->elemento){
        i->esq = inserir(i->esq, x);
    }else{
        printf("ERRO, VALOR INVALIDO");
    }
    return i;
}

void caminharCentral(No* i){
    if(i != NULL){
        caminharCentral(i->esq);
        printf("%d ", i->elemento);
        caminharCentral(i->dir);
    }
}

int somaNum(No* i){
    if(i == NULL){
        return 0;
    }
    int soma = i->elemento + somaNum(i->esq) + somaNum(i->dir);
    return soma;
}



int main(){

    Arvore* tree = arvoreConstrutor();

    tree->raiz = inserir(tree->raiz, 2);
    caminharCentral(tree->raiz);
    printf("\n");

    tree->raiz = inserir(tree->raiz, 3);
    caminharCentral(tree->raiz);
    printf("\n");

    tree->raiz = inserir(tree->raiz, 1);
    caminharCentral(tree->raiz);
    printf("\n");

    tree->raiz = inserir(tree->raiz, -2);
    caminharCentral(tree->raiz);
    printf("\n");

    tree->raiz = inserir(tree->raiz, 4);
    caminharCentral(tree->raiz);
    printf("\n");

    printf("%d", somaNum(tree->raiz));

}