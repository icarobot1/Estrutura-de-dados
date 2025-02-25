public class Principal {
    public static void main(String[] args) {
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

    }
}
