public class FilaSeq {
    private int[] dados; // Array que armazenará os elementos da fila
    private int tamMax; // Capacidade máxima da fila
    private int inicio; // Índice do primeiro elemento da fila
    private int fim; // Índice do último elemento inserido na fila
    private int tamanho; // Número atual de elementos na fila

    // Construtor da fila circular
    public FilaSeq(int capacidade) {
        tamMax = capacidade;
        dados = new int[tamMax];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    // Verifica se a fila está vazia
    public boolean vazia() {
        return tamanho == 0;
    }

    // Verifica se a fila está cheia
    public boolean cheia() {
        return tamanho == tamMax;
    }

    // Insere um elemento no final da fila
    public boolean inserir(int elemento) {
        if (cheia()) {
            return false; // Não é possível inserir, a fila está cheia
        }
        fim = (fim + 1) % tamMax; // Incremento circular do índice
        dados[fim] = elemento;
        tamanho++;
        return true;
    }

    // Remove e retorna o elemento do início da fila
    public int remover() {
        if (vazia()) {
            return -1; // Indica que a fila está vazia
        }
        int elementoRemovido = dados[inicio];
        inicio = (inicio + 1) % tamMax; // Incremento circular do índice
        tamanho--;
        return elementoRemovido;
    }

    // Consulta o elemento que está no início da fila sem removê-lo
    public int consultarInicio() {
        if (vazia()) {
            return -1; // Indica que a fila está vazia
        }
        return dados[inicio];
    }

    // Exibe os elementos da fila em ordem
    public void exibirFila() {
        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.print("Elementos da fila: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(dados[(inicio + i) % tamMax] + " "); // Impressão considerando a estrutura circular
        }
        System.out.println();
    }
}

