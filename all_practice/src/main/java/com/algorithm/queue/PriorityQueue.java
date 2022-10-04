package com.algorithm.queue;

import java.util.Arrays;


//最大优先队列
public class PriorityQueue {
    private int[] arr;
    private int size;

    public PriorityQueue() {
        this.size = 0;
        this.arr = new int[32];
    }
    private void enQueue(int key) {
        if (size >= arr.length) {
            resize();
        }
        arr[size++] = key;
        up();
    }

    private void resize () {
        int newSize = this.size * 2;
        this.arr = Arrays.copyOf(this.arr, newSize);
    }

    public void up () {
        int children = size - 1;
        int temp = arr[children];
        int parent = (children - 1) / 2;

        while (children > 0 && temp > arr[parent]) {
            arr[children] = arr[parent];
            children = parent;
            parent = (children - 1) / 2;
        }
        arr[children] = temp;
    }
    private int deQueue () throws Exception{
        if (size <= 0) {
            throw new Exception("队列为空！！！");
        }
        int head = arr[0];
        arr[0] = arr[--size];
        down();
        return head;
    }

    private void down () {
        int temp = arr[0];
        int parent = 0;
        int children = 1;
        while (children < size) {
            if (children + 1 < size && arr[children + 1] > arr[children]) {
                children++;
            }

            if (temp > arr[children]) {
                break;
            }

            arr[parent] = arr[children];
            parent = children;
            children = parent * 2 + 1;
        }

        arr[parent] = temp;
    }

    public static void main(String[] args) throws Exception{
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        priorityQueue.enQueue(7);

        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
    }
}
