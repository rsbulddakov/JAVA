package GU.Java;

public class Main {

    private static int sizeOne = 4;
    private static int sizeTwo = 4;

    public static void main(String[] args) {
	// write your code here
        doTask();
    }

    public static void doTask(){
        String arString[][] = {
                {"1", "2", "3", "4"},
                {"5", "six", "7", "-"},
                {"nine", "10", "11", "12"},
                {"13", "14", "15", "sixteen"}
        };

        checkArraySize(arString.length, sizeOne);
        for(int i = 0; i < arString.length; i++){
            checkArraySize(arString[i].length, sizeTwo);
        }
        System.out.println(summStringArray(arString));
    }

    public static void checkArraySize(int length, int size){
        if(length != sizeOne){
            String mess = String.format("Размер массива отличен от [%s][%s]", sizeOne, sizeTwo);
            throw new MyArraySizeException(mess);
        }
    }

    public static int summStringArray(String array[][]) {
        int summ = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    String mess = String.format("Не удалось привести строку к типу int. Позиция строки - array[%s][%s]", i, j);
                    throw new MyArrayDataException(mess, e);
                }
            }
        }
        return summ;
    }
}
