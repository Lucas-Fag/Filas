package FilaDinamica;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FilaDinamica fila = new FilaDinamica();
        Scanner scn = new Scanner(System.in);
        String resp;

        do {
            System.out.print("Informe algo para inserir na pilha: ");
            fila.add(scn.nextLine());

            System.out.print("Inserir outro elemento? (S/N) ");
            resp = scn.nextLine();
        } while (resp.equalsIgnoreCase("S"));

        fila.percorrer();

        scn.close();
    }
}
