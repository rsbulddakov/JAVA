package GU.Java;

import java.util.Random;
import java.util.Scanner;

public class TikTacToe {
    public static int FIELD_SIZE = 5;         // размер игрового поля
    public static int DOTS_TO_WIN = 4;        // сколько ячеек нужно подряд заполнить, чтобы победить

    public static char EMPTY_DOT = '_';
    public static char PLAYER_CHAR = 'X';
    public static char AI_CHAR = 'O';

    public static Scanner input = new Scanner(System.in);
    public static char[][] gameField;

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
        return isNextMoveAvailable(PLAYER_CHAR, "Sorry, AI is winner!");
    }

    static boolean checkNextAIMove() {
        doAIMove();
        drawFiled();
        return isNextMoveAvailable(AI_CHAR, "Congrats! You are winner!");
    }

    public static boolean isWin(char playerDot) {
        int hor, ver;
        int diagMain, diagReverse;
        for (int i = 0; i < FIELD_SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (gameField[i][j] == playerDot) {
                    hor++;
                } else if (gameField[i][j] != playerDot && hor < DOTS_TO_WIN) {
                    hor = 0;
                }
                if (gameField[j][i] == playerDot) {
                    ver++;
                }   else if (gameField[j][i] != playerDot && ver < DOTS_TO_WIN) {
                    ver = 0;
                }
            }
            if (hor >= DOTS_TO_WIN || ver >= DOTS_TO_WIN) {
                return true;
            }
        }

        for (int j = 0; j < FIELD_SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (gameField[i][k] == playerDot) {
                        diagMain++;
                    } else if (gameField[i][k] != playerDot && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (gameField[k][i] == playerDot) {
                        diagMain++;
                    } else if (gameField[k][i] != playerDot && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 0; j < FIELD_SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < FIELD_SIZE) {
                    if (gameField[l][k] == playerDot) {
                        diagReverse++;
                    } else if (gameField[l][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - j - i;
                if (k >= 0) {
                    if (gameField[i][k] == playerDot) {     // проверяем побочную диагональ от центральной оси влево на возможную победу
                        diagReverse++;
                    } else if (gameField[i][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
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

        gameField[x][y] = PLAYER_CHAR;
    }

    static void doPlayerMove() {
        int x, y;

        do {
            x = checkCoordinateRange('X');
            y = checkCoordinateRange('Y');
        } while (isCellFree(x, y));

        gameField[x][y] = AI_CHAR;
    }

    static int checkCoordinateRange(char coordName) {
        int val;
        do {
            System.out.printf("Please input %s-coordinate in range [1-%s]...", coordName, FIELD_SIZE);
            val = input.nextInt() - 1;
        } while (val < 0 || val > FIELD_SIZE);
        return val;
    }

    static boolean isDraw() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void createField() {
        gameField = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                gameField[i][j] = EMPTY_DOT;
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
        return gameField[x][y] != EMPTY_DOT;
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
