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
    i->no = NULL;

    return i;
}

//-----------------------------------------------------------

typedef struct Arvore{
    No* raiz;
}Arvore;

Arvore* arvoreConstrutor(){
    Arvore* i = (Arvore*) malloc(sizeof(Arvore));
    i->raiz = NULL;

    return i;
}

//-----------------------------------------------------------


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

NoFilho** getPointerPrimeiraLetraDoNome(No* i, char letra){
    NoFilho** flag;
    if(i == NULL){
        printf("Letra nao encontrada");
        flag = NULL;
    }else if(letra > i->elemento){
        flag = getPointerPrimeiraLetraDoNome(i->dir, letra);
    }else if(letra < i->elemento){
        flag = getPointerPrimeiraLetraDoNome(i->esq, letra);
    }else{
        flag = &(i->no);
    }

    return flag;
}

NoFilho* inserirNome(NoFilho* i, char* nome){
    if(i == NULL){
        i = construtorNoFilho(nome);
    }else if(strcmp(nome, i->nome) > 0){
        i->dir = inserirNome(i->dir, nome);
    }else if(strcmp(nome, i->nome) < 0){
        i->esq = inserirNome(i->esq, nome);
    }else{
        printf("ERRO, NOME INVALIDO\n");
    }

    return i;
}

void insereNome(No* i, char* nome){

    NoFilho** j = getPointerPrimeiraLetraDoNome(i, nome[0]);
    if(j != NULL){
        *j = inserirNome(*j, nome);
    }

}

void listaNomesDoNo(NoFilho* i){
    if(i != NULL){
        listaNomesDoNo(i->esq);
        printf("%s\n", i->nome);
        listaNomesDoNo(i->dir);
    }
}

void mostrarNomes(No* i){
    if(i != NULL){
        mostrarNomes(i->esq);
        listaNomesDoNo(i->no);
        mostrarNomes(i->dir);
    }
}






int main(){

    Arvore* tree = arvoreConstrutor();

    tree->raiz = inserir(tree->raiz, 'V');
    tree->raiz = inserir(tree->raiz, 'F');
    tree->raiz = inserir(tree->raiz, 'A');
    tree->raiz = inserir(tree->raiz, 'I');
    tree->raiz = inserir(tree->raiz, 'W');
    tree->raiz = inserir(tree->raiz, 'E');


    caminharCentral(tree->raiz);
    printf("\n");

// Para 'V'
insereNome(tree->raiz, "Victor");
insereNome(tree->raiz, "Vanessa");
insereNome(tree->raiz, "Vanusa");
insereNome(tree->raiz, "Vinicius");

// Para 'F'
insereNome(tree->raiz, "Fernando");
insereNome(tree->raiz, "Fabiana");
insereNome(tree->raiz, "Felipe");
insereNome(tree->raiz, "Francisco");

// Para 'A'
insereNome(tree->raiz, "Ana");
insereNome(tree->raiz, "Alice");
insereNome(tree->raiz, "Andre");
insereNome(tree->raiz, "Antonio");

// Para 'I'
insereNome(tree->raiz, "Igor");
insereNome(tree->raiz, "Isabela");
insereNome(tree->raiz, "Ivan");
insereNome(tree->raiz, "Ines");

// Para 'W'
insereNome(tree->raiz, "Wagner");
insereNome(tree->raiz, "Wesley");
insereNome(tree->raiz, "William");
insereNome(tree->raiz, "Wanda");

// Para 'E'
insereNome(tree->raiz, "Eduardo");
insereNome(tree->raiz, "Elaine");
insereNome(tree->raiz, "Eliana");
insereNome(tree->raiz, "Emanuel");


   // printf("%s", tree->raiz->no->esq->dir->nome);

   mostrarNomes(tree->raiz);

}