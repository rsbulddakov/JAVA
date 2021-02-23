package GU.Java;

import java.util.Random;
import java.util.Scanner;

public class TikTacToe {
    private static char playerChar = '0';
    private static char aiChar = 'X';
    private static int winCount = 4;

    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        char[][] field = createField();
        drawFiled(field);
        while (true) {
            if (!checkNextPlayerMove(field)) {
                return;
            }
            if (!checkNextAIMove(field)) {
                return;
            }
        }

    }

    static boolean checkNextPlayerMove(char[][] field) {
        doPlayerMove(field);
        drawFiled(field);
        return isNextMoveAvailable(field, playerChar, "Sorry, AI is winner!");
    }

    static boolean checkNextAIMove(char[][] field) {
        doAIMove(field);
        drawFiled(field);
        return isNextMoveAvailable(field, aiChar, "Congrats! You are winner!");
    }

    static boolean isWinNew(char[][] field, char sign) {
        boolean cols, rows, mainDiagonal, dopDiagonal;
        mainDiagonal = true;
        dopDiagonal = true;
        for (int i = 0; i < field.length; i++) {
            cols = true;
            rows = true;
            for (int row = 0; row < field.length; row++) {
                cols &= (field[i][row] == sign);
                rows &= (field[row][i] == sign);
            }
            if (cols || rows) return true;
            mainDiagonal &= (field[i][i] == sign);
            dopDiagonal &= (field[field.length - i - 1][i] == sign);
        }

        if (mainDiagonal || dopDiagonal) return true;

        return false;
    }

    static void doAIMove(char[][] field) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (isCellFree(field, x, y));

        field[x][y] = playerChar;
    }

    static void doPlayerMove(char[][] field) {
        Scanner scanner = new Scanner(System.in);
        int x, y;

        do {
            x = checkCoordinateRange(scanner, 'X');
            y = checkCoordinateRange(scanner, 'Y');
        } while (isCellFree(field, x, y));

        field[x][y] = aiChar;
    }

    static int checkCoordinateRange(Scanner scanner, char coordName) {
        int val;
        do {
            System.out.printf("Please input %s-coordinate in range [1-3]...", coordName);
            val = scanner.nextInt() - 1;
        } while (val < 0 || val > 3);
        return val;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static char[][] createField() {
        return new char[][]{
                {'-', '-', '-', '-'},
                {'-', '-', '-', '-'},
                {'-', '-', '-', '-'},
                {'-', '-', '-', '-'}
        };
    }

    static void drawFiled(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isCellFree(char[][] field, int x, int y) {
        return field[x][y] != '-';
    }

    static boolean isNextMoveAvailable(char[][] field, char sign, String winMessage) {
        if (isDraw(field)) {
            System.out.println("There is draw detected. Finish!");
            return false;
        }
        if (isWinNew(field, sign)) {
            System.out.println(winMessage);
            return false;
        }
        return true;
    }
}
