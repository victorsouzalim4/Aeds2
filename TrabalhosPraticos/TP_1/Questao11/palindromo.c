#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isPalindrome(char*);
bool endVerifier(char*);

int main(){

    char str[1000];

    scanf(" %[^\n]", str);

    while(endVerifier(str)){
        if(isPalindrome(str)){
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
        scanf(" %[^\n]",str);
    }

    return 0;

}

bool endVerifier(char str[]){

    if(strcmp(str, "FIM") == 0){
        return false;
    }
    return true;
}
bool isPalindrome(char str[]){
    int n = strlen(str);

    for(int i = 0; i < n; i++){
        if(str[i] != str[n - 1 - i]){
            return false;
        }
    }

    return true;

}








