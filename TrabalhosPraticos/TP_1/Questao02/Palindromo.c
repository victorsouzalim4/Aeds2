#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool endVerifier(char frase[]){
    bool test = true;
    if(frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M' ){
        test = false;
    }

    return test;
}

bool IsPalindrome(int i, int n, char frase[]){
    bool test = true;

    if(i < n){
        if(frase[i] != frase[n]){
            test = false;
        }
        else{
            test = IsPalindrome(i+1, n-1, frase);
        }
    }

    return test;
}


int main(){
    char frase[1000];
    bool valor;

    scanf(" %[^\n]", frase);

    while(endVerifier(frase)){
       valor = IsPalindrome(0, strlen(frase) -1, frase);
       if(valor == true){
            printf("SIM\n");
       }
       else{
        printf("NAO\n");
       }

       scanf(" %[^\n]", frase);
        
    }


    return 0;
}