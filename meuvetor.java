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

public class meuvetor {
    public static void main(String[] args) {
        boolean identidade = true;
        int mat[][] = {
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
        };
        identidade = checkDireitaEsquerda(mat);
        identidade = checkEsquerdaDireita(mat);

        if (identidade == false) {
            System.out.println("\n@@@@@@@ NÃO é identidade!");
        } else {
            System.out.println("\n@@@ É identidade!");
        }

        /*
         * if (matPadrao[0][0] == 0 && matPadrao[0][1] == 0 && matPadrao[0][2] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * if (matPadrao[1][0] == 0 && matPadrao[1][1] == 0 && matPadrao[1][2] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * if (matPadrao[2][0] == 0 && matPadrao[2][1] == 0 && matPadrao[2][2] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][0] == 0 && matPadrao[1][0] == 0 && matPadrao[2][0] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][1] == 0 && matPadrao[1][1] == 0 && matPadrao[2][1] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][2] == 0 && matPadrao[1][2] == 0 && matPadrao[2][2] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][0] == 0 && matPadrao[1][1] == 0 && matPadrao[2][2] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][2] == 0 && matPadrao[1][1] == 0 && matPadrao[2][0] == 0) {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 1 venceu! @@@@@@@@");
         * }
         * //////////
         * if (matPadrao[0][0] == -1 && matPadrao[0][1] == -1 && matPadrao[0][2] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         * if (matPadrao[1][0] == -1 && matPadrao[1][1] == -1 && matPadrao[1][2] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         * if (matPadrao[2][0] == -1 && matPadrao[2][1] == -1 && matPadrao[2][2] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][0] == -1 && matPadrao[1][0] == -1 && matPadrao[2][0] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][1] == -1 && matPadrao[1][1] == -1 && matPadrao[2][1] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][2] == -1 && matPadrao[1][2] == -1 && matPadrao[2][2] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][0] == -1 && matPadrao[1][1] == -1 && matPadrao[2][2] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         * if (matPadrao[0][2] == -1 && matPadrao[1][1] == -1 && matPadrao[2][0] == -1)
         * {
         * jogoEncerrado = true;
         * System.out.println("@@@@@@@@ Jogador 2 venceu! @@@@@@@@");
         * }
         */

    }

    public static boolean checkEsquerdaDireita(int mat[][]) {
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

    public static boolean checkDireitaEsquerda(int mat[][]) {
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

}