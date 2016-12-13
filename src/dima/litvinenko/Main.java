package dima.litvinenko;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static int bubbleSort(int [] arr, boolean asc){

        int itereations=0;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (asc){
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }else{
                    if (arr[i] < arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
                itereations++;
            }
        }
        return itereations;
    }

    public static void quickSort ( int[]array,int begin, int end)
    {
        int left = begin, right = end;
        int middleTemp = array[(left + right) / 2];

        while (left <= right)
        {
            while (array[left] < middleTemp) left++;
            while (array[right] > middleTemp) right--;

            if (left <= right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        if (begin < right) quickSort (array, begin, right);
        if (end > left) quickSort (array, left, end);
    }



    public static void fillWithRandomValues(int[] array){
        Random random = new Random(System.currentTimeMillis());
        for (int i=0;i<array.length;i++){
            array[i]=random.nextInt(array.length);
        }
    }


    public static void main(String[] args) {

        int size=100;
        int [] array= new int[size];
        int [] arrayCopy=new int[size];

        fillWithRandomValues(array);
        //fillWithRandomValues(arrayCopy);
        for (int i = 0; i < arrayCopy.length; i++) arrayCopy[i]=array[i];

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("The number of iterations  is: " + bubbleSort(arrayCopy, true) +
                ", and size*(size-1)/2 = "+(size*(size-1)/2));
        //quickSort(arrayCopy,0,arrayCopy.length-1);
        System.out.println(Arrays.toString(arrayCopy));



    }
}
