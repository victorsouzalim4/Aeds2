#include <stdio.h>

int main()
{

    FILE *arq = fopen("Arquivo.txt", "w");

    int n;
    float num;
    scanf("%d", &n);

    while (n > 0)
    {
        scanf("%f", &num);
        fprintf(arq, "%f\n", num);
        n--;
    }
    fclose(arq);

    arq = fopen("Arquivo.txt", "r");

    if (arq == NULL)
    {
        printf("Achei nao");
    }

    fseek(arq, 0, SEEK_END);
    int pos = ftell(arq) - 2;

    while (pos != 0)
    {
        fseek(arq, --pos, SEEK_SET);
        if (fgetc(arq) == '\n')
        {
            fscanf(arq, "%f", &num);
            printf("%g\n", num);
            pos--;
        }
    }
    fseek(arq, 0, SEEK_SET);
    fscanf(arq, "%f", &num);
    printf("%g\n", num);

    return 0;
}