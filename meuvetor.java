//package vetores;

import java.util.Scanner;

public class meuvetor {

    public static void main(String[] args) {
        // Inicializando scanner
        Scanner sc = new Scanner(System.in);
        // Inicializando matriz padrão do jogo para o jogador escolher os números
        int matPadrao[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int matT[][] = new int[3][3];
        int i, j, pontuacao = 0;
        // Controle de rodada
        int contarRodada = 1;

        System.out.println("======== Jogo da Velha ========");
        System.out.println("........... REGRAS ...........");
        System.out.println("- Cada jogador terá sua vez de jogar.");
        System.out.println("========================");

        for (i = 0; i < matPadrao.length; i++) {
            for (j = 0; j < matPadrao[0].length; j++) {

                for (i = 0; i < matPadrao.length; i++) {
                    for (j = 0; j < matPadrao[0].length; j++) {

                        if (contarRodada == 1) {
                            System.out.println("\nÉ a vez do jogador 1: ");
                            System.out.println("\nEscolha um número!");
                            if (sc.nextInt() == 0) {
                                matT[i][j] = 0;
                            } else {
                                matT[i][j] = 1;
                            }
                            /////////////
                            for (i = 0; i < matPadrao.length; i++) {
                                for (j = 0; j < matPadrao[0].length; j++) {
                                    System.out.print(matPadrao[i][j] + "  ");
                                }
                                System.out.println(" ");
                            }
                            /////////////
                            // Passa a vez para o jogador 2
                            contarRodada = 2;
                        } else {
                            System.out.println("\nÉ a vez do jogador 2: ");
                            System.out.println("\nEscolha um número!");
                            if (sc.nextInt() == 0) {
                                matT[i][j] = 0;
                            } else {
                                matT[i][j] = 1;
                            }
                            // Passa a vez para o jogador 1
                            contarRodada = 1;
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

                if (matPadrao.length == matT.length || matPadrao[0].length == matT[0].length) {
                    System.out.println("===================");
                    System.out.println("Resultado:");
                    for (i = 0; i < matPadrao.length; i++) {
                        for (j = 0; j < matPadrao[0].length; j++) {
                            System.out.print(matPadrao[i][j] + "  ");
                        }
                        System.out.println(" ");
                    }
                    System.out.println("===================");
                    System.out.println("===================");

                    for (i = 0; i < matPadrao.length; i++) {
                        for (j = 0; j < matPadrao[0].length; j++) {
                            if (matPadrao[i][j] == matT[i][j]) {
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