package FilaEstatica;

import FilaException.FilaCheiaException;
import FilaException.FilaVaziaException;

public class FilaEstatica {
    private int cabeca;
    private int cauda;
    private Object vetor[];

    public FilaEstatica(int tamanho) {
        vetor = new Object[tamanho];
        cabeca = -1;
        cauda = -1;
    }

    public boolean isEmpty() {
        return cabeca == -1 && cauda == -1;
    }

    public boolean isFull() {
        return ((cauda + 1) % vetor.length) == cabeca;
    }
    
    public void add(Object valor) throws FilaCheiaException {
        if (isFull()) {
            throw new FilaCheiaException();
        }

        cauda = (cauda + 1) % vetor.length;
        vetor[cauda] = valor;

        if (cabeca == -1) {
            cabeca = cauda;
        }
    }

    public Object remove() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException();
        }

        Object valor = vetor[cabeca];
        vetor[cabeca] = null;
        
        if (cabeca == cauda) {
            cabeca = -1;
            cauda = -1;
        } else {
            cabeca = (cabeca + 1) % vetor.length;
        }

        return valor;
    }

    public void limpar() {
        cabeca = -1;
        cauda = -1;
        vetor = new Object[vetor.length];
    }

    public void percorrer() {
        if (!isEmpty()) {
            for (int i = cabeca; i != cauda; i = (i + 1) % vetor.length) {
                System.out.println(vetor[i]);
            }
            System.out.println(vetor[cauda]);
        }
    }

}