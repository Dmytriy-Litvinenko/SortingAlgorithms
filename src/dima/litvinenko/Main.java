package dima.litvinenko;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    static long quickIterationsCounter;

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
            //System.out.println(Arrays.toString(arr));
        }
        return itereations;
    }

    public static void quickSort ( int[]array,int begin, int end)
    {

        int left = begin, right = end;
        int middleTemp = array[(left + right) / 2];

        while (left <= right)
        {
            while (array[left] < middleTemp) {left++;quickIterationsCounter++;}
            while (array[right] > middleTemp) {right--;quickIterationsCounter++;}

            if (left <= right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
                quickIterationsCounter++;
                //System.out.println(Arrays.toString(array)+", b = " +begin+", l = " + left +", r = "+right+", e = "+end+", middleTemp = " + middleTemp);
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

        int size=10;
        int [] array= new int[size];
        int [] arrayForQuickSort=new int[size];

        fillWithRandomValues(array);
        for (int i = 0; i < arrayForQuickSort.length; i++) arrayForQuickSort[i]=array[i];

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayForQuickSort));

        System.out.println("\tQuickSort algorithm");
        quickIterationsCounter=0;
        long startTimeQuickSort = System.currentTimeMillis();
        quickSort(arrayForQuickSort,0,arrayForQuickSort.length-1);
        long stopTimeQuickSort = System.currentTimeMillis();
        long elapsedTimeQuickSort = stopTimeQuickSort - startTimeQuickSort;
        System.out.println("The number of iterations  is: " + quickIterationsCounter +
                ",\nsize*Ln(size) = " + (long)Math.ceil(size*Math.log(size))
                + ",\nelapsed time = " + elapsedTimeQuickSort
                +" ms,\nelapsedTime/iterations=" + ((double)elapsedTimeQuickSort/quickIterationsCounter)
                + "\nsorted array: " + Arrays.toString(arrayForQuickSort)
        );
        //System.out.println(Arrays.toString(arrayForQuickSort));

        System.out.println("\tBubbleSort algorithm:\n");
        long startTimeBubble = System.currentTimeMillis();
        int bubbleSortIterations = bubbleSort(array, true);
        long stopTimeBubble = System.currentTimeMillis();
        long elapsedTimeBubble = stopTimeBubble - startTimeBubble;

        System.out.println("The number of iterations  is: " + bubbleSortIterations +
                ",\nsize*(size-1)/2 = " + (size*(size-1)/2)
                + ",\nelapsed time = " + elapsedTimeBubble +" ms.\n"+
                "elapsedTime/iterations=" +((double)elapsedTimeBubble/bubbleSortIterations)
        );
        System.out.println(Arrays.toString(array));
    }
}
