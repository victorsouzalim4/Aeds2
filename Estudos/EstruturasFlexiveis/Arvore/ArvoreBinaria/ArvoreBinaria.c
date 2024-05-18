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



int main(){
    No* no = construtorNo(1);
    printf("%d", no->elemento);

    
}