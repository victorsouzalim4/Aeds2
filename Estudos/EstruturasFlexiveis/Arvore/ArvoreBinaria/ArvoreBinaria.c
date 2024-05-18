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
}



int main(){

    Arvore* tree = arvoreConstrutor();

    tree->raiz = inserir(tree->raiz, 2);

    printf("%d", tree->raiz->elemento);
}