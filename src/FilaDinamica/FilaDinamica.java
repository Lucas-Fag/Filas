package FilaDinamica;

import FilaException.FilaVaziaException;

public class FilaDinamica {
    private ElementoDaFila cabeca;
    private ElementoDaFila cauda;

    class ElementoDaFila {
        private Object valor;
        private ElementoDaFila proximoElemento;

        public ElementoDaFila(Object valor) {
            this.valor = valor;
            proximoElemento = null;
        }

        public Object getValor() {
            return valor;
        }

        public void setValor(Object valor) {
            this.valor = valor;
        }

        public ElementoDaFila getProximoElemento() {
            return proximoElemento;
        }

        public void setProximoElemento(ElementoDaFila proximo) {
            proximoElemento = proximo;
        }

        public boolean hasNext() {
            return proximoElemento != null;
        }
        
    }

    public FilaDinamica() {
        cabeca = null;
        cauda = null;
    }

    public boolean isEmpty() {
        return cabeca == null;
    }

    public void add(Object valor) {
        ElementoDaFila elemento = new ElementoDaFila(valor);
        
        if (isEmpty()) {
            cauda = elemento;
            cabeca = cauda;
        } else {
            cauda.setProximoElemento(elemento);
            cauda = cauda.getProximoElemento();
        }
    }

    public Object remove() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException();
        }

        Object valor = cabeca.getValor();

        if (cabeca.hasNext()) {
            cabeca = cabeca.getProximoElemento();
        } else {
            cabeca = null;
            cauda = null;
        }

        return valor;
    }

    public void percorrer() {
        ElementoDaFila elemento = cabeca;

        do {
            System.out.println(elemento.getValor());
            elemento = elemento.getProximoElemento();
        } while (elemento.hasNext());
    }

    public void limpar() {
        cabeca = null;
        cauda = null;
    }
    
}
