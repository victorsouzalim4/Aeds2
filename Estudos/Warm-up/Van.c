#include <stdio.h>
#include <string.h>
#include <math.h>

typedef struct Aluno{
    char nome[100];
    int distancia;
    char sentido;

}Aluno;

int converteDistancia(char* str){
    int indicadorFim = 0;
    int i = 0;

    while(str[i] != '\0'){
        indicadorFim++;
        i++;
    }

    char novaString[indicadorFim];

    for(int j = 0; j < indicadorFim; j++){
        novaString[j] = str[indicadorFim-j-1];
    }

    int soma = 0;

    for(int i = 0; i < indicadorFim; i++){
        int asccivalue = novaString[i];
        asccivalue -= 48;

        soma+= asccivalue*(pow(10, i));
    }

    return soma;

}

void swap(int i, int j, Aluno* alunos){
    Aluno tmp = alunos[i];

    strcpy(alunos[i].nome, alunos[j].nome);
    alunos[i].sentido = alunos[j].sentido;
    alunos[i].distancia = alunos[j].distancia;

    strcpy(alunos[j].nome, tmp.nome);
    alunos[j].sentido = tmp.sentido;
    alunos[j].distancia = tmp.distancia;

}

void ordena(Aluno* alunos, int n){
    for(int i = 0; i < n - 1; i++){
        int menor = i;
        for(int j = i+1; j < n; j++){
            if(alunos[menor].distancia > alunos[j].distancia){
                menor = j;
            }else if(alunos[menor].distancia == alunos[j].distancia){
                //printf("entrei");
                int test = strcmp(alunos[menor].nome, alunos[j].nome);
                if(test > 0){
                    //printf("entrei2");
                    menor = j;
                }
            }
        }

        swap(i, menor, alunos);
    }

}

int main(){

    int n;
    scanf("%d", &n);
    char lixo;
    scanf("%c", &lixo);

    Aluno alunos[n];

    for(int i = 0; i < n; i++){
        char str[100];

        scanf("%[^\r\n]", str);
        scanf("%c", &lixo);
    
        int j = 0;
        while(str[j] != ' '){
            alunos[i].nome[j] = str[j];
            j++;
        }

        j++;

        while(str[j] != ' '){
            alunos[i].sentido = str[j];
            j++;
        }

        j++;
        int k = 0;
        char strAux[5];
        while(str[j] != '\0'){

            strAux[k] = str[j];

            j++;
            k++;
        }


        alunos[i].distancia = converteDistancia(strAux);

    }

    ordena(alunos, n);

    for(int i = 0; i < n; i++){
        printf("%s\n", alunos[i].nome);
    }



}

