package com.algorithm.sort;

import java.util.Arrays;

//堆排序，从小到大,大顶堆
public class Heap_sort {
    public static void heapSort (int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            down(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            down(arr, 0, i);
        }
    }

    public static void down (int[] arr, int parent, int len) {
        int temp = arr[parent];
        int children = parent * 2 + 1;
        while (children < len) {
            if (children + 1 < len && arr[children + 1] < arr[children]) {
                children++;
            }
            if (temp <= arr[children]) {
                break;
            }
            arr[parent] = arr[children];
            parent = children;
            children = 2 * parent + 1;
        }
        arr[parent] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
