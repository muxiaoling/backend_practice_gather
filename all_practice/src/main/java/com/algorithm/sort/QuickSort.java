package com.algorithm.sort;


import java.util.Arrays;

//快速排序，从小到大, 递归方法
public class QuickSort {
    public static void quick_sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int temp = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }

            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        quick_sort(arr, left, i - 1);
        quick_sort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1, 1, 3, 5, 4, 6, 9, 7, 8, 5};
        quick_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
