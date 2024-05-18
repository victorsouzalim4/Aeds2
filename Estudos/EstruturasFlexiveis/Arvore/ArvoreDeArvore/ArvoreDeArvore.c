#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct NoFilho{
    char nome[100];
    struct NoFilho* dir;
    struct NoFilho* esq;

}NoFilho;

NoFilho* construtorNoFilho(char* nome){
    NoFilho* i = (NoFilho*) malloc(sizeof(NoFilho));
    strcpy(i->nome, nome);
    i->dir = i->esq = NULL;

    return i;
}




//---------------------------------------------

typedef struct No{
    char elemento;
    struct No* dir;
    struct No* esq;
    struct NoFilho* no; 
}No;

No* construtorNo(char x){
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

No* inserir(No* i, char x){
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
        printf("%c ", i->elemento);
        caminharCentral(i->dir);
    }
}




int main(){

    Arvore* tree = arvoreConstrutor();

    tree->raiz = inserir(tree->raiz, 'V');

    tree->raiz = inserir(tree->raiz, 'I');

    tree->raiz = inserir(tree->raiz, 'D');

    tree->raiz = inserir(tree->raiz, 'E');

    tree->raiz = inserir(tree->raiz, 'W');
    caminharCentral(tree->raiz);
    printf("\n");

    NoFilho* test = construtorNoFilho("Victor");
    printf("%s", test->nome);

}