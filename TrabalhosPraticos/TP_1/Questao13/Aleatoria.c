#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdbool.h>

bool endVerifier(char frase[]){
    bool test = true;

    if(frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M' ){
        test = false;
    }
    return test;
}


char* altera(char frase[], int pos, int tam, char char1, char char2){

    //printf("%c\n", char1);
    if(tam > pos){
        altera(frase, pos+1, tam, char1, char2);
        if(frase[pos] == char1){
            //printf("entrei\n");
            frase[pos] = char2;
        }
    }
    else{
        return frase;
    }

    return frase;
}


int main(){

    int seed = 4;
    char frase[1000];
    char* novaFrase;
    
    srand(seed);
    char char1 = 'a' + rand() % 26;
    char char2 = 'a' + rand() % 26;

    //printf("%c, %c", char1, char2);

    scanf(" %[^\n]", frase);


    while(endVerifier(frase)){
        int tam = strlen(frase);
    
        novaFrase = altera(frase, 0, strlen(frase), char1, char2);
        for(int i = 0; i < tam; i++){
            printf("%c", novaFrase[i]);
        }
        printf("\n");

        char1 = 'a' + rand() % 26;
        char2 = 'a' + rand() % 26;
        //printf("\n%c, %c ", char1, char2);
        scanf(" %[^\n]", frase);
    }



    return 0;
}