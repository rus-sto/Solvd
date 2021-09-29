import java.util.Arrays;

public class FirstHW {
    /*
Создать массив из 10 рандомных чисел
 И сделать его сортировку ВСТАВКАМИ
      */
    public static void main(String[] args) {
        int[] array = new int[10];
        createArray(array);
        System.out.println(Arrays.toString(array));
        sortArray(array);
        System.out.println();
        System.out.println(Arrays.toString(array));
    }

    public static int[] createArray(int[] array) {
        for (int i = 0; i < array.length; i ++){
            array [i] = (int)(Math.random()*15);//чтобы избежать диких чисел ограничил рандомность от 0 до 15
        }
        return array;
    }

    public static int [] sortArray (int []array){
        for (int i = 0; i < array.length; i ++){
            int value = array[i];
            int j;
            for (j = i-1; j >= 0; j--){
                if (value<array[j]) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array [j+1] = value;
        }
        return array;
    }
}
