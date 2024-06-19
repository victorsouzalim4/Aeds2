#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

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




typedef struct Lista{
    int tamanho;
    Personagem lista[405];
}Lista;

Lista* construtorLista(){
    Lista* list = (Lista*) malloc(sizeof(Lista));
    list->tamanho = 0;

    return list;
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

void mostraLista(Lista *list){
    for(int i = 0; i < list->tamanho; i++){
        printf("[%d ## ", i);
        imprimePersonagem(list->lista, i);
        printf("]\n");
    }
}

void inserirInicio(Lista *list, Personagem personagem){
    if(list->tamanho >= 404){
        printf("ERRO, lista cheia!!");
    }else{
        for(int i = list->tamanho; i > 0; i--){
            list->lista[i] = list->lista[i-1];
        }
        list->lista[0] = personagem;
        list->tamanho++;
    }
}

void inserirFim(Lista *list, Personagem personagem){
    if(list->tamanho >= 404){
        printf("ERRO, lista cheia!!");
    }else{
        list->lista[list->tamanho] = personagem;
        list->tamanho++;
    }
}

void inserir(Lista *list, Personagem personagem, int pos){
    if(list->tamanho >= 404 || pos > list->tamanho || pos < 0){
        if(pos > list->tamanho || pos < 0){
            printf("Posicao invalida!!\n");
        }else{
            printf("ERRO, lista cheia!!\n");
        }
    }else{
        for(int i = list->tamanho; i > pos; i--){
            list->lista[i] = list->lista[i-1];
        }
        list->lista[pos] = personagem;
        list->tamanho++;
    }
}

Personagem removerInicio(Lista *list){
    Personagem tmp;
    if(list->tamanho <= 0){
        printf("ERRO, lista vazia!!\n");
    }else{
        tmp = list->lista[0];
        for(int i = 0; i < list->tamanho; i++){
            list->lista[i] = list->lista[i+1];
        }
        list->tamanho--;
    }

    return tmp;
}

Personagem removerFim(Lista *list){
    Personagem tmp;
    if(list->tamanho <= 0){
        printf("ERRO, lista vazia!!\n");
    }else{
        tmp = list->lista[list->tamanho -1];
        list->tamanho--;
    }

    return tmp;
}

Personagem remover(Lista *list, int pos){
    Personagem tmp;
    if(list->tamanho <= 0 || pos >= list->tamanho || pos < 0){
        if(pos >= list->tamanho || pos < 0){
            printf("Posicao invalida!!\n");
        }else{
            printf("ERRO, lista cheia!!\n");
        }
    }else{
        tmp = list->lista[pos];
        for(int i = pos; i < list->tamanho; i++){
            list->lista[i] = list->lista[i+1];
        }
        list->tamanho--;
    }
    return tmp;
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
        if(entrada[1] == 'I'){
            resp = 0;
        }else if(entrada[1] == 'F'){
            resp = 1;
        }else{
            resp = 2;
        }
    }else{
        if(entrada[1] == 'I'){
            resp = 3;
        }else if(entrada[1] == 'F'){
            resp = 4;
        }else{
            resp = 5;
        }
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
    Lista* list = construtorLista();


    scanf("%99[^\n]%*c", id);
    id[strcspn(id, "\r")] = '\0';
    

    while(isFim(id)){
        Personagem personagemAtual = getPersonagem(personagens, id);
        if(personagemAtual.yearOfBirth !=  0){
            inserirFim(list, personagemAtual);
        }
        scanf("%99[^\n]%*c", id);
        id[strcspn(id, "\r")] = '\0';
    }

    int numEntradas;
    scanf("%d", &numEntradas);

    for(int i = 0; i < numEntradas; i++){
        char entrada[100];

        scanf(" %99[^\n]%*c", entrada);
        entrada[strcspn(entrada, "\r")] = '\0';

        switch(getOperacao(entrada)){
            case 0:
                inserirInicio(list, getPersonagem(personagens, subString(3, strlen(entrada), entrada)));
                break;
            case 1:
                inserirFim(list, getPersonagem(personagens, subString(3, strlen(entrada), entrada)));
                break;
            case 2:
                inserir(list, getPersonagem(personagens, subString(getEndOfNumber(entrada) + 1, strlen(entrada), entrada)), toInt(subString(3, getEndOfNumber(entrada), entrada)));                
                break;                
            case 3:
                printf("(R) %s\n", removerInicio(list).name);               
                break;
            case 4:
                printf("(R) %s\n", removerFim(list).name);                
                break;
            case 5:
                printf("(R) %s\n", remover(list, toInt(subString(3, strlen(entrada), entrada))).name);               
                break;
            default:
                printf("entrada invalida");
        }
    }

    mostraLista(list);



}

//entrada[strcspn(entrada, "\r")] = '\0';