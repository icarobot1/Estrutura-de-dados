public class Principal {
    public static void main(String[] args) {

        /*
        ListaEncad lista = new ListaEncad();
        System.out.println(lista.vazia());
        lista.insere(1,1);
        lista.exibe();
        lista.insere(1,2);
        lista.exibe();
        lista.insere(1,10);
        lista.exibe();
        lista.insere(2,12);
        lista.exibe();
        System.out.println(lista.tamanho());
        System.out.println(lista.vazia());
        System.out.println(lista.elemento(4));
        lista.modifica(4,5);
        lista.exibe();
        lista.remove(4);
        lista.exibe();
        lista.remove(2);
        lista.exibe();
*/
// Criando uma fila circular com capacidade para 5 elementos
        FilaSeq fila = new FilaSeq(5);

        // Inserindo elementos na fila
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        fila.inserir(50);

        fila.exibirFila(); // Exibindo os elementos da fila

        // Removendo um elemento do início da fila
        System.out.println("Removido: " + fila.remover());

        // Consultando o primeiro elemento da fila
        System.out.println("Início da fila: " + fila.consultarInicio());
        fila.exibirFila();

        // Inserindo mais um elemento para testar o comportamento circular
        fila.inserir(60);
        fila.exibirFila();

    }
}
