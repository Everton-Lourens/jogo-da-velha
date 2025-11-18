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
        System.out.println("========");
        // Inicializando matriz padrão do jogo para o jogador escolher os números
        int matPadrao[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };
        int matJogadorUm[][] = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };

        int matJogadorDois[][] = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };

        int i, j, x, y, t, k;
        // Controle de rodada
        int contarRodada = 1;
        boolean jogoEncerrado = false;

        // Mostrando a matriz padrão para os jogadores escolherem os números
        for (x = 0; x < matPadrao.length; x++) {
            for (y = 0; y < matPadrao[0].length; y++) {
                System.out.print(matPadrao[x][y] + "  ");
            }
            System.out.println(" ");
        } // Encerra a exibição

        // Loop para o jogo acontecer
        for (i = 0; i < matPadrao.length; i++) {
            for (j = 0; j < matPadrao[0].length; j++) {

                for (i = 0; i < matPadrao.length; i++) {
                    for (j = 0; j < matPadrao[0].length; j++) {

                        // Conferindo se o jogo já foi encerrado (deu velha ou não resta opções para
                        // jogar)
                        if (jogoEncerrado == true) {
                            System.out.println("Jogo encerrado! Não há mais jogadas possíveis.");
                            i = matPadrao.length;
                            j = matPadrao.length;
                            sc.close();
                            break;
                        }

                        // Jogador 1 faz sua jogada
                        if (contarRodada == 1) {
                            System.out.println("========");
                            System.out.println("========================");
                            System.out.println("É a vez do jogador 1! (X)");
                            System.out.println("Escolha um número!");
                            int inputJogadorUm = sc.nextInt();
                            System.out.println("========");
                            for (x = 0; x < matPadrao.length; x++) {
                                for (y = 0; y < matPadrao[0].length; y++) {
                                    // Se o input do jogador 1 for igual ao número da matriz, coloca '0' para marcar
                                    // a posição escolhida
                                    if (inputJogadorUm == matPadrao[x][y]) {
                                        // A escolha do primeiro jogador é marcada com '0' na matriz
                                        matPadrao[x][y] = 0;
                                        matJogadorUm[x][y] = 1;
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
                            System.out.println("========");

                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkDiagEsquerDirei(matJogadorUm);
                            }
                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkDiagDireiEsquer(matJogadorUm);
                            }
                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkHorizEsquerDirei(matJogadorUm);
                            }
                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkVertEsquerDirei(matJogadorUm);
                            }
                            if (jogoEncerrado == true) {
                                System.out.println("Jogador 1 (X) venceu!");
                            }

                            // Jogador 2 faz sua jogada
                        } else if (contarRodada == 2) {
                            System.out.println("========================");
                            System.out.println("É a vez do jogador 2! (O)");
                            System.out.println("Escolha um número!");
                            int inputJogadorDois = sc.nextInt();
                            System.out.println("========");
                            for (x = 0; x < matPadrao.length; x++) {
                                for (y = 0; y < matPadrao[0].length; y++) {
                                    // Se o input do jogador 2 for igual ao número da matriz, coloca '-1' para
                                    // marcar a posição escolhida
                                    if (inputJogadorDois == matPadrao[x][y]) {
                                        // A escolha do primeiro jogador é marcada com '-1' na matriz
                                        matPadrao[x][y] = -1;
                                        matJogadorDois[x][y] = 1;
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
                            System.out.println("========");
                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkDiagEsquerDirei(matJogadorDois);
                            }
                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkDiagDireiEsquer(matJogadorDois);
                            }
                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkHorizEsquerDirei(matJogadorDois);
                            }
                            if (jogoEncerrado == false) {
                                jogoEncerrado = checkVertEsquerDirei(matJogadorDois);
                            }
                            if (jogoEncerrado == true) {
                                System.out.println("Jogador 2 (O) venceu!");
                            }
                        }

                        if (jogoEncerrado == false) {
                            // Inicia a variável como verdadeira para conferir se há números restantes na
                            // matriz
                            jogoEncerrado = true;
                            for (t = 0; t < matPadrao.length; t++) {
                                for (k = 0; k < matPadrao[0].length; k++) {
                                    if (matPadrao[t][k] > 0) {
                                        // Se houver algum número positivo, significa que ainda existe opções para jogar
                                        // e o jogo não pode ser encerrado
                                        jogoEncerrado = false;
                                    } else {
                                        System.out.println("Deu velha! Ninguém venceu.");
                                    }
                                }
                            }
                        }

                    }
                }
                System.out.println("===================");
            }
        }
        sc.close();
    }

    public static boolean checkDiagEsquerDirei(int mat[][]) {
        boolean identidade = true;
        // Confere se é identidade pela diagonal da esquerda para a direita, de cima
        // para baixo
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if ((i == j) && (mat[i][j] != 1)) {
                    identidade = false;
                }

                if ((i != j) && (mat[i][j] != 0)) {
                    identidade = false;
                }
            }
        }
        return identidade;
    }

    public static boolean checkDiagDireiEsquer(int mat[][]) {
        boolean identidade = true;
        // Confere se é identidade pela diagonal da direita para a esquerda, de cima
        // para baixo
        for (int i = 0; i < mat.length; i++) {
            for (int j = mat[0].length - 1; j >= 0; j--) {

                if ((mat[i][(mat[0].length - i) - 1] != 1)) {
                    identidade = false;
                }

                if ((mat[i][j] != 0) && (j != (mat[0].length - i) - 1)) {
                    identidade = false;
                }

            }
        }
        return identidade;
    }

    public static boolean checkHorizEsquerDirei(int mat[][]) {
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
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count == mat[0].length;
    }

    public static boolean checkVertEsquerDirei(int mat[][]) {
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
                if (mat[j][i] == 1) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count == mat.length;
    }
}
