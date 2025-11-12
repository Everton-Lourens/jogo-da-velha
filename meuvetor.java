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
        int i, j, x, y, pontuacao = 0;
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

                        if (contarRodada == 1) {
                            System.out.println("========================");
                            System.out.println("É a vez do jogador 1! (X)");
                            System.out.println("Escolha um número!");
                            int inputJogadorUm = sc.nextInt();

                            for (x = 0; x < matPadrao.length; x++) {
                                for (y = 0; y < matPadrao[0].length; y++) {
                                    // Se o input do jogador 1 for igual ao número da matriz, coloca '0' para marcar a posição escolhida
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
                                    // Senão, mostra apenas os números restantes na matriz para os jogadores escolherem
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
                                    // Se o input do jogador 2 for igual ao número da matriz, coloca '-1' para marcar a posição escolhida
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
                                    // Senão, mostra apenas os números restantes na matriz para os jogadores escolherem
                                        System.out.print(matPadrao[x][y] + "  ");
                                    }
                                }
                                System.out.println(" ");
                            }
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