#include <stdio.h>
#include <stdlib.h>

typedef struct Celula {
    int elemento;
    struct Celula* prox;
} Celula;

Celula* ConstrutorCelula(int x) {
    Celula* novaCelula = (Celula*) malloc(sizeof(Celula));
    if (novaCelula != NULL) {
        novaCelula->elemento = x;
        novaCelula->prox = NULL;
    }
    return novaCelula;
}

typedef struct Pilha {
    Celula* topo;
} Pilha;

Pilha ConstrutorPilha() {
    Pilha pilha;
    pilha.topo = NULL;
    return pilha;
}

void inserir(Pilha* pilha, int x) {
    Celula* novaCelula = ConstrutorCelula(x);
    if (novaCelula != NULL) {
        novaCelula->prox = pilha->topo;
        pilha->topo = novaCelula;
    }
}

int remover(Pilha* pilha){
    int elemento = -1;
    if(pilha->topo == NULL){
        printf("PILHA VAZIA");
    }else{
        Celula* tmp = pilha->topo;
        pilha->topo = pilha->topo->prox;

        elemento = tmp->elemento;
        tmp->prox = NULL;
    }

    return elemento;
}

void mostra(Pilha pilha) {
    for (Celula* tmp = pilha.topo; tmp != NULL; tmp = tmp->prox) {
        printf("%d ", tmp->elemento);
    }
    printf("\n");
}

int main() {
    Pilha pilha = ConstrutorPilha();
    inserir(&pilha, 1);
    mostra(pilha);
    inserir(&pilha, 2);
    mostra(pilha);
    inserir(&pilha, 3);
    mostra(pilha);
    remover(&pilha);
    mostra(pilha);


    while (pilha.topo != NULL) {
        Celula* tmp = pilha.topo;
        pilha.topo = pilha.topo->prox;
        free(tmp);
    }

    return 0;
}
