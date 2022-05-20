package FilaEstatica;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FilaEstatica filaIndiana = new FilaEstatica(10);
        Scanner scn = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Informe algo para colocar na fila indiana (" + i +" / 10)");
            filaIndiana.add(scn.nextLine());
        }

        filaIndiana.percorrer();

        scn.close();
    }
}
