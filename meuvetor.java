//package vetores;

import java.util.Scanner;

public class meuvetor {

    public static void main(String[] args) {
        // Inicializando scanner
        Scanner sc = new Scanner(System.in);
        // Inicializando matriz padrão do jogo para o jogador escolher os números
        /*
         * int matPadrao[][] = {
         * { 1, 2, 3 },
         * { 4, 5, 6 },
         * { 7, 8, 9 }
         * };
         */

        int matPadrao[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int i, j, x, y, t, k;
        boolean jogoEncerrado = false;
        // Controle de rodada
        int contarRodada = 1;

        System.out.println("======== Jogo da Velha ========");
        System.out.println("........... REGRAS ...........");
        System.out.println("- Cada jogador terá sua vez de jogar.");
        System.out.println("========================");
        for (x = 0; x < matPadrao.length; x++) {
            for (y = 0; y < matPadrao[0].length; y++) {
                System.out.print(matPadrao[x][y] + "  ");
            }
            System.out.println(" ");
        }

        for (i = 0; i < matPadrao.length; i++) {
            for (j = 0; j < matPadrao[0].length; j++) {

                for (i = 0; i < matPadrao.length; i++) {
                    for (j = 0; j < matPadrao[0].length; j++) {

                        if (jogoEncerrado == true) {
                            System.out.println("Jogo encerrado! Não há mais jogadas possíveis.");
                            i = matPadrao.length;
                            j = matPadrao.length;
                            sc.close();
                            break;
                        }

                        jogoEncerrado = true;
                        for (t = 0; t < matPadrao.length; t++) {
                            for (k = 0; k < matPadrao[0].length; k++) {
                                if (matPadrao[t][k] > 0) {
                                    jogoEncerrado = false;
                                }
                            }
                        }

                        if (contarRodada == 1) {
                            System.out.println("========================");
                            System.out.println("É a vez do jogador 1! (X)");
                            System.out.println("Escolha um número!");
                            int inputJogadorUm = sc.nextInt();

                            for (x = 0; x < matPadrao.length; x++) {
                                for (y = 0; y < matPadrao[0].length; y++) {
                                    // Se o input do jogador 1 for igual ao número da matriz, coloca '0' para marcar
                                    // a posição escolhida
                                    if (inputJogadorUm == matPadrao[x][y]) {
                                        // A escolha do primeiro jogador é marcada com '0' na matriz
                                        matPadrao[x][y] = 0;
                                        // Passa a vez para o jogador 2 caso o jogador 1 escolha um número válido
                                        contarRodada = 2;
                                    } else {
                                        // Não permite o jogo encerrar caso o jogador escolha um número inválido ou uma
                                        // letra
                                        i--;
                                        j--;
                                    }
                                    if (matPadrao[x][y] == 0) {
                                        // Se a matriz tiver algum número '0', marca 'X' para indicar o jogador 1
                                        System.out.print("X" + "  ");
                                    } else if (matPadrao[x][y] == -1) {
                                        // Se a matriz tiver algum número '-1', marca 'O' para indicar o jogador 2
                                        System.out.print("O" + "  ");
                                    } else {
                                        // Senão, mostra apenas os números restantes na matriz para os jogadores
                                        // escolherem
                                        System.out.print(matPadrao[x][y] + "  ");
                                    }
                                }
                                System.out.println(" ");
                            }

                        } else {
                            System.out.println("========================");
                            System.out.println("É a vez do jogador 2! (O)");
                            System.out.println("Escolha um número!");
                            int inputJogadorDois = sc.nextInt();

                            for (x = 0; x < matPadrao.length; x++) {
                                for (y = 0; y < matPadrao[0].length; y++) {
                                    // Se o input do jogador 2 for igual ao número da matriz, coloca '-1' para
                                    // marcar a posição escolhida
                                    if (inputJogadorDois == matPadrao[x][y]) {
                                        // A escolha do primeiro jogador é marcada com '-1' na matriz
                                        matPadrao[x][y] = -1;
                                        // Passa a vez para o jogador 1 caso o jogador 2 escolha um número válido
                                        contarRodada = 1;
                                    } else {
                                        // Não permite o jogo encerrar caso o jogador escolha um número inválido ou uma
                                        // letra
                                        i--;
                                        j--;
                                    }
                                    if (matPadrao[x][y] == 0) {
                                        // Se a matriz tiver algum número '0', marca 'X' para indicar o jogador 1
                                        System.out.print("X" + "  ");
                                    } else if (matPadrao[x][y] == -1) {
                                        // Se a matriz tiver algum número '-1', marca 'O' para indicar o jogador 2
                                        System.out.print("O" + "  ");
                                    } else {
                                        // Senão, mostra apenas os números restantes na matriz para os jogadores
                                        // escolherem
                                        System.out.print(matPadrao[x][y] + "  ");
                                    }
                                }
                                System.out.println(" ");
                            }
                        }
                        //////////
                        if (matPadrao[0][0] == 0 && matPadrao[0][1] == 0 && matPadrao[0][2] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        if (matPadrao[1][0] == 0 && matPadrao[1][1] == 0 && matPadrao[1][2] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        if (matPadrao[2][0] == 0 && matPadrao[2][1] == 0 && matPadrao[2][2] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][0] == 0 && matPadrao[1][0] == 0 && matPadrao[2][0] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][1] == 0 && matPadrao[1][1] == 0 && matPadrao[2][1] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][2] == 0 && matPadrao[1][2] == 0 && matPadrao[2][2] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][0] == 0 && matPadrao[1][1] == 0 && matPadrao[2][2] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][2] == 0 && matPadrao[1][1] == 0 && matPadrao[2][0] == 0) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
                        }
                        //////////
                        if (matPadrao[0][0] == -1 && matPadrao[0][1] == -1 && matPadrao[0][2] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        if (matPadrao[1][0] == -1 && matPadrao[1][1] == -1 && matPadrao[1][2] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        if (matPadrao[2][0] == -1 && matPadrao[2][1] == -1 && matPadrao[2][2] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][0] == -1 && matPadrao[1][0] == -1 && matPadrao[2][0] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][1] == -1 && matPadrao[1][1] == -1 && matPadrao[2][1] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][2] == -1 && matPadrao[1][2] == -1 && matPadrao[2][2] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][0] == -1 && matPadrao[1][1] == -1 && matPadrao[2][2] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        if (matPadrao[0][2] == -1 && matPadrao[1][1] == -1 && matPadrao[2][0] == -1) {
                            jogoEncerrado = true;
                            System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
                        }
                        ///
                    }
                }

                System.out.println("===================");

            }
        }
        sc.close();
    }
}