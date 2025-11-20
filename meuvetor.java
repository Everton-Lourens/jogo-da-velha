// Aluno: Everton Lourenço da Silva (Apenas eu)
// Matrícula: 200040212
//////////////////
// https://github.com/Everton-Lourens/jogo-da-velha
// OBS::: NÃO FOI utilizado IA em hipótese alguma, pode olhar os "commits" enviados ao github.
//////////////////
/*
Olá, professor!
Fiz todo o código sem auxílio de IA, pode olhar os commits no meu GitHub:
https://github.com/Everton-Lourens/jogo-da-velha

Obs:: Na reunião com Osvaldo, ele falou para que eu mostrasse ao senhor que já sei programar, afinal eu já
dei essa aula antes, porém não foi possível dispensar sua aula esse semestre pelo fato de ter apenas
80 horas no curso anterior e sua aula ter 90 horas.
Deixei de ir pra sua aula achando que já poderia dispensar ela, mas me dei
mal...
Se o senhor quiser considerar o fato que sei programar para não me reprovar
por falta, vou ficar feliz, caso contrário, eu entendo não ser possível.

Obs2:: Eu trabalho como motoboy e pago minha própria faculdade, jamais iria
reprovar propositalmente e jogar dinheiro fora.
Desde já, agradeço.
 */

//package vetores;

import java.util.Scanner;

public class meuvetor {

    public static void main(String[] args) {
        // Inicializando scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Jogo da Velha =====");
        // Inicializando matriz padrão do jogo para o jogador escolher os números
        int matJogador[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        int i, j;
        // Controle de rodada
        int numJogador = -1;
        boolean jogoEncerrado = false;
        boolean deuVelha = false;

        mostrarJogo(matJogador);

        // Loop para o jogo acontecer
        for (i = 0; i < matJogador.length; i++) {
            for (j = 0; j < matJogador[0].length; j++) {

                for (i = 0; i < matJogador.length; i++) {
                    for (j = 0; j < matJogador[0].length; j++) {

                        // Conferindo se o jogo já foi encerrado (deu velha ou não resta opções para
                        // jogar)
                        if (jogoEncerrado == true) {
                            System.out.println("Jogo encerrado! Não há mais jogadas possíveis.");
                            if (deuVelha == true) {
                                System.out.println("===>>> DEU VELHA! <<<===");
                            } else {
                                System.out.println("===>>> JOGADOR " + (numJogador * -1) + " VENCEU! <<<===");
                            }
                            i = matJogador.length;
                            j = matJogador.length;
                            sc.close();
                            break;
                        }

                        System.out.println("========================");
                        System.out.println("É a vez do jogador " + (numJogador * -1));
                        System.out.println("Escolha um número:");

                        int inputJogador = sc.nextInt();

                        for (int x = 0; x < matJogador.length; x++) {
                            for (int y = 0; y < matJogador[0].length; y++) {
                                // Se o input do jogador for igual ao número da matriz, coloca -1 para o jogador
                                // 1 ou -2 para marcar
                                // a posição escolhida
                                if (inputJogador == matJogador[x][y]) {
                                    // Jogador 1 faz sua jogada:
                                    if (numJogador == -1) {
                                        // A escolha do primeiro jogador é marcada com '-1' na matriz
                                        matJogador[x][y] = -1;
                                        // Jogador 2 faz sua jogada:
                                    } else if (numJogador == -2) {
                                        // A escolha do primeiro jogador é marcada com '-2' na matriz
                                        matJogador[x][y] = -2;
                                    }
                                } else {
                                    // Não permite o jogo encerrar caso o jogador escolha um número inválido ou uma
                                    // letra
                                    i--;
                                    j--;
                                }

                            }

                        }
                        // Mostrando a matriz com a escolha do último jogador
                        mostrarJogo(matJogador);

                        // Confere se o jogo foi vencido pelo jogador atual
                        jogoEncerrado = conferirJogo(matJogador, numJogador);
                        if (jogoEncerrado == false) {
                            // Confere se ainda há opções para jogar ou se deu velha
                            jogoEncerrado = checkOpcoes(matJogador);
                            deuVelha = jogoEncerrado;
                        }
                        // Passa a vez para o outro jogador se o jogo não foi encerrado
                        if (jogoEncerrado == false) {
                            if (numJogador == -1) {
                                numJogador = -2;
                            } else {
                                numJogador = -1;
                            }
                        }
                    }
                }
            }
        }
        sc.close();
    }

    public static boolean conferirJogo(int matJogador[][], int numJogador) {
        boolean jogoEncerrado = false;
        if (jogoEncerrado == false) {
            jogoEncerrado = checkDiagEsquerDirei(matJogador, numJogador);
        }
        if (jogoEncerrado == false) {
            jogoEncerrado = checkDiagDireiEsquer(matJogador, numJogador);
        }
        if (jogoEncerrado == false) {
            jogoEncerrado = checkHorizEsquerDirei(matJogador, numJogador);
        }
        if (jogoEncerrado == false) {
            jogoEncerrado = checkVertEsquerDirei(matJogador, numJogador);
        }
        return jogoEncerrado;
    }

    public static boolean checkOpcoes(int mat[][]) {
        // Inicia a variável como verdadeira para conferir se há números restantes na
        // matriz
        boolean jogoEncerrado = true;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > 0) {
                    // Se houver algum número positivo, significa que ainda existe opções para jogar
                    // e o jogo não pode ser encerrado
                    jogoEncerrado = false;
                    break;
                }
            }
        }
        return jogoEncerrado;
    }

    public static void mostrarJogo(int mat[][]) {
        System.out.println("=========");
        // Mostrando a matriz padrão para os jogadores escolherem os números
        for (int i = 0; i < mat.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == -1) {
                    // Se a matriz tiver algum número '0', marca 'X' para indicar o jogador 1
                    if (mat[0].length == j + 1) {
                        System.out.print("X" + "|");
                    } else {
                        System.out.print("X" + "  ");
                    }
                } else if (mat[i][j] == -2) {
                    // Se a matriz tiver algum número '-1', marca 'O' para indicar o jogador 2

                    if (mat[0].length == j + 1) {
                        System.out.print("O" + "|");
                    } else {
                        System.out.print("O" + "  ");
                    }
                } else {
                    // Senão, mostra apenas os números restantes na matriz para os jogadores
                    // escolherem
                    if (mat[0].length == j + 1) {
                        System.out.print(mat[i][j] + "|");
                    } else {
                        System.out.print(mat[i][j] + "  ");
                    }
                }

            }
            System.out.println(" ");
        } // Encerra a exibição
        System.out.println("=========");
    }

    public static boolean checkDiagEsquerDirei(int mat[][], int num) {
        boolean identidade = true;
        // Confere se é identidade pela diagonal da esquerda para a direita, de cima
        // para baixo
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if ((i == j) && (mat[i][j] != num)) {
                    identidade = false;
                }

                /*
                 * Independente se for identidade ou não, se tiver 1's da diagonal, deve
                 * retornar true para mostrar que venceu o jogo
                 * if ((i != j) && (mat[i][j] != 0)) {
                 * identidade = false;
                 * }
                 */
            }
        }
        return identidade;
    }

    public static boolean checkDiagDireiEsquer(int mat[][], int num) {
        boolean identidade = true;
        // Confere se é identidade pela diagonal da direita para a esquerda, de cima
        // para baixo
        for (int i = 0; i < mat.length; i++) {
            for (int j = mat[0].length - 1; j >= 0; j--) {

                if ((mat[i][(mat[0].length - i) - 1] != num)) {
                    identidade = false;
                }

                /*
                 * Independente se for identidade ou não, se tiver 1's da diagonal, deve
                 * retornar true para mostrar que venceu o jogo
                 * if ((mat[i][j] != 0) && (j != (mat[0].length - i) - 1)) {
                 * identidade = false;
                 * }
                 */

            }
        }
        return identidade;
    }

    public static boolean checkHorizEsquerDirei(int mat[][], int num) {
        int count = 0;
        // Confere se é identidade pela horizontal da esquerda para a direita, de cima
        // para baixo
        for (int i = 0; i < mat.length; i++) {
            if (count == mat[0].length) {
                break;
            } else {
                count = 0;
            }
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == num) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count == mat[0].length;
    }

    public static boolean checkVertEsquerDirei(int mat[][], int num) {
        int count = 0;
        // Confere se é identidade pela vertical da esquerda para a direita, de cima
        // para baixo
        for (int i = 0; i < mat.length; i++) {
            if (count == mat.length) {
                break;
            } else {
                count = 0;
            }
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[j][i] == num) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count == mat.length;
    }
}
