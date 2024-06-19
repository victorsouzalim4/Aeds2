#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

typedef struct{
    char day[100];
    char month[100];
    char year[100];

} DateTime;

typedef struct{
    char apelidos[18][1000];
} ListaDeApelidos;

typedef struct{

    char id[100];
    char name[100];
    ListaDeApelidos alternate_names;
    char house[100];
    char ancestry[100];
    char species[100];
    char patronus[100];
    bool hogwartsStaff;
    bool hogwartsStudent;
    char actorName[100];
    bool alive;
    DateTime dateOfBirth;
    int yearOfBirth;
    char  eyeColour[100];
    char  gender[100];
    char  hairColour[100];
    bool wizard;

}Personagem;






typedef struct Celula{
    Personagem personagem;
    struct Celula* prox;
    struct Celula* ant;

}Celula;

Celula* construtorCelulaPrimeira(){
    Celula* tmp = (Celula*) malloc(sizeof(Celula));
    tmp->prox = NULL;
    tmp->ant = NULL;

    return tmp;
}

Celula* construtorCelula(Personagem personagem){
    Celula* tmp = (Celula*) malloc(sizeof(Celula));
    tmp->personagem = personagem;
    tmp->prox = NULL;
    tmp->ant = NULL;

    return tmp;
}

typedef struct Lista{
    Celula* primeiro;
    Celula* ultimo;
    int tamanho;

}Lista;

Lista* construtorLista(){
    Lista* lista = (Lista*) malloc(sizeof(Lista));

    lista->primeiro = construtorCelulaPrimeira();
    lista->ultimo = lista->primeiro;
    lista->tamanho = 0;

    return lista;
}

void inserirFim(Lista* lista, Personagem personagem){

        Celula* tmp = construtorCelula(personagem);
        lista->ultimo->prox = tmp;
        tmp->ant = lista->ultimo;
        lista->ultimo = tmp;
        tmp = NULL;
        lista->tamanho++;
}

void inserirInicio(Lista* lista, Personagem personagem){
        
        Celula* tmp = construtorCelula(personagem);

        tmp->prox = lista->primeiro->prox;
        lista->primeiro->prox->ant = tmp;

        lista->primeiro->prox = tmp;
        tmp->ant = lista->primeiro;
        tmp = NULL;
        lista->tamanho++;
}

void inserir(Lista* lista, Personagem personagem, int pos){
        if(pos > lista->tamanho || pos < 0){
            printf("Posicao invalida\n");
        }else if(pos == 0) inserirInicio(lista, personagem);
        else if(pos == lista->tamanho) inserirFim(lista, personagem);
        else{
            Celula* i = lista->primeiro;
            for(int j = 0; j < pos; i = i->prox, j++);

            Celula* tmp = construtorCelula(personagem);
            tmp->prox = i->prox;
            i->prox->ant = tmp;

            i->prox = tmp;
            tmp->ant = i;

            tmp = NULL;
            i = NULL;
            free(tmp);
            free(i);

            lista->tamanho++;
        }
}

void imprime(Personagem personagem){
    printf("[%s ## ", personagem.id);
       printf("%s ## ", personagem.name);

        printf("{");
       for(int i = 0; i < 10; i++){
            int cont = 0;
            if(personagem.alternate_names.apelidos[i][0] > 'A' && personagem.alternate_names.apelidos[i][0] < 'z'){
                cont++;
            }
            if(cont != 0){
                if(i != 0){
                    printf(", %s", personagem.alternate_names.apelidos[i]);
                }else{
                    printf("%s", personagem.alternate_names.apelidos[i]);
                }
                 
            }
        }
         printf("} ## ");
    
       printf("%s ## ", personagem.house);
       printf("%s ## ", personagem.ancestry);
       printf("%s ## ", personagem.species);
       printf("%s ## ", personagem.patronus);
        if(personagem.hogwartsStaff == true){
          printf("true ## ");
       }
       else{
          printf("false ## ");
       }
       if(personagem.hogwartsStudent == true){
          printf("true ## ");
       }
       else{
          printf("false ## ");
       }
       printf("%s ## ", personagem.actorName);
       if(personagem.alive == true){
          printf("true ## ");
       }
       else{
          printf("false ## ");
       }
       printf("%s-", personagem.dateOfBirth.day);
       printf("%s-", personagem.dateOfBirth.month);
       printf("%s ## ", personagem.dateOfBirth.year);
       printf("%d ## ", personagem.yearOfBirth);
       printf("%s ## ", personagem.eyeColour);
       printf("%s ## ", personagem.gender);
       printf("%s ## ", personagem.hairColour);

       if(personagem.wizard == true){
          printf("true]\n");
       }
       else{
          printf("false]\n");
       }
       
}

Personagem removerFim(Lista* lista){
    Personagem tmp;
        if(lista->tamanho <= 0){
            printf("Lista vazia");
        }else{
            tmp = lista->ultimo->personagem;
            Celula* i = lista->ultimo;
            lista->ultimo = lista->ultimo->ant;

            lista->ultimo->prox = NULL;
            i->ant = NULL;
            i = NULL;
            free(i);

            lista->tamanho--;
        }
        return tmp;
}

Personagem removerInicio(Lista* lista){
        Personagem personagem;
        if(lista->tamanho <= 0){
                printf("Lista vazia");
        }else{
            personagem = lista->primeiro->prox->personagem;

            Celula* tmp = lista->primeiro;
            lista->primeiro = lista->primeiro->prox;

            lista->primeiro->ant = NULL;
            tmp->prox = NULL;
            tmp = NULL;
            free(tmp);

            lista->tamanho--;
        }
        return personagem;
}

Personagem remover(Lista* lista, int pos) {
    Personagem personagem;
    
    if(pos >= lista->tamanho || pos < 0) {
        if(lista->tamanho == 0) {
            printf("Lista vazia");
        } else {
            printf("Posicao invalida");
        }
    } else if(pos == 0) {
        return removerInicio(lista);
    } else if(pos == lista->tamanho - 1) {
        return removerFim(lista);
    } else {
        Celula* i = lista->primeiro;
        for(int j = 0; j < pos; j++) {
            i = i->prox;
        }

        Celula* tmp = i->prox;
        personagem = tmp->personagem;

        i->prox = tmp->prox;
        tmp->prox->ant = i;

        // Libera apenas tmp, i não deve ser liberado pois ainda é necessário
        free(tmp);

        lista->tamanho--;
    }

    return personagem;
}

void mostra(Lista* lista){

    for(Celula* i = lista->primeiro->prox; i != NULL; i = i->prox){
        imprime(i->personagem);
    }

}





void imprimePersonagem(Personagem personagens[], int indice){
       printf("%s ## ", personagens[indice].id);
       printf("%s ## ", personagens[indice].name);

        printf("{");
       for(int i = 0; i < 10; i++){
            int cont = 0;
            if(personagens[indice].alternate_names.apelidos[i][0] > 'A' && personagens[indice].alternate_names.apelidos[i][0] < 'z'){
                cont++;
            }
            if(cont != 0){
                if(i != 0){
                    printf(", %s", personagens[indice].alternate_names.apelidos[i]);
                }else{
                    printf("%s", personagens[indice].alternate_names.apelidos[i]);
                }
                 
            }
        }
         printf("} ## ");
    
       printf("%s ## ", personagens[indice].house);
       printf("%s ## ", personagens[indice].ancestry);
       printf("%s ## ", personagens[indice].species);
       printf("%s ## ", personagens[indice].patronus);
        if(personagens[indice].hogwartsStaff == true){
          printf("true ## ");
       }
       else{
          printf("false ## ");
       }
       if(personagens[indice].hogwartsStudent == true){
          printf("true ## ");
       }
       else{
          printf("false ## ");
       }
       printf("%s ## ", personagens[indice].actorName);
       if(personagens[indice].alive == true){
          printf("true ## ");
       }
       else{
          printf("false ## ");
       }
       printf("%s-", personagens[indice].dateOfBirth.day);
       printf("%s-", personagens[indice].dateOfBirth.month);
       printf("%s ## ", personagens[indice].dateOfBirth.year);
       printf("%d ## ", personagens[indice].yearOfBirth);
       printf("%s ## ", personagens[indice].eyeColour);
       printf("%s ## ", personagens[indice].gender);
       printf("%s ## ", personagens[indice].hairColour);

       if(personagens[indice].wizard == true){
          printf("true");
       }
       else{
          printf("false");
       }
       
}

void recebeAtributos(char atributos[18][1000], char* linha){
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 1000; j++) {
            atributos[i][j] = '\0';
        }
    }
    int pos = 0;
    for(int i = 0; i < 18; i++){
        for(int j = pos, k = 0; j < 1000; j++, k++){
            if(linha[j] != ';' && linha[j] != '\0' && linha[j] != '\n'){
                atributos[i][k] = linha[j];
            }
            else{
                pos = j+1;
                j = 1000;
            }
            //printf("%c", atributos[i][k]);
        }  
        //printf("\n");  
    }
}

void separaApelidos(char apelidos[10][150], char atributos[18][1000]){
    
    for(int i = 0; i < 10; i++){
        for(int j = 0; j < 150; j++){
            apelidos[i][j] = '\0';
        }
    }
    int  pos = 0;
    for(int i = 0; i < 10; i++){
        int cont = 0;
        for(int j = pos, k = 0; j < 150; j++, k++){
            if(atributos[2][j] == '\''){
                cont++;
                j++;
            }
            if(cont == 1){
                apelidos[i][k] = atributos[2][j];
            }
            else if(cont == 2){
                pos = j+1;
                j = 150; 
            }
               //printf("%c", apelidos[i][k]);  
        }
        //printf("\n");
    }

}

bool StringToBoolean(char atributos[18][1000], int indice){
    char str[1000];
    bool valorLogico = false;

    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }
    for(int i = 0; atributos[indice][i] != '\0'; i++){
        str[i] = atributos[indice][i];
    }

    //printf("%s\n", str);

    if(strcmp(str, "VERDADEIRO") == 0){
        valorLogico = true;
    }

    //printf("%d", valorLogico);

    return valorLogico;
}

void separaData(Personagem personagem[405], char atributos[18][1000], int indice, int num){
    char day[4]; 
    char month[4];
    char year[5]; 

    int pos = 0;
    int i = 0;


    while (atributos[indice][pos] != '-') {
        day[i++] = atributos[indice][pos++];
    }
    day[i] = '\0';
    pos++; 

  
    i = 0;
    while (atributos[indice][pos] != '-') {
        month[i++] = atributos[indice][pos++];
    }
    month[i] = '\0'; 
    pos++; 

  
    i = 0;
    while (atributos[indice][pos] != '\0') {
        year[i++] = atributos[indice][pos++];
    }
    year[i] = '\0';

    strcpy(personagem[num].dateOfBirth.day, day);
    strcpy(personagem[num].dateOfBirth.month, month);
    strcpy(personagem[num].dateOfBirth.year, year);

}

int StringToInt(char atributos[18][1000], int indice){
    char str[5]; 
    for(int i = 0; i < 5; i++){
        str[i] = atributos[indice][i];
    }
    char *endptr; 
    int valor = strtol(str, &endptr, 10); 

    if (*endptr != '\0') {
        //printf("Erro: A string não é um número válido.\n");
    } else {
        //printf("Valor convertido: %d\n", valor);
    }

    return valor;

}

void ConstroiPersonagem(char atributos[18][1000], char apelidos[10][150], Personagem* personagem, int posicao){
    
    char str[1000];
    
    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[0][i] != '\0'; i++){
        str[i] = atributos[0][i];
    }
    strcpy(personagem[posicao].id, str);
 




    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[1][i] != '\0'; i++){
        str[i] = atributos[1][i];
    }
    strcpy(personagem[posicao].name, str);
   




        for(int i = 0; i < 10; i++){
            char str1[150];
            for(int k = 0; k < 150; k++){
                str1[i] = '\0';
            }
            int cont = 0;
            for(int j = 0; j < 150 ; j++){
                if(apelidos[i][j] > 'a' && apelidos[i][j] < 'z'){
                    cont++;
                }
                    //printf("entrei");
                    str1[j] = apelidos[i][j+1];
                    //printf("%c", str1[j]);
                    //printf("%d\n", j);
                    
                 

            }
            strcpy(personagem[posicao].alternate_names.apelidos[i], str1);
            
            
            if(cont != 0){
                //printf("\n%s", str1);
                //printf("\n %d %s,",i, personagem[posicao].alternate_names.apelidos[i]);
            }   
        }

    








    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[3][i] != '\0'; i++){
        str[i] = atributos[3][i];
    }
    strcpy(personagem[posicao].house, str);
    





    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[4][i] != '\0'; i++){
        str[i] = atributos[4][i];
    }
    strcpy(personagem[posicao].ancestry, str);
    






    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[5][i] != '\0'; i++){
        str[i] = atributos[5][i];
    }
    strcpy(personagem[posicao].species, str);
    







    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[6][i] != '\0'; i++){
        str[i] = atributos[6][i];
    }
    strcpy(personagem[posicao].patronus, str);
    






    bool valor = StringToBoolean(atributos, 7);
    if(valor == true){
        personagem[posicao].hogwartsStaff = true;
    }
    else{
        personagem[posicao].hogwartsStaff = false;
    }
    






    valor = StringToBoolean(atributos, 8);
    if(valor == true){
        personagem[posicao].hogwartsStudent = true;
    }
    else{
        personagem[posicao].hogwartsStudent = false;
    }
    





    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[9][i] != '\0'; i++){
        str[i] = atributos[9][i];
    }
    strcpy(personagem[posicao].actorName, str);
    







    valor = StringToBoolean(atributos, 10);
    if(valor == true){
        personagem[posicao].alive = true;
    }
    else{
        personagem[posicao].alive = false;
    }
    







    separaData(personagem,atributos, 12, posicao);







    int ano = StringToInt(atributos, 13);
    personagem[posicao].yearOfBirth = ano;
    






    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[14][i] != '\0'; i++){
        str[i] = atributos[14][i];
    }
    strcpy(personagem[posicao].eyeColour, str);
    







    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[15][i] != '\0'; i++){
        str[i] = atributos[15][i];
    }
    strcpy(personagem[posicao].gender, str);
    





    for(int i = 0; i < 1000; i++){
        str[i] = '\0';
    }

    for(int i = 0; atributos[16][i] != '\0'; i++){
        str[i] = atributos[16][i];
    }
    strcpy(personagem[posicao].hairColour, str);
    


    valor = StringToBoolean(atributos, 17);
    if(valor == true){
        personagem[posicao].wizard = true;
    }
    else{
        personagem[posicao].wizard = false;
    }
    
}   

bool isIgual(char str[], char id[]){
    bool test = true;
    int tam = strlen(id) -1 ;
    for(int i = 0; i < tam; i++){
        if(str[i] != id[i]){
            test = false;
            i = tam;
        }
    }

    return test;
}

Personagem getPersonagem(Personagem personagens[], char* id){
    Personagem personagemAtual;
    for(int i = 0; i < 405; i++){
        if(isIgual(personagens[i].id, id)){
            personagemAtual = personagens[i];
            i = 405;
        }
    }

    return personagemAtual;
}

bool isFim(char str[]){
    bool test = true;

    if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        test = false;
    }

    return test;
}

int getOperacao(char* entrada){
    int resp;

    if(entrada[0] == 'I'){
        resp = 0;
    }else{
        resp = 1;
    }

    return resp;
}
 
char* subString(int posInit, int posFinal, char* entrada) {

    char* novaString = (char*) malloc((posFinal - posInit + 1) * sizeof(char));
    
    for (int i = 0; i < (posFinal - posInit); i++) {
        novaString[i] = entrada[posInit + i];
    }

    novaString[posFinal - posInit] = '\0';
    
    return novaString;
}

int toInt(char* entrada){
    int indicadorFim = 0;
    int i = 0;

    while(entrada[i] != '\0'){
        indicadorFim++;
        i++;
    }

    char novaString[indicadorFim];

    for(int j = 0; j < indicadorFim; j++){
        novaString[j] = entrada[indicadorFim-j-1];
    }

    int soma = 0;

    for(int i = 0; i < indicadorFim; i++){
        int asccivalue = novaString[i];
        asccivalue -= 48;

        soma+= asccivalue*(pow(10, i));
    }

    return soma;

}

int getEndOfNumber(char* entrada){
    int i;

    for(i = 3; i < strlen(entrada) && entrada[i] != ' '; i++);

    return i;
}

int compare(Personagem a, Personagem b){

    int Comparison = strcmp(a.house, b.house);
    if(Comparison != 0) {
        return Comparison;
    }else {
        return strcmp(a.name, b.name);
    }
    return Comparison;
} 

Personagem getOnList(Lista* lista, int pos){
        Celula* i = lista->primeiro;
        for(int j = 0; j <= pos; i = i->prox, j++);
        Personagem tmp = i->personagem;

        return tmp;
}

void swap(Lista* lista, int i, int j){
    Personagem personagemTmp = getOnList(lista, i);

        Celula* tmp = lista->primeiro->prox;
        for(int k = 0; k < i; tmp = tmp->prox, k++);
        tmp->personagem = getOnList(lista, j);

        tmp = lista->primeiro->prox;
        for(int k = 0; k < j; tmp = tmp->prox, k++);
        tmp->personagem = personagemTmp;
}

void ordena(Lista* lista, int esq, int dir){
    int i = esq;
        int j = dir;

        Personagem pivot = getOnList(lista, (esq+dir)/2);

        while(i <= j){

            while(compare(pivot, getOnList(lista, i)) > 0){
                i++;
            }
            while(compare(pivot, getOnList(lista, j)) < 0){
                j--;
            }

            if(i <= j){
                swap(lista, i, j);
                i++;
                j--;
            }
            
        }

        if (esq < j) {
            ordena(lista, esq, j);
        }
        if (dir > i) {
            ordena(lista, i, dir);
        }
}

int main(){

    FILE *arq = fopen("/tmp/characters.csv", "r");
    char linha[1000];
    char atributos[18][1000];
    char apelidos[10][150];
    Personagem* personagens = (Personagem*) malloc (sizeof(Personagem)*404);




    if(arq == NULL){
        printf("Erro na abertura do arquivo");
        return 1;
    }

    fgets(linha, 1000, arq);
    int i = 0;
    while(fgets(linha, 300, arq) != NULL ){
        recebeAtributos(atributos, linha);
        separaApelidos(apelidos, atributos);
        ConstroiPersonagem(atributos, apelidos, personagens, i);
        i++;
    } 

  
    char id[100];
    Lista* lista = construtorLista();


    scanf("%99[^\n]%*c", id);
    id[strcspn(id, "\r")] = '\0';
    

    while(isFim(id)){
        Personagem personagemAtual = getPersonagem(personagens, id);
        if(personagemAtual.yearOfBirth !=  0){
            inserirFim(lista, personagemAtual);
        }
        scanf("%99[^\n]%*c", id);
        id[strcspn(id, "\r")] = '\0';
    }

    ordena(lista, 0, lista->tamanho - 1);
    mostra(lista);

}

//C:/Users/Victor/Documents/FACULDADE/2 semestre/Aeds 2/TP_3/Trabalho_Pratico3/characters.csv