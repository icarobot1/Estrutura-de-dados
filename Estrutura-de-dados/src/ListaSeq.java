public class ListaSeq {
    private int[] dados;
    private int tamMax;
    private int tamAtual;

    public ListaSeq() { //construtor
        tamMax = 100;
        tamAtual = 0;
        dados = new int[tamMax];

    }

    public boolean vazia() {
        if (tamAtual == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cheia() {
        if (tamAtual == tamMax) {
            return true;
        } else {
            return false;
        }
    }

    public void exibe() {
        if (tamAtual == 0) {
            System.out.println("A lista está vazia.");
            return;
        }

        System.out.print("Elementos da lista: ");
        for (int i = 0; i < tamAtual; i++) {
            System.out.print(dados[i] + " ");
        }
        System.out.println();
    }

    public int tamanho() {
        return tamAtual;
    }

    public int elemento(int posicao) { //retorna o elemento de uma posicao desejada
        int dado;
        if ((posicao > tamAtual) || (posicao <= 0)) {
            return -1; // se a posicao for invalida retorna -1
        } else {
            dado = dados[posicao - 1];
            return dado; // se a posicao for valida retorna o valor do elemento
        }
    }

    public int posicao(int dado) { //procura se existe um valor no array, se sim retorna a posicao dele
        for (int i = 0; i < tamAtual; i++) {
            if (dados[i] == dado) {
                return (i + 1);
            }
        }
        return -1;
    }

    public boolean insere(int posicao, int dado) { //insere um elemento na lista
        if (cheia() || posicao > tamAtual + 1 || posicao <= 0) { // se a lista estiver cheia ou posicao for maior que o tamAtual+1
            return false;                                   // ou posicao menor/igual zero ela sera invalida
        } else {
            for (int i = tamAtual; i >= posicao; i--) {//desloca os elementos para a direita
                dados[i] = dados[i - 1];
            }
            dados[posicao - 1] = dado;
            tamAtual++;
            return true;
        }
    }

    public int remove(int posicao) {
        if (vazia() || posicao < 1 || posicao > tamAtual) { //checa se a posicao e valida
            return -1;
        }
        int dado;
        dado = dados[posicao - 1];
        for (int i = posicao - 1; i < tamAtual; i++) {
            dados[i] = dados[i + 1];
        }
        tamAtual--;
        return dado;
    }
}
