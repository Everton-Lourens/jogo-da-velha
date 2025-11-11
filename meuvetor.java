//package vetores;

import java.util.Scanner;

public class meuvetor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int matA[][] = new int[3][3];

        int matA[][] = {
                { 1, 0, 1 },
                { 0, 0, 0 },
                { 0, 1, 0 }
        };

        int matT[][] = new int[3][3];
        int i, j, pontuacao = 0;
        int inputNumber;

        for (i = 0; i < matA.length; i++) {
            for (j = 0; j < matA[0].length; j++) {

                System.out.println("\n\nJOGUE: ");

                for (i = 0; i < matA.length; i++) {
                    for (j = 0; j < matA[0].length; j++) {

                        if (sc.nextInt() == 0) {
                            matT[i][j] = 0;
                        } else {
                            matT[i][j] = 1;
                        }
                    }
                }

                System.out.println("===================");
                System.out.println("SUA APOSTA:");

                for (i = 0; i < matT.length; i++) {
                    for (j = 0; j < matT[0].length; j++) {
                        System.out.print(matT[i][j] + "  ");
                    }
                    System.out.println(" ");
                }

                if (matA.length == matT.length || matA[0].length == matT[0].length) {
                    System.out.println("===================");
                    System.out.println("Resultado:");
                    for (i = 0; i < matA.length; i++) {
                        for (j = 0; j < matA[0].length; j++) {
                            System.out.print(matA[i][j] + "  ");
                        }
                        System.out.println(" ");
                    }
                    System.out.println("===================");
                    System.out.println("===================");

                    for (i = 0; i < matA.length; i++) {
                        for (j = 0; j < matA[0].length; j++) {
                            if (matA[i][j] == matT[i][j]) {
                                pontuacao++;
                                System.out.println("Acertou na linha: " + i + " Coluna " + j + "\n" + "sua pontuação: "
                                        + pontuacao);
                            }
                        }
                        System.out.println(" ");
                    }
                    System.out.println("===================");
                }
            }
        }
        sc.close();
    }
}