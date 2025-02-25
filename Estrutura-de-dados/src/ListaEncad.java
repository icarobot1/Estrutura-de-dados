public class ListaEncad {
    private No cabeca; // Ponteiro para o primeiro nó da lista
    private int tamanho; // Controla o número de elementos na lista

    public ListaEncad() {
        cabeca = null; // Inicialmente a lista está vazia
        tamanho = 0;
    }

    public class No {
        private int conteudo;
        private No prox;

        public No(int conteudo) {
            this.conteudo = conteudo;
            this.prox = null;
        }

        public int getConteudo() {
            return conteudo;
        }

        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
    }

    // Retorna o tamanho da lista contando os nós existentes
    public int tamanho() {
        No p = cabeca;
        int cont = 0;
        while (p != null) {
            p = p.getProx();
            cont++;
        }
        return cont;
    }

    // Verifica se a lista está vazia
    public boolean vazia() {
        return tamanho == 0;
    }

    // Insere um novo nó no início da lista
    private boolean insereNoInicio(int dado) {
        No novoNo = new No(dado);
        novoNo.setProx(cabeca); // O novo nó aponta para o antigo primeiro nó
        cabeca = novoNo; // O novo nó se torna a cabeça da lista
        tamanho++;
        return true;
    }

    // Insere um nó no meio da lista em uma posição específica
    private boolean insereNoMeio(int dado, int pos) {
        if (pos <= 1 || pos > tamanho) { // Verifica se a posição é válida
            return false;
        }

        No novoNo = new No(dado);
        No aux = cabeca;
        int cont = 1;

        // Percorre a lista até a posição anterior à desejada
        while (cont < pos - 1 && aux != null) {
            aux = aux.getProx();
            cont++;
        }

        if (aux == null) return false;

        // Ajusta os ponteiros para inserir o novo nó na posição correta
        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);
        tamanho++;
        return true;
    }

    // Insere um novo nó no final da lista
    private boolean insereNoFinal(int dado) {
        No novoNo = new No(dado);

        if (cabeca == null) { // Se a lista estiver vazia, insere na cabeça
            cabeca = novoNo;
        } else {
            No aux = cabeca;
            while (aux.getProx() != null) { // Percorre até o último nó
                aux = aux.getProx();
            }
            aux.setProx(novoNo); // O último nó aponta para o novo nó
        }

        tamanho++;
        return true;
    }

    // Insere um elemento na lista, determinando automaticamente a posição
    public boolean insere(int pos, int dado) {
        if (vazia() && pos != 1) {
            return false;
        }
        if (pos == 1) {
            return insereNoInicio(dado);
        } else if (pos == tamanho + 1) {
            return insereNoFinal(dado);
        } else {
            return insereNoMeio(dado, pos);
        }
    }

    // Exibe os elementos da lista
    public void exibe() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.getConteudo() + " -> ");
            atual = atual.getProx();
        }
        System.out.println("null"); // Indica o fim da lista
    }

    // Retorna o elemento armazenado em uma posição específica
    public int elemento(int pos) {
        No aux = cabeca;
        int cont = 1;
        if (vazia()) return -1;

        if ((pos < 1) || pos > tamanho) return -1;

        while (cont < pos) {
            aux = aux.getProx();
            cont++;
        }
        return aux.getConteudo();
    }

    // Modifica o valor de um nó em uma posição específica
    public boolean modifica(int pos, int dado) {
        No aux = cabeca;
        int cont = 1;
        if (vazia()) return false;

        if ((pos < 1) || pos > tamanho) return false;

        while (cont < pos) {
            aux = aux.getProx();
            cont++;
        }
        aux.setConteudo(dado);
        return true;
    }

    // Remove o primeiro elemento da lista
    private int removeInicio() {
        No aux = cabeca;
        int dado = aux.getConteudo();
        cabeca = aux.getProx(); // A cabeça passa a ser o segundo nó
        tamanho--;
        aux = null; // Libera a memória do nó removido
        return dado;
    }

    // Remove um nó de uma posição específica
    private int removeLista(int pos) {
        No atual = null;
        No antecessor = null;
        int dado = -1;
        int cont = 1;

        atual = cabeca;
        while ((cont < pos) && atual != null) { // Percorre a lista até encontrar a posição desejada
            antecessor = atual;
            atual = atual.getProx();
            cont++;
        }
        if (atual == null) return -1; // Se a posição for inválida, retorna -1
        dado = atual.getConteudo();

        // Ajusta os ponteiros para remover o nó da lista
        antecessor.setProx(atual.getProx());
        tamanho--;
        atual = null; // Libera a memória do nó removido
        return dado;
    }

    // Remove um elemento da lista na posição especificada
    public int remove(int pos) {
        if (vazia()) return -1;
        if (pos == 1) {
            return removeInicio();
        } else {
            return removeLista(pos);
        }
    }
}
