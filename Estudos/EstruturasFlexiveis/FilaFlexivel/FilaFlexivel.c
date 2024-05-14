#include <stdio.h>

typedef struct Celula{
    int elemento;
    struct Celula* prox;

}Celula;

Celula* ConstrutorCelula(int x){
    Celula* novaCelula = (Celula*) malloc(sizeof(Celula));

    novaCelula->elemento = x;
    novaCelula->prox = NULL;

    return novaCelula;
}

typedef struct Fila{
    Celula* primeiro;
    Celula* ultimo;
}Fila;

Fila* ConstrutorFila(){
    Fila* fila = (Fila*) malloc(sizeof(Fila));
    fila->primeiro = ConstrutorCelula(0);
    fila->ultimo = fila->primeiro;

    return fila;
}

void mostra(Fila* fila){
    for(Celula* i = fila->primeiro->prox; i != NULL; i = i->prox){
        printf("%d", i->elemento);
    }
    printf("\n");
}

int main(){

    Fila* fila = ConstrutorFila();
    mostra(fila);

    //printf("%d", fila->primeiro->elemento);

    return 0;
}