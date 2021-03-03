package GU.Java;

import java.util.Random;
import java.util.Scanner;

public class TikTacToe {
    private static int fieldSize = 5;
    private static int dotsToWin = 4;

    private static char emptyDot = '_';
    private static char playerChar = 'X';
    private static char aiChar = 'O';

    private static Scanner input = new Scanner(System.in);
    private static char[][] gameField;

    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        createField();
        drawFiled();
        while (true) {
            if (!checkNextPlayerMove()) {
                return;
            }
            if (!checkNextAIMove()) {
                return;
            }
        }

    }

    static boolean checkNextPlayerMove() {
        doPlayerMove();
        drawFiled();
        return isNextMoveAvailable(playerChar, "Sorry, AI is winner!");
    }

    static boolean checkNextAIMove() {
        doAIMove();
        drawFiled();
        return isNextMoveAvailable(aiChar, "Congrats! You are winner!");
    }

    public static boolean isWin(char playerDot) {
        int hor, ver;
        int diagMain, diagReverse;
        for (int i = 0; i < fieldSize; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < fieldSize; j++) {
                if (gameField[i][j] == playerDot) {
                    hor++;
                } else if (gameField[i][j] != playerDot && hor < dotsToWin) {
                    hor = 0;
                }
                if (gameField[j][i] == playerDot) {
                    ver++;
                }   else if (gameField[j][i] != playerDot && ver < dotsToWin) {
                    ver = 0;
                }
            }
            if (hor >= dotsToWin || ver >= dotsToWin) {
                return true;
            }
        }

        for (int j = 0; j < fieldSize; j++) {
            diagMain = 0;
            for (int i = 0; i < fieldSize; i++) {
                int k = j + i;
                if (k < fieldSize) {
                    if (gameField[i][k] == playerDot) {
                        diagMain++;
                    } else if (gameField[i][k] != playerDot && diagMain < dotsToWin) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= dotsToWin) {
                    return true;
                }
            }
        }
        for (int j = 1; j < fieldSize; j++) {
            diagMain = 0;
            for (int i = 0; i < fieldSize; i++) {
                int k = j + i;
                if (k < fieldSize) {
                    if (gameField[k][i] == playerDot) {
                        diagMain++;
                    } else if (gameField[k][i] != playerDot && diagMain < dotsToWin) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= dotsToWin) {
                    return true;
                }
            }
        }
        for (int j = 0; j < fieldSize; j++) {
            diagReverse = 0;
            for (int i = 0; i < fieldSize; i++) {
                int k = (fieldSize - 1) - i;
                int l = j + i;
                if (k >= 0 && l < fieldSize) {
                    if (gameField[l][k] == playerDot) {
                        diagReverse++;
                    } else if (gameField[l][k] != playerDot && diagReverse < dotsToWin) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= dotsToWin) {
                    return true;
                }
            }
        }
        for (int j = 1; j < fieldSize; j++) {
            diagReverse = 0;
            for (int i = 0; i < fieldSize; i++) {
                int k = (fieldSize - 1) - j - i;
                if (k >= 0) {
                    if (gameField[i][k] == playerDot) {
                        diagReverse++;
                    } else if (gameField[i][k] != playerDot && diagReverse < dotsToWin) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= dotsToWin) {
                    return true;
                }
            }
        }
        return false;
    }

    static void doAIMove() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(gameField.length);
            y = random.nextInt(gameField.length);
        } while (isCellFree(x, y));

        gameField[x][y] = playerChar;
    }

    static void doPlayerMove() {
        int x, y;

        do {
            x = checkCoordinateRange('X');
            y = checkCoordinateRange('Y');
        } while (isCellFree(x, y));

        gameField[x][y] = aiChar;
    }

    static int checkCoordinateRange(char coordName) {
        int val;
        do {
            System.out.printf("Please input %s-coordinate in range [1-%s]...", coordName, fieldSize);
            val = input.nextInt() - 1;
        } while (val < 0 || val > fieldSize);
        return val;
    }

    static boolean isDraw() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == emptyDot) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void createField() {
        gameField = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                gameField[i][j] = emptyDot;
            }
        }
    }

    static void drawFiled() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isCellFree(int x, int y) {
        return gameField[x][y] != emptyDot;
    }

    static boolean isNextMoveAvailable(char sign, String winMessage) {
        if (isDraw()) {
            System.out.println("There is draw detected. Finish!");
            return false;
        }
        if (isWin(sign)) {
            System.out.println(winMessage);
            return false;
        }
        return true;
    }
}
