package Deque;

import DequeException.DequeVazioException;

public class App {

    public static void main(String[] args) throws DequeVazioException {
        Deque deque = new Deque();
    
        for (int i = 0; i < 5; i++) {
            deque.addFinal(i);
        }
    
        deque.percorrer();

        System.out.println("----------------");

        deque.removeFinal();
        deque.removeInicio();

        deque.percorrer();

        System.out.println("----------------");

        deque.addInicio("inicio");
        deque.addFinal("final");

        deque.percorrer();
    }
}
