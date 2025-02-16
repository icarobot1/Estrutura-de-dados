#include<stdio.h>
#define MAX 100 // O tamanho maximo da lista

typedef struct {
    int dados[MAX];
    int n; //posicao apos o ultimo elemento
}Lista;

//Operacoes

//Cria a lista
void cria_lista(Lista *l) {
    l-> n = 0;
}
//Verifica se esta vazia
int vazia (Lista l) {
    if (l.n == 0) {
        printf("Lista Vazia\n");
        return 1;
    } else {
        printf("Lista contem elementos\n");
        return 0;
    }

}
//Verifica se esta cheia
int cheia (Lista l) {
    if (l.n == MAX) {
        printf("Lista cheia\n");
        return 1;
    } else {
        printf("Lista contem espaco\n");
        return 0;
    }
}
//Verifica o tamanho da lista
int tamanho_lista( Lista l) {
    return(l.n);
}
//Procura o elemento caso ache retorna 1
//caso não retorna 0
int busca_elemento(Lista l, int posicao ,int *dado) {
    if ((posicao > l.n) || ( posicao <= 0)) {
        return(0);
    }
    *dado = l.dados[posicao-1];
    return(1);
}
//Modifica o elemento
void modificaElemento(Lista *l, int posicao , int valor) {
    if (posicao < 1 || posicao > l->n) {
        return;
    }
    l->dados[posicao-1] = valor;
}
//Insere um elemento, caso a posicao for invalida ou
// a lista estiver cheia retorna 0, caso nao retorna 1
int insere_lista(Lista *l, int posicao,int dado) {
    if ((l->n == MAX) || (posicao > l->n+1)) {
        return(0);
    }
    for (int i = l->n;i >= posicao;i--) {
        l->dados[i] = l->dados[i-1];
    }
    l->dados[posicao-1] = dado;
    l->n++;
    return(1);
}
//Remove um elemento,caso a posicao for invalida ou
// a lista estiver vazia retorna 0,caso nao retorna 1
int remove_lista(Lista *l, int posicao,int *dado) {
    if ((posicao> l->n) ||(posicao <=0)) {
        return (0);
    }
    *dado = l->dados[posicao-1];
    for ( int i = posicao-1;i< (l->n) - 1; i++) {
        l->dados[i] = l->dados[i+1];
    }
    l->n--;
    return(1);
}
//Exibe a lista
void exibir_lista(Lista l) {
    printf("Lista: ");
    for (int i = 0; i < l.n; i++) {
        printf("%d ", l.dados[i]);
    }
    printf("\n");
}

int main(void) {
    Lista lista;
    cria_lista(&lista);

    //testes
    cheia(lista);
    vazia(lista);

    insere_lista(&lista,1,5);
    insere_lista(&lista,2,6);
    insere_lista(&lista,3,8);
    insere_lista(&lista,4,10);
    exibir_lista(lista);

    modificaElemento(&lista, 3, 99);
    exibir_lista(lista);

    int removido;
    remove_lista(&lista,2,&removido);
    exibir_lista(lista);

    int encontrado;
    busca_elemento(lista, 3, &encontrado);
    exibir_lista(lista);

    tamanho_lista(lista);




    return 0;
}