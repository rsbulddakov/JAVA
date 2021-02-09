package GU.Java;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //Ex1
        invertArray();

        //Ex2
        fillArray();

        //Ex3
        changeArray();

        //Ex4
        fillDiagonal();

        //Ex5
        findMiniMax();

        //Ex6
        int[] array6 = {1, 1, 1, 1, 1, 5};
        System.out.println(checkBalance(array6));

        int[] array7 = {1, 1, 1, 1, 1, 0, 1, 5};
        System.out.println(checkBalance(array7));

        int[] array8 = {1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 3, 5};
        System.out.println(checkBalance(array8));

        int[] array9 = {5, 1, 1, 1, 1, 1};
        System.out.println(checkBalance(array9));

        //Ex7
        int[] array10 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        moveArray(array10, -12);

        int[] array11 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        moveArray(array11, -4);

        int[] array12 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        moveArray(array12, 3);

        int[] array13 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        moveArray(array13, 11);
    }
    public static void invertArray() {
        int[] array = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
        printArray(array);
    }

    public static void fillArray() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i*3;
        }
        printArray(array);
    }

    public static void changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6) array[i] *=2;
        }
        printArray(array);
    }

    public static void fillDiagonal() {
        int[][] array4 = new int[10][10];
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                if(i == j || i + j == array4[i].length-1)
                    array4[i][j] = 1;
            }
        }
        printSquareArray(array4);
    }

    public static void findMiniMax() {
        int[] array = {1, 5, 3, 2, 11, 4, 13 ,5, -1, 2, 4, 8, 9, 1 };
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if(minValue > array[i]) minValue = array[i];
            if(maxValue < array[i]) maxValue = array[i];
        }
        System.out.println("min val: " + minValue + ", max val: " + maxValue);
    }

    public static boolean checkBalance(int[] array) {
        int arrSumm = 0, curSumm = 0;
        for (int j = 0; j < array.length; j++) {
            arrSumm += array[j];
        }
        for (int i = 0; i < array.length; i++) {
            curSumm += array[i];
            if(curSumm == arrSumm - curSumm) return true;
        }
        return false;
    }

    public static void moveArray(int[] arr, int step) {
        int optStep = getOptimalStep(step, arr.length);
        printArray(arr);
        System.out.println("Сдвиг на " + step);
        if(step < 0){
            for (int i = optStep; i < 0; i++) {
                rightMove(arr);
            }
        } else {
            for (int i = 0; i < optStep; i++) {
                leftMove(arr);
            }
        }
        printArray(arr);
    }

    //Вспомогательные методы

    //Вывод одномерного массива в строку в консоль
    public static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            String str = i == 0 ? "" : ", ";
            System.out.print(str + ar[i]);
        }
        System.out.println();
    }

    //Вывод двумерного массива в строку и столбик в консоль
    public static void printSquareArray(int[][] ar) {
        System.out.println();
        for (int i = 0; i < ar.length; i++) {
            printArray(ar[i]);
        }
        System.out.println();
    }

    //Сдвиг массива вправо
    public static void rightMove(int[] array) {
        int temp = array[0];
        for (int i = 0; i <  array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[array.length - 1] = temp;
    }

    //Сдвиг массива влево
    public static void leftMove(int[] array) {
        int temp = array[array.length - 1];
        for (int i = array.length-1; i > 0 ; i--) {
            array[i] = array[i-1];
        }
        array[0] = temp;
    }

    //Получение оптимального шага для сдвига
    public static int getOptimalStep(int step, int length) {
        if(Math.abs(step) > length){
            return step%length;
        } else {
            return step;
        }
    }
}
