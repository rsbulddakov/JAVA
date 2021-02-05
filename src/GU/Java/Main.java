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
    }
    public static void invertArray(){
        int[] array = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < array.length; i++){
            array[i] = ~array[i];
        }
        printArray(array);
    }

    public static void fillArray(){
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++){
            array[i] = i*3;
        }
        printArray(array);
    }

    public static void changeArray(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array.length; i++){
            if(array[i] < 6) array[i] *=2;
        }
        printArray(array);
    }

    public static void fillDiagonal(){
        int[][] array4 = new int[10][10];
        for (int i = 0; i < array4.length; i++){
            for (int j = 0; j < array4[i].length; j++){
                if(i == j || i + j == array4[i].length-1)
                    array4[i][j] = 1;
            }
        }
        printSquareArray(array4);
    }

    public static void findMiniMax(){
        int[] array = {1, 5, 3, 2, 11, 4, 13 ,5, -1, 2, 4, 8, 9, 1 };
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++){
            if(minValue > array[i]) minValue = array[i];
            if(maxValue < array[i]) maxValue = array[i];
        }
        System.out.println("min val: " + minValue + ", max val: " + maxValue);
    }

    public static boolean checkBalance(int[] array){
        int arrSumm = 0, curSumm = 0;
        for (int j = 0; j < array.length; j++){
            arrSumm += array[j];
        }
        for (int i = 0; i < array.length; i++){
            curSumm += array[i];
            if(curSumm == arrSumm - curSumm) return true;
        }
        return false;
    }

    //Вспомогательные методы

    //Вывод одномерного массива в строку в консоль
    public static void printArray(int[] ar){
        for (int i = 0; i < ar.length; i++){
            String str = i == 0 ? "" : ", ";
            System.out.print(str + ar[i]);
        }
        System.out.println();
    }

    //Вывод двумерного массива в строку и столбик в консоль
    public static void printSquareArray(int[][] ar){
        System.out.println();
        for (int i = 0; i < ar.length; i++){
            printArray(ar[i]);
        }
        System.out.println();
    }
}
