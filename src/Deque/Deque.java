package Deque;

import DequeException.DequeVazioException;

public class Deque {
    private ElementoDoDeque cabeca;
    private ElementoDoDeque cauda;

    class ElementoDoDeque {
        private Object valor;
        private ElementoDoDeque proximoElemento;
        private ElementoDoDeque elementoAnterior;

        public ElementoDoDeque(Object valor) {
            this.valor = valor;
            proximoElemento = null;
            elementoAnterior = null;
        }

        public ElementoDoDeque getElementoAnterior() {
            return elementoAnterior;
        }

        public void setElementoAnterior(ElementoDoDeque elementoAnterior) {
            this.elementoAnterior = elementoAnterior;
        }

        public Object getValor() {
            return valor;
        }

        public void setValor(Object valor) {
            this.valor = valor;
        }

        public ElementoDoDeque getProximoElemento() {
            return proximoElemento;
        }

        public void setProximoElemento(ElementoDoDeque proximoElemento) {
            this.proximoElemento = proximoElemento;
        }

    }

    public Deque() {
        cabeca = null;
        cauda = null;
    }

    public boolean isEmpty() {
        return cabeca == null;
    }

    public void addFinal(Object valor) {
        ElementoDoDeque elemento = new ElementoDoDeque(valor);
        
        if (isEmpty()) {
            cauda = elemento;
            cabeca = cauda;
        } else {
            cauda.setProximoElemento(elemento);
            elemento.setElementoAnterior(cauda);
            cauda = elemento;
        }
    }

    
    public void addInicio(Object valor) {
        ElementoDoDeque elemento = new ElementoDoDeque(valor);
        
        if (isEmpty()) {
            cabeca = elemento;
            cauda = cabeca;
        } else {
            elemento.setProximoElemento(cabeca);
            cabeca = elemento;
        }
    }

    public Object removeInicio() throws DequeVazioException {
        if (isEmpty()) {
            throw new DequeVazioException();
        }

        Object valor = cabeca.getValor();
        cabeca = cabeca.getProximoElemento();
        cabeca.setElementoAnterior(null);

        if (cabeca == null) {
            cauda = null;
        }

        return valor;
    }

    public Object removeFinal() throws DequeVazioException {
        if (isEmpty()) {
            throw new DequeVazioException();
        }

        Object valor = cauda.getValor();
        cauda = cauda.getElementoAnterior();
        cauda.setProximoElemento(null);

        if (cauda == null) {
            cabeca = null;
        }

        return valor;
    }

    public void percorrer() {
        ElementoDoDeque elemento = cabeca;

        while(elemento != null) {
            System.out.println(elemento.getValor());
            elemento = elemento.getProximoElemento();
        }
    }

    public void limpar() {
        cabeca = null;
        cauda = null;
    }
    
}
