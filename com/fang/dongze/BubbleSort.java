package com.fang.dongze;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array){
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {15 , 43 , 31 ,54 ,65};
        System.out.println("排序前的数组为："+ Arrays.toString(array));
        for (int i = 0; i < array.length-1; i++) {
            for(int j =0 ; j< array.length-1-i ; j++){
                if (array[j+1]-array[j]>0){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp ;
                }
            }
        }
        System.out.println("======================");
        System.out.println("排序后的数组为："+Arrays.toString(array));

        System.out.println("==========================");
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(array);
        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }


}
